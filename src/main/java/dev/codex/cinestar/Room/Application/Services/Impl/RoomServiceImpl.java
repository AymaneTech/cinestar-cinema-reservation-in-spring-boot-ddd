package dev.codex.cinestar.Room.Application.Services.Impl;

import dev.codex.cinestar.Room.Application.DTOs.RoomRequest;
import dev.codex.cinestar.Room.Application.Services.RoomService;
import dev.codex.cinestar.Room.Application.Services.ZoneService;
import dev.codex.cinestar.Room.Domain.Entities.Room;
import dev.codex.cinestar.Room.Domain.Entities.Zone;
import dev.codex.cinestar.Room.Domain.Exceptions.RoomNotFoundException;
import dev.codex.cinestar.Room.Infrastructure.RoomRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;
    private final ZoneService zoneService;

    @Override
    public List<Room> findAll() {
        return repository.findAll();
    }

    @Override
    public Room findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    @Override
    public Room create(RoomRequest request) {
        Room room = new Room(
                request.name(),
                request.capacity()
        );
        Room savedRoom = repository.save(room);
        List<Zone> zones = zoneService.createAll(request.zones(), savedRoom);
        savedRoom.setZones(zones);
        return savedRoom;
    }

    @Override
    public Room update(Long id, RoomRequest request) {
        Room room = repository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
        List<Zone> zones = zoneService.sync(request.zones(), room);
        room.setName(request.name());
        room.setCapacity(request.capacity());
        room.setZones(zones);
        return repository.save(room);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RoomNotFoundException(id);
        repository.deleteById(id);
    }
}