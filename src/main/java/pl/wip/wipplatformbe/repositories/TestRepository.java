package pl.wip.wipplatformbe.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.wip.wipplatformbe.models.Test;

public interface TestRepository extends MongoRepository<Test, String> {

}
