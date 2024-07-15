package dev.codex.cinestar.Schedule.Interfaces.web;

import dev.codex.cinestar.Schedule.Application.DTOs.Requests.ScheduleRequest;
import dev.codex.cinestar.Schedule.Application.Services.ScheduleService;
import dev.codex.cinestar.Schedule.Domain.Entities.Schedule;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService service;

    @GetMapping
    public ResponseEntity<List<Schedule>> findAll() {
        List<Schedule> schedules = service.findAll();
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> findById(@PathVariable Long id) {
        Schedule schedule = service.findById(id);
        return ResponseEntity.ok(schedule);
    }

    @PostMapping
    public ResponseEntity<Schedule> create(@RequestBody @Valid ScheduleRequest dto) {
        Schedule createdSchedule = service.create(dto);
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> update(@PathVariable Long id, @RequestBody @Valid ScheduleRequest dto) {
        Schedule schedule = service.update(id, dto);
        return ResponseEntity.ok(schedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
