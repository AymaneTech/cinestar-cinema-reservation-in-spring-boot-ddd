package dev.codex.cinestar.Room.Domain.Exceptions;

public class RoomNotFoundException extends RuntimeException {
    private final Long id;

    public RoomNotFoundException(Long id) {
        super("Room with " + id + "not found");
        this.id = id;
    }

    public Long getRoomId() {
        return id;
    }
}
