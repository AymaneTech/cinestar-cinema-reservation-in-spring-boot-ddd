package dev.codex.cinestar.User.Interfaces.web;

import dev.codex.cinestar.User.Application.DTOs.Requests.RoleRequest;
import dev.codex.cinestar.User.Application.Services.RoleService;
import dev.codex.cinestar.User.Domain.Entities.Role;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {
        final List<Role> roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable Long id) {
        final Role role = roleService.findById(id);
        return ResponseEntity.ok(role);
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody @Valid RoleRequest dto) {
        final Role createdRole = roleService.create(dto);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> update(@PathVariable Long id, @RequestBody @Valid RoleRequest dto) {
        final Role updatedRole = roleService.update(id, dto);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
