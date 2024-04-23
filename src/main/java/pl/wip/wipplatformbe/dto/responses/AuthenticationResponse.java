package pl.wip.wipplatformbe.dto.responses;

public record AuthenticationResponse(String username, String email, String token) {
}
