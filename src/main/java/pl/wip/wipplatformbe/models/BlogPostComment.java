package pl.wip.wipplatformbe.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.wip.wipplatformbe.dto.responses.BlogPostCommentDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "blogPostComments")
public class BlogPostComment {
    @Id
    private String id;
    private final String userId;
    private final LocalDateTime createdAt;
    private LocalDateTime editedAt;
    private String content;
    private final List<UserReaction> reactions;
    
    public BlogPostComment(String userId, String content) {
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
        this.editedAt = LocalDateTime.now();
        this.content = content;
        this.reactions = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }
    
    public String getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(LocalDateTime editedAt) {
        this.editedAt = editedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<UserReaction> getReactions() {
        return reactions;
    }
    
    public BlogPostCommentDto toBlogPostCommentDto() {
        return new BlogPostCommentDto(id, userId, createdAt, editedAt, content, reactions);
    }
}
