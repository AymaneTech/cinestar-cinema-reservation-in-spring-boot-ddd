package dev.codex.cinestar.Movie.Interfaces.Web.Adivce;

import dev.codex.cinestar.Common.Models.ErrorResponse;
import dev.codex.cinestar.Movie.Domain.Exceptions.CategoryNotFoundException;
import dev.codex.cinestar.Movie.Domain.Exceptions.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MoviesExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMovieNotFoundException(MovieNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Movie not found",
                Map.of(
                        "message", ex.getMessage(),
                        "movieId", ex.getMovieId().toString()
                )
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCategoryNotFoundException(CategoryNotFoundException ex) {
        Map<String, String> details = new HashMap<>();
        details.put("message", ex.getMessage());

        if (ex.getCategoryId() != null) {
            details.put("categoryId", ex.getCategoryId().toString());
        }

        if (ex.getCategoryName() != null) {
            details.put("categoryName", ex.getCategoryName());
        }

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Category not found",
                details
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
