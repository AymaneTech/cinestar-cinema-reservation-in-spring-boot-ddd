package dev.codex.cinestar.Room.Application.Services.Impl;

import dev.codex.cinestar.Room.Application.DTOs.Requests.RoomRequest;
import dev.codex.cinestar.Room.Application.Services.RoomService;
import dev.codex.cinestar.Room.Application.Services.ZoneService;
import dev.codex.cinestar.Room.Domain.Entities.Room;
import dev.codex.cinestar.Room.Domain.Entities.Zone;
import dev.codex.cinestar.Room.Domain.Exceptions.RoomNotFoundException;
import dev.codex.cinestar.Room.Infrastructure.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
    @Transactional
    public Room create(RoomRequest request) {
        final Room room = new Room(
                request.name(),
                request.capacity()
        );
        final Room savedRoom = repository.save(room);
        final List<Zone> zones = zoneService.createAll(request.zones(), savedRoom);
        savedRoom.setZones(zones);
        return savedRoom;
    }

    @Override
    @Transactional
    public Room update(Long id, RoomRequest request) {
        final Room room = repository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
        final List<Zone> zones = zoneService.sync(request.zones(), room);
        room.setName(request.name());
        room.setCapacity(request.capacity());
        room.setZones(zones);
        return repository.save(room);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RoomNotFoundException(id);
        repository.deleteById(id);
    }
}
