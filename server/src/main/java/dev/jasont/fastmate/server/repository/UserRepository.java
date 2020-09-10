package dev.jasont.fastmate.server.repository;

import dev.jasont.fastmate.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
