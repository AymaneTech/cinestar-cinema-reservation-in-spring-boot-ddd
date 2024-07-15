package dev.codex.cinestar.Room.Infrastructure;

import dev.codex.cinestar.Room.Domain.Entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}