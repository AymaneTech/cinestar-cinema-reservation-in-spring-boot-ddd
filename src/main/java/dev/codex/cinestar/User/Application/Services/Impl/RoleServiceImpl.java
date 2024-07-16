package dev.codex.cinestar.User.Application.Services.Impl;

import dev.codex.cinestar.User.Application.DTOs.Requests.RoleRequest;
import dev.codex.cinestar.User.Application.Services.PermissionService;
import dev.codex.cinestar.User.Application.Services.RoleService;
import dev.codex.cinestar.User.Domain.Entities.Permission;
import dev.codex.cinestar.User.Domain.Entities.Role;
import dev.codex.cinestar.User.Domain.Exceptions.RoleNotFoundException;
import dev.codex.cinestar.User.Infrastructure.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final PermissionService permissionService;


    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));
    }

    @Override
    public Role create(RoleRequest request) {
        final List<Permission> permissions = permissionService.findAllByIds(request.permissionIds());
        final Role role = new Role(request.name(), permissions);
        return repository.save(role);
    }

    @Override
    public Role update(Long id, RoleRequest request) {
        final Role role = repository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));
        final List<Permission> permissions = permissionService.findAllByIds(request.permissionIds());

        role.setName(request.name());
        role.setPermissions(permissions);
        return repository.save(role);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new RoleNotFoundException(id);
        repository.deleteById(id);
    }
}
