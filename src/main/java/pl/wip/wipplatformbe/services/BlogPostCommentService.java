package pl.wip.wipplatformbe.services;

import org.springframework.stereotype.Service;
import pl.wip.wipplatformbe.dto.requests.CreateBlogPostCommentDto;
import pl.wip.wipplatformbe.dto.requests.UpdateBlogPostCommentDto;
import pl.wip.wipplatformbe.dto.responses.BlogPostCommentDto;
import pl.wip.wipplatformbe.models.BlogPostComment;
import pl.wip.wipplatformbe.repositories.BlogPostCommentRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BlogPostCommentService {
    private final BlogPostCommentRepository repository;
    
    public BlogPostCommentService(BlogPostCommentRepository repository) {
        this.repository = repository;
    }
    
    // TODO: get all by BlogPost id
    
    public BlogPostCommentDto create(CreateBlogPostCommentDto dto, String userId) {
        BlogPostComment blogPostComment = new BlogPostComment(userId, dto.content());
        repository.save(blogPostComment);
        
        // TODO: update BlogPost comments array to include new comment's id
        
        return blogPostComment.toBlogPostCommentDto();
    }
    
    public Optional<BlogPostCommentDto> update(String id, UpdateBlogPostCommentDto dto, String userId) {
        Optional<BlogPostComment> commentOptional = repository.findBlogPostCommentBydAndUserId(id, userId);

        if (commentOptional.isEmpty())
            return Optional.empty();

        BlogPostComment comment = commentOptional.get();
        comment.setEditedAt(LocalDateTime.now());
        comment.setContent(dto.content());
        repository.save(comment);
        return Optional.of(comment.toBlogPostCommentDto());
    }
    
    public boolean delete(String id, String userId) {
        // TODO: remove comment's id from BlogPost's array
        
        return repository.findBlogPostCommentBydAndUserId(id, userId)
                .map(entity -> {
                    repository.delete(entity);
                    return true;
                })
                .orElse(false);
    }
}
