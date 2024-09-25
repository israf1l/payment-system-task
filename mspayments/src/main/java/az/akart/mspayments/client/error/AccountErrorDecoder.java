package az.akart.mspayments.client.error;

import static az.akart.mspayments.error.ExceptionConstants.INSUFFICIENT_BALANCE;

import az.akart.mspayments.error.dto.ErrorResponse;
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

      if (INSUFFICIENT_BALANCE.equals(error.message())) {
        return new InsufficientBalanceException();
      }
    } catch (Exception e) {
      return new RuntimeException("Error decoding Account response");
    }
    return new RuntimeException("Error decoding Account response");
  }

}
