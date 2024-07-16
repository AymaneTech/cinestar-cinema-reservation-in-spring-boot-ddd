package dev.codex.cinestar.User.Application.Services;

import dev.codex.cinestar.Common.Contracts.CrudService;
import dev.codex.cinestar.User.Application.DTOs.Requests.RoleRequest;
import dev.codex.cinestar.User.Domain.Entities.Role;

public interface RoleService extends CrudService<Role, Long, RoleRequest> {
}
