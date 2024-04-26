package pl.wip.wipplatformbe.dto.responses;

import pl.wip.wipplatformbe.models.UserReaction;

import java.time.LocalDateTime;
import java.util.List;

public record BlogPostCommentDto(String id, String userId, LocalDateTime createdAt, LocalDateTime editedAt,
                                 String content, List<UserReaction> reactions) {
}
