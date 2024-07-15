package dev.codex.cinestar.Schedule.Domain.Exceptions;

public class ScheduleNotFoundException extends RuntimeException {
    private final Long id;

    public ScheduleNotFoundException(Long id) {
        super("Schedule not found");
        this.id = id;
    }

    public Long getScheduleId() {
        return id;
    }
}
