package pl.wip.wipplatformbe.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wip.wipplatformbe.models.User;
import pl.wip.wipplatformbe.repositories.UserRepository;
import pl.wip.wipplatformbe.requests.LoginRequest;
import pl.wip.wipplatformbe.requests.RegisterRequest;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(RegisterRequest userRequest) {
        User user = new User(userRequest.getUsername(), passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(user);
        return user;
    }

    public Optional<User> checkPassword(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
        
        if (user.isPresent() && !passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword()))
            return Optional.empty();
        
        return user;
    }
}
