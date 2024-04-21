package pl.wip.wipplatformbe.requests;

import pl.wip.wipplatformbe.requests.base.AuthenticationRequest;

public class RegisterRequest extends AuthenticationRequest {
    private String username;

    public String getUsername() {
        return username;
    }
}
