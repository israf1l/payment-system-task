package az.akart.mspayments.error;

import static az.akart.mspayments.error.ExceptionConstants.CUSTOMER_NOT_FOUND;
import static az.akart.mspayments.error.ExceptionConstants.FAILED_OPERATION;
import static az.akart.mspayments.error.ExceptionConstants.INSUFFICIENT_BALANCE;
import static az.akart.mspayments.error.ExceptionConstants.NO_SUCH_TRANSACTION;
import static az.akart.mspayments.error.ExceptionConstants.REVERSAL_AMOUNT_EXCEEDS_ORIGINAL_AMOUNT;
import static az.akart.mspayments.model.enums.TransactionStatus.FAIL;

import az.akart.mspayments.error.dto.ErrorResponse;
import az.akart.mspayments.error.exceptions.CustomerNotFoundException;
import az.akart.mspayments.error.exceptions.FailedOperationException;
import az.akart.mspayments.error.exceptions.InsufficientBalanceException;
import az.akart.mspayments.error.exceptions.NoSuchTransactionException;
import az.akart.mspayments.error.exceptions.ReversalAmountExceedsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {


  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<ErrorResponse> handle(CustomerNotFoundException e) {
    return new ResponseEntity<>(ErrorResponse.builder()
        .status(FAIL)
        .message(CUSTOMER_NOT_FOUND)
        .build(),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InsufficientBalanceException.class)
  public ResponseEntity<ErrorResponse> handle(InsufficientBalanceException e) {
    return new ResponseEntity<>(ErrorResponse.builder()
        .status(FAIL)
        .message(INSUFFICIENT_BALANCE)
        .build(),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(FailedOperationException.class)
  public ResponseEntity<ErrorResponse> handle(FailedOperationException e) {
    return new ResponseEntity<>(ErrorResponse.builder()
        .status(FAIL)
        .message(FAILED_OPERATION)
        .build(),
        HttpStatus.OK);
  }

  @ExceptionHandler(NoSuchTransactionException.class)
  public ResponseEntity<ErrorResponse> handle(NoSuchTransactionException e) {
    return new ResponseEntity<>(ErrorResponse.builder()
        .status(FAIL)
        .message(NO_SUCH_TRANSACTION)
        .build(),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ReversalAmountExceedsException.class)
  public ResponseEntity<ErrorResponse> handle(ReversalAmountExceedsException e) {
    return new ResponseEntity<>(ErrorResponse.builder()
        .status(FAIL)
        .message(REVERSAL_AMOUNT_EXCEEDS_ORIGINAL_AMOUNT)
        .build(),
        HttpStatus.BAD_REQUEST);
  }

}
