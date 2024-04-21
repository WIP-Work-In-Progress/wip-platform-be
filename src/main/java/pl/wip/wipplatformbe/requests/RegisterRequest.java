package pl.wip.wipplatformbe.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import pl.wip.wipplatformbe.requests.base.AuthenticationRequest;

public class RegisterRequest extends AuthenticationRequest {
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters")
    private String username;

    public String getUsername() {
        return username;
    }
}
