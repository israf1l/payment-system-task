package az.akart.gateway.filter;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    private final WebClient.Builder webClientBuilder;

    @Value("${auth.uri}")
    private String authUri;

    public AuthFilter(WebClient.Builder webClientBuilder) {
        super(Config.class);
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            List<String> authorizationHeaders = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);

            if (authorizationHeaders == null || authorizationHeaders.isEmpty()) {
                return this.onError(exchange, HttpStatus.UNAUTHORIZED);
            }

            String authHeader = authorizationHeaders.get(0);
            String[] parts = authHeader.split(" ");

            if (parts.length != 2 || !"Bearer".equals(parts[0])) {
                return this.onError(exchange, HttpStatus.UNAUTHORIZED);
            }

            String token = parts[1];

            return webClientBuilder.build()
                .get()
                .uri(authUri + "/auth/check?token=" + token)
                .header(HttpHeaders.AUTHORIZATION, authHeader)
                .retrieve()
                .bodyToMono(Boolean.class)
                .flatMap(isValid -> {
                    if (Boolean.TRUE.equals(isValid)) {
                        return chain.filter(exchange);
                    } else {
                        return this.onError(exchange, HttpStatus.UNAUTHORIZED);
                    }
                })
                .onErrorResume(e -> {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                });
        };
    }

    private Mono<Void> onError(ServerWebExchange exchange, HttpStatus httpStatus) {
        exchange.getResponse().setStatusCode(httpStatus);
        return exchange.getResponse().setComplete();
    }

    public static class Config {}

}
