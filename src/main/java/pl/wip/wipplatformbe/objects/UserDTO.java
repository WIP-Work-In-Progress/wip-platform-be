package pl.wip.wipplatformbe.objects;

import pl.wip.wipplatformbe.enums.Role;
import pl.wip.wipplatformbe.enums.UserStatus;
import pl.wip.wipplatformbe.models.Photo;

public record UserDTO(
        String id,
        String username,
        Photo profilePicture,
        String firstName,
        String lastName,
        Role role,
        String email,
        String description,
        UserStatus status
) {}
