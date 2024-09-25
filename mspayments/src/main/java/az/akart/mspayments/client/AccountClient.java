package az.akart.mspayments.client;

import az.akart.mspayments.client.config.AccountFeignConfig;
import az.akart.mspayments.client.model.response.AccountResponse;
import az.akart.mspayments.model.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
    name = "account-client",
    url = "${client.account.url}",
    configuration = AccountFeignConfig.class
)
public interface AccountClient {

  @PostMapping("/balance/debit")
  AccountResponse debit(PaymentRequest request);

  @PostMapping("/balance/credit")
  AccountResponse credit(PaymentRequest request);

}
