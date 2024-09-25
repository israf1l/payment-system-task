package az.akart.mspayments.error.exceptions;

public class CustomerNotFoundException extends RuntimeException{

  public CustomerNotFoundException(Long customerId) {
    super("Customer not found with ID: " + customerId);
  }

}
