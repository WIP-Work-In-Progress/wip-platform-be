package pl.wip.wipplatformbe.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;
import pl.wip.wipplatformbe.enums.BlogStatus;

@Document(collection = "blog")
public class BlogPost {
  @Id
  private String id;
  private String authorId;
  private Date createdAt;
  private Date editedAt;
  private boolean isEdited;
  private BlogStatus status;
  private String description;
  private String content;
  private String title;
  private Photo thumbnail;
  private List<String> comments;
  private List<Photo> photos;
  private List<PostTag> tags;
  private List<UserReaction> userReactions;

  public BlogPost(String id, String authorId, Date createdAt, Date editedAt,
                  boolean isEdited, BlogStatus status, String description, String content,
                  String title, Photo thumbnail, List<String> comments, List<Photo> photos,
                  List<PostTag> tags, List<UserReaction> userReactions) {
    this.id = id;
    this.authorId = authorId;
    this.createdAt = createdAt;
    this.editedAt = editedAt;
    this.isEdited = isEdited;
    this.status = status;
    this.description = description;
    this.content = content;
    this.title = title;
    this.thumbnail = thumbnail;
    this.comments = comments;
    this.photos = photos;
    this.tags = tags;
    this.userReactions = userReactions;
  }
}
