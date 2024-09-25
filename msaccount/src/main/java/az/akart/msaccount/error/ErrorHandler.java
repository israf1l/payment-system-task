package az.akart.msaccount.error;

import static az.akart.msaccount.error.ExceptionConstants.CUSTOMER_NOT_FOUND;
import static az.akart.msaccount.error.ExceptionConstants.INSUFFICIENT_BALANCE;
import static az.akart.msaccount.model.enums.Status.FAIL;

import az.akart.msaccount.error.dto.ErrorResponse;
import az.akart.msaccount.error.exceptions.CustomerNotFoundException;
import az.akart.msaccount.error.exceptions.InsufficientBalanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(InsufficientBalanceException.class)
  public ResponseEntity<ErrorResponse> handle(InsufficientBalanceException e) {
    return new ResponseEntity<>(ErrorResponse.builder()
        .status(FAIL)
        .message(INSUFFICIENT_BALANCE)
        .build(),
        HttpStatus.OK);
  }

  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<ErrorResponse> handle(CustomerNotFoundException e) {
    return new ResponseEntity<>(ErrorResponse.builder()
        .status(FAIL)
        .message(CUSTOMER_NOT_FOUND)
        .build(),
        HttpStatus.OK);
  }

}
