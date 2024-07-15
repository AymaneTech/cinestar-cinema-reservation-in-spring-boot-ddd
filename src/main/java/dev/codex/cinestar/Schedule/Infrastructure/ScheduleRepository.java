package dev.codex.cinestar.Schedule.Infrastructure;

import dev.codex.cinestar.Schedule.Domain.Entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}