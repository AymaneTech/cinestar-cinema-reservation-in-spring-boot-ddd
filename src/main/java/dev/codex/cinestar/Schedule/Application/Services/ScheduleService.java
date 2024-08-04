package dev.codex.cinestar.Schedule.Application.Services;

import dev.codex.cinestar.Common.Contracts.CrudService;
import dev.codex.cinestar.Schedule.Application.DTOs.Requests.ScheduleRequest;
import dev.codex.cinestar.Schedule.Domain.Entities.Schedule;

public interface ScheduleService extends CrudService<Schedule, Long, ScheduleRequest> {
}
