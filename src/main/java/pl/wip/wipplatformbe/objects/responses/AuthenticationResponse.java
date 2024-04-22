package pl.wip.wipplatformbe.objects.responses;

public record AuthenticationResponse(String username, String email, String token) {
}
