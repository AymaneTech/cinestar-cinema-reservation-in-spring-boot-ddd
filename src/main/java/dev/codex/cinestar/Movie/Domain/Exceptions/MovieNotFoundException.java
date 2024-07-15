package dev.codex.cinestar.Movie.Domain.Exceptions;

public class MovieNotFoundException extends RuntimeException {
    private final Long id;

    public MovieNotFoundException(Long id) {
        super("Movie with id " + id + " not found");
        this.id = id;
    }

    public Long getMovieId() {
        return id;
    }
}
