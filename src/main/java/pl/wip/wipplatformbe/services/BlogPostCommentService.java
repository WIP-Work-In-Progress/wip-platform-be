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

    public Optional<BlogPostComment> getById(String id) {
        return repository.findById(id);
    }

    public BlogPostCommentDto create(CreateBlogPostCommentDto dto, String userId) {
        BlogPostComment blogPostComment = new BlogPostComment(userId, dto.getContent());
        repository.save(blogPostComment);
        
        // TODO: update BlogPost comments array to include new comment's id
        
        return blogPostComment.toBlogPostCommentDto(dto.getBlogPostId());
    }
    
    public BlogPostCommentDto update(BlogPostComment comment, UpdateBlogPostCommentDto dto,
                                     String blogPostId) {
        comment.setEditedAt(LocalDateTime.now());
        comment.setContent(dto.getContent());
        repository.save(comment);
        return comment.toBlogPostCommentDto(blogPostId);
    }
    
    public void delete(BlogPostComment comment) {
        // TODO: remove comment's id from BlogPost's array
        repository.delete(comment);
    }
}
