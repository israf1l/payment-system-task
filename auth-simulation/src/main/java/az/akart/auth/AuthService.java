package az.akart.auth;

import az.akart.auth.error.InvalidCredentialsException;
import az.akart.auth.request.AuthRequest;
import az.akart.auth.response.AuthResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private static final String jwtToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIrOTk0NTA0MDc0OTk1IiwiYXVkX3R5cGUiOiJVU0VSIiwidHlwZSI6IkFDQ0VTUyIsImlkIjoyNTI4MTMzLCJndWlkIjoiNzYwNkY4OTk3RkU3NDk4NEE2MDUzQTdCODcyNDc5OTciLCJjbXNfaWQiOjQ0OTgyODUsImNpZiI6IjAyOTk2NDIiLCJjbXNfaWRzIjpbNDQ5ODI4NV0sImRyZCI6IjIwMjQtMDMtMDRUMTc6NTM6MTYuMzA2MzI1KzA0OjAwIiwicmVnaXN0cmF0aW9uX3R5cGUiOiJDQVJEIiwiaWF0IjoxNzI3MDY5NTY0LCJleHAiOjE3MjcwNzA0NjR9.8L8hkWvQyHbHH3fY_uaYLxqSwrCPNRCCINJOIrFw83qv4Q5t-W3pYkrgtSpgntM1RY76TySFO-sLOMHvVmgR-w";

  public AuthResponse login(AuthRequest request) {
    if (request.username().equals("user") && request.password().equals("user")) {
      return new AuthResponse(jwtToken);
    } else {
      throw new InvalidCredentialsException("Invalid username or password");
    }
  }


  public boolean checkToken(String token) {
    return token.equals(jwtToken);
  }

}
