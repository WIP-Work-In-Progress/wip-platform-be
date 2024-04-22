package pl.wip.wipplatformbe.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import pl.wip.wipplatformbe.validation.UniqueEmail;
import pl.wip.wipplatformbe.validation.UniqueUsername;
import pl.wip.wipplatformbe.validation.ValidPassword;

public class RegisterRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @UniqueEmail
    private String email;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters")
    @UniqueUsername
    private String username;

    @NotBlank(message = "Password is required")
    @ValidPassword
    private String password;

    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
