package dev.codex.cinestar.Room.Application.Services;

import dev.codex.cinestar.Common.Contracts.CrudService;
import dev.codex.cinestar.Room.Application.DTOs.RoomRequest;
import dev.codex.cinestar.Room.Domain.Entities.Room;

public interface RoomService extends CrudService<Room, Long, RoomRequest> {
}
