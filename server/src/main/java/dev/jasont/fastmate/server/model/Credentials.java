package dev.jasont.fastmate.server.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
public class Credentials {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    private User user;

    private String username;

    @Lob
    private String encryptedPassword;

    public Credentials() {
    }

    //TODO: Credentials should include roles
    public Credentials(String username, String password) {
        this.username = username;

        var passwordEncoder = new BCryptPasswordEncoder();
        this.encryptedPassword = passwordEncoder.encode(password);
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }
}
