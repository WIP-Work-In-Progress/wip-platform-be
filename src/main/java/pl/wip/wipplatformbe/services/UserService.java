package pl.wip.wipplatformbe.services;

import org.springframework.stereotype.Service;
import pl.wip.wipplatformbe.models.User;
import pl.wip.wipplatformbe.repositories.UserRepository;
import pl.wip.wipplatformbe.requests.RegisterRequest;
import pl.wip.wipplatformbe.utils.SecurityUtils;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public User createUser(RegisterRequest userRequest) {
        byte[] passwordSalt = SecurityUtils.generateSalt();
        String passwordHash = SecurityUtils.hashPassword(userRequest.getPassword(), passwordSalt);
        
        User user = new User(userRequest.getUsername(), userRequest.getPassword());
        userRepository.save(user);
        return user;
    }
}
