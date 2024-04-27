package pl.wip.wipplatformbe.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.wip.wipplatformbe.models.BlogPost;
public interface BlogPostRepository extends MongoRepository<BlogPost, String> {

}
