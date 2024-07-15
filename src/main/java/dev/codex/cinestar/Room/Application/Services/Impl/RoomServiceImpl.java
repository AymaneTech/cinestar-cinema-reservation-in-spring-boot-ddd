package dev.codex.cinestar.Room.Application.Services.Impl;

import dev.codex.cinestar.Room.Application.Services.RoomService;
import dev.codex.cinestar.Room.Domain.Entities.Room;

import java.util.List;

class RoomServiceImpl implements RoomService {
    @Override
    public List<Room> findAll() {
        return List.of();
    }

    @Override
    public Room findById(Long aLong) {
        return null;
    }

    @Override
    public Room create(Room room) {
        return null;
    }

    @Override
    public Room update(Long aLong, Room room) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
