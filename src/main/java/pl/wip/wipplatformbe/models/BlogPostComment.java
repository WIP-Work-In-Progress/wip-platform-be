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
    private String userId;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;
    private String content;
    private List<UserReaction> reactions;
    
    public BlogPostComment(String userId, String content) {
        this.userId = userId;
        LocalDateTime currentTime = LocalDateTime.now();
        this.createdAt = currentTime;
        this.editedAt = currentTime;
        this.content = content;
        this.reactions = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public void setReactions(List<UserReaction> reactions) {
        this.reactions = reactions;
    }
    
    public BlogPostCommentDto toBlogPostCommentDto(String blogPostId) {
        return new BlogPostCommentDto(id, userId, blogPostId, createdAt, editedAt, content, reactions);
    }
}
