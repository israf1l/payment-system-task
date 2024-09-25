package az.akart.auth.request;

public record AuthRequest(
    String username,
    String password
) {
}
