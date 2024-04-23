package pl.wip.wipplatformbe.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.wip.wipplatformbe.enums.Role;
import pl.wip.wipplatformbe.enums.UserStatus;
import pl.wip.wipplatformbe.enums.Badge;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document(collection = "users")
public class User implements UserDetails {
    @Id
    private String id;
    private String password;
    private String email;
    private Photo profilePicture;
    private String username;
    private String firstName;
    private String lastName;
    private List<Role> roles;
    private List<Badge> badges;
    private String description;
    private Date createdAt;
    private UserStatus status;

    public User() {}

    public User(String id, String password, String email, Photo profilePicture, String username, String firstName, String lastName, List<Role> roles, List<Badge> badges, String description, Date createdAt, UserStatus status) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.profilePicture = profilePicture;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        this.badges = badges;
        this.description = description;
        this.createdAt = createdAt;
        this.status = status;
    }
    
    // TODO: remove this constructor when it's no longer needed
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = List.of(Role.USER);
    }

    public String getId() {
        return id;
    }
  
    public String getUsername() {
        return username;
    }
    
    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
