package dev.codex.cinestar.Booking.Infrastructure;

import dev.codex.cinestar.Booking.Domain.Entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}