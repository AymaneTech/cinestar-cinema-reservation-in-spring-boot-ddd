package dev.codex.cinestar.User.Application.Services;

import dev.codex.cinestar.Common.Contracts.CrudService;
import dev.codex.cinestar.User.Application.DTOs.Requests.PermissionRequest;
import dev.codex.cinestar.User.Domain.Entities.Permission;

import java.util.List;

public interface PermissionService extends CrudService<Permission, Long, PermissionRequest> {
    List<Permission> findAllByIds(List<Long> longs);
}
