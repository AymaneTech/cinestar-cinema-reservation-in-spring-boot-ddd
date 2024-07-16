package dev.codex.cinestar.User.Infrastructure;

import dev.codex.cinestar.User.Domain.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}