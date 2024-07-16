package dev.codex.cinestar.User.Domain.Exceptions;

public class UserNotFoundException extends RuntimeException {
    private final Long id;

    public UserNotFoundException(Long id) {
        super("User with id " + id + " not found");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
