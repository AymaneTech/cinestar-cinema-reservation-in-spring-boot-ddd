package dev.codex.cinestar.User.Infrastructure;

import dev.codex.cinestar.User.Domain.Entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}