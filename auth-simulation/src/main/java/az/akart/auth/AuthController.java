package az.akart.auth;

import az.akart.auth.request.AuthRequest;
import az.akart.auth.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/login")
  public AuthResponse login(@RequestBody AuthRequest request) {
    return authService.login(request);
  }

  @PostMapping("/check")
  public boolean credit(@RequestParam String token) {
    return authService.checkToken(token);
  }

}
