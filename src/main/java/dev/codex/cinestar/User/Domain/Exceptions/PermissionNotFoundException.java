package dev.codex.cinestar.User.Domain.Exceptions;

public class PermissionNotFoundException extends RuntimeException {

    private final Long id;

    public PermissionNotFoundException(Long id) {
        super("Permission with id " + id + " not found");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
