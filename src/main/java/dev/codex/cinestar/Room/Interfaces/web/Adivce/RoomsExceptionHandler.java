package dev.codex.cinestar.Room.Interfaces.web.Adivce;

import dev.codex.cinestar.Common.Models.ErrorResponse;
import dev.codex.cinestar.Room.Domain.Exceptions.RoomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class RoomsExceptionHandler {

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMovieNotFoundException(RoomNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "room not found",
                Map.of(
                        "message", ex.getMessage(),
                        "movieId", ex.getRoomId().toString()
                )
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
