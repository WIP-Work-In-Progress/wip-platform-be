package pl.wip.wipplatformbe.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wip.wipplatformbe.models.User;
import pl.wip.wipplatformbe.requests.RegisterRequest;
import pl.wip.wipplatformbe.responses.RegisterResponse;
import pl.wip.wipplatformbe.services.AuthenticationService;
import pl.wip.wipplatformbe.services.JwtService;
import pl.wip.wipplatformbe.services.UserService;

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
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerUserDto) {
        if (userService.usernameExists(registerUserDto.getUsername()))
            return ResponseEntity.badRequest().build();
        
        User registeredUser = authenticationService.createUser(registerUserDto);
        String token = jwtService.generateToken(registeredUser);
        RegisterResponse registerResponse = new RegisterResponse(registeredUser.getUsername(), token);
        return ResponseEntity.ok(registerResponse);
    }   
}
