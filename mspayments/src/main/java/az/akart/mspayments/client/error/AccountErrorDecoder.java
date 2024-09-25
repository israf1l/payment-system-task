package az.akart.mspayments.client.error;

import static az.akart.mspayments.error.ExceptionConstants.CUSTOMER_NOT_FOUND;
import static az.akart.mspayments.error.ExceptionConstants.INSUFFICIENT_BALANCE;

import az.akart.mspayments.error.dto.ErrorResponse;
import az.akart.mspayments.error.exceptions.CustomerNotFoundException;
import az.akart.mspayments.error.exceptions.InsufficientBalanceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountErrorDecoder implements ErrorDecoder {

  private final ObjectMapper objectMapper;

  @Override
  public Exception decode(String s, Response response) {
    try {
      ErrorResponse error =
          objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);

      System.out.println(error);
      if (INSUFFICIENT_BALANCE.equals(error.message())) {
        return new InsufficientBalanceException();
      }

      if (CUSTOMER_NOT_FOUND.equals(error.message())) {
        return new CustomerNotFoundException();
      }

    } catch (Exception e) {
      return new RuntimeException("Error decoding Account response" + e.getMessage(), e);
    }
    return new RuntimeException("Error decoding Account response");
  }

}
