package org.zenmanager.ZenTasks.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    @NotBlank
    private String firstName;

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @NotBlank
    private String email;

    @JoinColumn(name="user_id")
    @OneToMany
    private final List<Task> tasks = new ArrayList<>();


    private String profilePicture;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private boolean darkTheme;

    public User() {}

    public User(String username, String password, String email, String firstName,String profilePicture) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
        this.firstName = firstName;
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public boolean isDarkTheme() {
        return darkTheme;
    }

    public void setDarkTheme(boolean darkTheme) {
        this.darkTheme = darkTheme;
    }

    public String getFirstName() { return firstName; }

    public String getProfilePicture() { return profilePicture;
    }

    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture;
    }
}
