package pl.wip.wipplatformbe.objects;

import pl.wip.wipplatformbe.models.PostTag;
import pl.wip.wipplatformbe.models.Photo;
import java.util.List;

public record BlogPostThumbnailDTO(String id,
                                   String authorId,
                                   String description,
                                   String title,
                                   Photo thumbnail,
                                   List<PostTag> tags
) { }
