package pl.wip.wipplatformbe.dto.requests;

public class CreateBlogPostCommentDto {
    private String content;
    private String blogPostId;

    public String getBlogPostId() {
        return blogPostId;
    }

    public String getContent() {
        return content;
    }
}
