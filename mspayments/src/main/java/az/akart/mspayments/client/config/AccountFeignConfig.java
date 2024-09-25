package az.akart.mspayments.client.config;

import az.akart.mspayments.client.error.AccountErrorDecoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class AccountFeignConfig {

  @Bean
  public ErrorDecoder errorDecoder(ObjectMapper objectMapper) {
    return new AccountErrorDecoder(objectMapper) {
    };
  }

}
