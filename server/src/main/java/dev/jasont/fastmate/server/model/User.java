package dev.jasont.fastmate.server.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Credentials credentials;

    public User() {
    }

    public User(Credentials credentials) {
        this.credentials = credentials;
        credentials.setUser(this);
    }

    public Long getId() {
        return id;
    }
}
