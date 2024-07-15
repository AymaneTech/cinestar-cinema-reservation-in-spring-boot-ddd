package dev.codex.cinestar.Schedule.Interfaces.web.Advice;

import dev.codex.cinestar.Common.Models.ErrorResponse;
import dev.codex.cinestar.Schedule.Domain.Exceptions.ScheduleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ScheduleExceptionHandler {


    @ExceptionHandler(ScheduleNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMovieNotFoundException(ScheduleNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "schedule not found",
                Map.of(
                        "message", ex.getMessage(),
                        "schedule id ", ex.getScheduleId().toString()
                )
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
