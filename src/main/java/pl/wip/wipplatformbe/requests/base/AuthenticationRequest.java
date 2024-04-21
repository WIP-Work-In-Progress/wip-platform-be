package pl.wip.wipplatformbe.requests.base;

public abstract class AuthenticationRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
