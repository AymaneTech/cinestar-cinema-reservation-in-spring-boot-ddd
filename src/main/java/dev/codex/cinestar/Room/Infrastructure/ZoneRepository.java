package dev.codex.cinestar.Room.Infrastructure;

import dev.codex.cinestar.Room.Domain.Entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
}