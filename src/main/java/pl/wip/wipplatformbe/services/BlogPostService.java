package pl.wip.wipplatformbe.services;

import org.springframework.stereotype.Service;
import pl.wip.wipplatformbe.models.BlogPost;
import pl.wip.wipplatformbe.objects.BlogPostThumbnailDTO;
import pl.wip.wipplatformbe.repositories.BlogPostRepository;

import java.util.List;

@Service
public class BlogPostService {

  private final BlogPostRepository blogPostRepository;

  public void createBlogPost(String username, String title, String content) {}

  public void deleteBlogPost(String blogId) {}

  public BlogPost editBlogPost(String blogId, String title, String content) {}

  public List<BlogPost> getAuthorBlogPosts(String authorId) {}

  public List<BlogPostThumbnailDTO> getAllBlogPostsThumbnails() {}
}
