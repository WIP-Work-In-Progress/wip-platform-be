package pl.wip.wipplatformbe.requests.base;

public abstract class AuthenticationRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
