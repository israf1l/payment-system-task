package az.akart.msaccount.error.exceptions;

public class CustomerNotFoundException extends RuntimeException{

  public CustomerNotFoundException(Long customerId) {
    super("Customer not found with ID: " + customerId);
  }

}
