package dev.codex.cinestar.User.Domain.Exceptions;

public class RoleNotFoundException extends RuntimeException {
    private final Long id;

    public RoleNotFoundException(Long id) {
        super("Role with id " + id + " not found");
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

