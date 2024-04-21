package pl.wip.wipplatformbe.responses;

public record AuthenticationResponse(String username, String email, String token) {
}
