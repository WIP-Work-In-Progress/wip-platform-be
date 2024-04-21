package pl.wip.wipplatformbe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wip.wipplatformbe.models.User;
import pl.wip.wipplatformbe.requests.LoginRequest;
import pl.wip.wipplatformbe.requests.RegisterRequest;
import pl.wip.wipplatformbe.responses.AuthenticationResponse;
import pl.wip.wipplatformbe.services.AuthenticationService;
import pl.wip.wipplatformbe.services.JwtService;
import pl.wip.wipplatformbe.services.UserService;

import java.util.Optional;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final UserService userService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, UserService userService,
                                    AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {
        if (userService.usernameExists(registerRequest.getUsername()))
            return badRequestResponse();
        
        if (userService.emailExists(registerRequest.getEmail()))
            return badRequestResponse();
        
        User registeredUser = authenticationService.createUser(registerRequest);
        String token = jwtService.generateToken(registeredUser);
        
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(registeredUser.getUsername(),
                registeredUser.getEmail(), token);
        
        return ResponseEntity.ok(authenticationResponse);
    }   
    
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = authenticationService.checkPassword(loginRequest);
        
        if (user.isEmpty())
            return badRequestResponse();
            
        String token = jwtService.generateToken(user.get());
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(user.get().getUsername(),
                user.get().getEmail(), token);
        
        return ResponseEntity.ok(authenticationResponse);
    }
    
    // TODO: Add messages to Bad Request response
    private ResponseEntity badRequestResponse() {
        return ResponseEntity.badRequest().build();
    }
}
