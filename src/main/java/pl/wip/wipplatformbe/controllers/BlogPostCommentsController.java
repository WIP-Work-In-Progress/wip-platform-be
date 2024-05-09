package pl.wip.wipplatformbe.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.wip.wipplatformbe.dto.requests.CreateBlogPostCommentDto;
import pl.wip.wipplatformbe.dto.requests.UpdateBlogPostCommentDto;
import pl.wip.wipplatformbe.dto.responses.BlogPostCommentDto;
import pl.wip.wipplatformbe.models.BlogPostComment;
import pl.wip.wipplatformbe.models.User;
import pl.wip.wipplatformbe.services.BlogPostCommentService;

import java.util.Optional;

@RequestMapping("/blog/posts")
@RestController
public class BlogPostCommentsController {
    private final BlogPostCommentService blogPostCommentsService;

    public BlogPostCommentsController(BlogPostCommentService blogPostCommentsService) {
        this.blogPostCommentsService = blogPostCommentsService;
    }

    // TODO: Implement unprotected GET /{postId}/comments endpoint

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<BlogPostCommentDto> getComment(@PathVariable String commentId) {
        Optional<BlogPostComment> optionalComment = blogPostCommentsService.getBlogPostCommentById(commentId);

        if (optionalComment.isEmpty())
            return ResponseEntity.notFound().build();

        String blogPostId = "Sample id"; // TODO: Retrieve actual blog post id
        return ResponseEntity.ok(optionalComment.get().toBlogPostCommentDto(blogPostId));
    }

    @PostMapping("/comments") // To discuss, should this be /{postId}/comments?
    public ResponseEntity<BlogPostCommentDto> createComment(Authentication authentication,
                                                            HttpServletRequest request,
                                                            @RequestBody CreateBlogPostCommentDto dto) {
        // TODO: Check if blog post exists, and add new comment to it, whether here or in service

        String userId = ((User) authentication.getPrincipal()).getId(); // Maybe use author username rather than id?
        BlogPostCommentDto comment = blogPostCommentsService.createBlogPostComment(dto, userId);
        return ResponseEntity
                .status(201)
                .header("Location", request.getRequestURL() + "/" + comment.id())
                .body(comment);
    }

    @PatchMapping("/comments/{commentId}/edit")
    public ResponseEntity<BlogPostCommentDto> updateComment(Authentication authentication,
                                                            @PathVariable String commentId,
                                                            @RequestBody UpdateBlogPostCommentDto dto
                                                            ) {
        Optional<BlogPostComment> optionalComment = blogPostCommentsService.getBlogPostCommentById(commentId);

        if (optionalComment.isEmpty())
            return ResponseEntity.notFound().build();

        if (!optionalComment.get().getUserId().equals(((User) authentication.getPrincipal()).getId()))
            return ResponseEntity.status(403).build();

        BlogPostComment comment = optionalComment.get();
        String blogPostId = "Sample id"; // TODO: Retrieve actual blog post id
        BlogPostCommentDto updatedComment = blogPostCommentsService.editBlogPostComment(comment, dto, blogPostId);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/comments/{commentId}/delete")
    public ResponseEntity<Void> deleteComment(Authentication authentication,
                                             @PathVariable String commentId) {
        Optional<BlogPostComment> optionalComment = blogPostCommentsService.getBlogPostCommentById(commentId);

        if (optionalComment.isEmpty())
            return ResponseEntity.notFound().build();

        BlogPostComment comment = optionalComment.get();

        if (!comment.getUserId().equals(((User) authentication.getPrincipal()).getId()))
            return ResponseEntity.status(403).build();

        blogPostCommentsService.deleteBlogPostComment(comment);
        return ResponseEntity.noContent().build();
    }
}
