package dev.codex.cinestar.Booking.Infrastructure;

import dev.codex.cinestar.Booking.Domain.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}