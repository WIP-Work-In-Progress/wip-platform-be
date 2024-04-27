package pl.wip.wipplatformbe.controllers;

import org.springframework.web.bind.annotation.*;
import pl.wip.wipplatformbe.models.BlogPost;
import pl.wip.wipplatformbe.objects.BlogPostThumbnailDTO;
import pl.wip.wipplatformbe.services.BlogPostService;

import java.util.List;

@RestController
@RequestMapping("/blog/posts")
public class BlogPostController {

  private final BlogPostService blogPostService;

  public BlogPostController(BlogPostService blogPostService) { this.blogPostService = blogPostService; }

  @GetMapping("")
  List<BlogPostThumbnailDTO> getAllBlogPosts() {
    return blogPostService.getAllBlogPostsThumbnails();
  }

  @GetMapping("/{id}")
  List<BlogPost> getAuthorBlogPosts(@PathVariable String id) {
    return blogPostService.getAuthorBlogPosts(id);
  }

  @PostMapping("/create")
  void postCreateBlogPost(@RequestBody String title, String content) {
    blogPostService.createBlogPost("username", title, content);
  }

  @PatchMapping("/{id}/edit")
  BlogPost updateBlogPost(@PathVariable String id, @RequestBody String title, String content) {
    return blogPostService.editBlogPost(id, title, content);
  }

  @DeleteMapping("/{id}/delete")
  void deleteTest(@PathVariable String id) {
    blogPostService.deleteBlogPost(id);
  }

}
