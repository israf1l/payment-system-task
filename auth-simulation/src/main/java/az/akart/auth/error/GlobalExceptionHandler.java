package az.akart.auth.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(InvalidCredentialsException.class)
  public ResponseEntity<String> handleInvalidCredentials(InvalidCredentialsException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
  }

}