package dev.codex.cinestar.Schedule.Application.DTOs.Requests;

import dev.codex.cinestar.Schedule.Domain.ValueObjects.ScheduleStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ScheduleRequest(
        @NotNull
        Long movieId,

        @NotNull
        Long roomId,

        @NotNull
        ScheduleStatus status,

        @NotNull
        Date scheduleDate,

        @NotBlank
        String startTime,

        @NotBlank
        String endTime,

        Boolean isFull
) {

}
