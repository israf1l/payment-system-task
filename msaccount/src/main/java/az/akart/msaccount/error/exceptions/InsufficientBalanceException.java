package az.akart.msaccount.error.exceptions;

public class InsufficientBalanceException extends RuntimeException {

  public InsufficientBalanceException(Long customerId) {
    super("Insufficient balance for Customer ID: " + customerId);

  }

}
