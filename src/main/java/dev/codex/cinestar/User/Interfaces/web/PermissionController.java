package dev.codex.cinestar.User.Interfaces.web;

import dev.codex.cinestar.User.Application.DTOs.Requests.PermissionRequest;
import dev.codex.cinestar.User.Application.Services.PermissionService;
import dev.codex.cinestar.User.Domain.Entities.Permission;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping
    public ResponseEntity<List<Permission>> findAll() {
        final List<Permission> permissions = permissionService.findAll();
        return ResponseEntity.ok(permissions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> findById(@PathVariable Long id) {
        final Permission permission = permissionService.findById(id);
        return ResponseEntity.ok(permission);
    }

    @PostMapping
    public ResponseEntity<Permission> create(@RequestBody @Valid PermissionRequest dto) {
        final Permission createdPermission = permissionService.create(dto);
        return new ResponseEntity<>(createdPermission, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permission> update(@PathVariable Long id, @RequestBody @Valid PermissionRequest dto) {
        final Permission updatedPermission = permissionService.update(id, dto);
        return ResponseEntity.ok(updatedPermission);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        permissionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
