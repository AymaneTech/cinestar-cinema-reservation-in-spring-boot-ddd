package dev.codex.cinestar.User.Application.Services.Impl;

import dev.codex.cinestar.User.Application.DTOs.Requests.UserRequest;
import dev.codex.cinestar.User.Application.Services.RoleService;
import dev.codex.cinestar.User.Application.Services.UserService;
import dev.codex.cinestar.User.Domain.Entities.Role;
import dev.codex.cinestar.User.Domain.Entities.User;
import dev.codex.cinestar.User.Domain.Exceptions.UserNotFoundException;
import dev.codex.cinestar.User.Infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final RoleService roleService;
//    private final  passwordEncoder; // Todo: Add passwordEncoder


    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User create(UserRequest request) {
        final Role role = roleService.findById(request.roleId());
        final String encodedPassword = "password"; // Todo: passwordEncoder.encode(request.password());
        final User user = new User(request.email(), request.firstName(), request.lastName(), encodedPassword, role);
        return repository.save(user);
    }

    @Override
    public User update(Long id, UserRequest request) {
        final User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        final Role role = roleService.findById(request.roleId());

        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPassword(request.password());
        user.setRole(role);
        return repository.save(user);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new UserNotFoundException(id);
        repository.deleteById(id);
    }
}
