package dev.codex.cinestar.Booking.Application.DTOs.Requests;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public record BookingRequest(
        @NotNull
        Long memberId,
        @NotNull
        Long scheduleId,
        Long seatId
) {
}
