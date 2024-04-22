package pl.wip.wipplatformbe.controllers;

import jakarta.validation.Valid;
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

import java.util.Collections;
import java.util.Map;
import java.util.Optional;


@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) {
        User registeredUser = authenticationService.createUser(registerRequest);
        String token = jwtService.generateToken(registeredUser);
        
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(registeredUser.getUsername(),
                registeredUser.getEmail(), token);
        
        return ResponseEntity.ok(authenticationResponse);
    }   
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = authenticationService.checkPassword(loginRequest);
        
        if (user.isEmpty())
            return loginFailedResponse();
            
        String token = jwtService.generateToken(user.get());
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(user.get().getUsername(),
                user.get().getEmail(), token);
        
        return ResponseEntity.ok(authenticationResponse);
    }
    
    private ResponseEntity<Map<String, String>> loginFailedResponse() {
        return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Wrong username or password"));
    }
}
