package dev.codex.cinestar.User.Infrastructure;

import dev.codex.cinestar.User.Domain.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}