package pl.wip.wipplatformbe.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.wip.wipplatformbe.enums.Badge;
import pl.wip.wipplatformbe.enums.Role;
import pl.wip.wipplatformbe.enums.UserStatus;

@Document("users")
public class User {

    @Id
    private String id;
    private String password;
    private String email;
    private Photo profilePicture;
    private String username;
    private String firstName;
    private String lastName;
    private List<Role> role;
    private List<Badge> badges;
    private String description;
    private Date createdAt;
    private UserStatus status;





    public User() {}

    public User(String id, String password, String email, Photo profilePicture, String username, String firstName, String lastName, List<Role> role, List<Badge> badges, String description, Date createdAt, UserStatus status) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.profilePicture = profilePicture;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.badges = badges;
        this.description = description;
        this.createdAt = createdAt;
        this.status = status;
    }
}
