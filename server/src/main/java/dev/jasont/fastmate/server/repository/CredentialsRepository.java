package dev.jasont.fastmate.server.repository;

import dev.jasont.fastmate.server.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {

    public Optional<Credentials> findByUsername(String username);
}
