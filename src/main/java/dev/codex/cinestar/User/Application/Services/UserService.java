package dev.codex.cinestar.User.Application.Services;

import dev.codex.cinestar.Common.Contracts.CrudService;
import dev.codex.cinestar.User.Application.DTOs.Requests.UserRequest;
import dev.codex.cinestar.User.Domain.Entities.User;

public interface UserService extends CrudService<User, Long, UserRequest> {
}
