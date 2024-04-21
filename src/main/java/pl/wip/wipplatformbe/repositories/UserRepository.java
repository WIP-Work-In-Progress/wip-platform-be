package pl.wip.wipplatformbe.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.wip.wipplatformbe.models.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
