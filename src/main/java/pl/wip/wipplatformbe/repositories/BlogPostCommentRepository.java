package pl.wip.wipplatformbe.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.wip.wipplatformbe.models.BlogPostComment;

import java.util.Optional;

public interface BlogPostCommentRepository extends MongoRepository<BlogPostComment, String> {
    Optional<BlogPostComment> findBlogPostCommentBydAndUserId(String id, String userId);
    
    // TODO: Find by BlogPost id
}
