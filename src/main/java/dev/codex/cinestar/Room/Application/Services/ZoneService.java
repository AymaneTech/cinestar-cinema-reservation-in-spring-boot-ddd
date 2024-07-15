package dev.codex.cinestar.Room.Application.Services;

import dev.codex.cinestar.Common.Contracts.CrudService;
import dev.codex.cinestar.Room.Application.DTOs.ZoneRequest;
import dev.codex.cinestar.Room.Domain.Entities.Room;
import dev.codex.cinestar.Room.Domain.Entities.Zone;

import java.util.List;

public interface ZoneService {
    List<Zone> createAll(List<ZoneRequest> zones, Room room);

    List<Zone> sync(List<ZoneRequest> zones, Room room);
}
