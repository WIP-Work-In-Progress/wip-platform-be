package pl.wip.wipplatformbe.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.wip.wipplatformbe.models.Test;

import java.util.List;
import java.util.Optional;

public interface TestRepository extends MongoRepository<Test, String> {
    // Get all items from the collection
    List<Test> findAll();
    // Get item by id
    Optional<Test> findById(String id);
    // Save item
    Test save(Test test);
}
