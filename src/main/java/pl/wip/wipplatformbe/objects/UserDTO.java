package pl.wip.wipplatformbe.objects;

import pl.wip.wipplatformbe.enums.Role;
import pl.wip.wipplatformbe.enums.UserStatus;
import pl.wip.wipplatformbe.models.Photo;

public record UserDTO() {
    private static String id;
    private static String username;
    private static Photo profilePicture;
    private static String firstName;
    private static String lastName;
    private static Role role;
    private static String email;
    private static String description;
    private static UserStatus status;
}
