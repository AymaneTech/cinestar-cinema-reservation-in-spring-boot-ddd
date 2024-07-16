package dev.codex.cinestar.Schedule.Application.Services.Impl;

import dev.codex.cinestar.Common.Contracts.CrudService;
import dev.codex.cinestar.Movie.Application.Services.MovieService;
import dev.codex.cinestar.Movie.Domain.Entities.Movie;
import dev.codex.cinestar.Room.Application.Services.RoomService;
import dev.codex.cinestar.Room.Domain.Entities.Room;
import dev.codex.cinestar.Schedule.Application.DTOs.Requests.ScheduleRequest;
import dev.codex.cinestar.Schedule.Application.Services.ScheduleService;
import dev.codex.cinestar.Schedule.Domain.Entities.Schedule;
import dev.codex.cinestar.Schedule.Domain.Exceptions.ScheduleNotFoundException;
import dev.codex.cinestar.Schedule.Infrastructure.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository repository;

    private final MovieService movieService;
    private final RoomService roomService;

    @Override
    public List<Schedule> findAll() {
        return repository.findAll();
    }

    @Override
    public Schedule findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(id));
    }

    @Override
    @Transactional
    public Schedule create(ScheduleRequest request) {
        final Movie movie = findById(request.movieId(), movieService);
        final Room room = findById(request.roomId(), roomService);

        final Schedule schedule = new Schedule(
                movie,
                room,
                request.status(),
                request.scheduleDate(),
                request.startTime(),
                request.endTime(),
                false
        );
        return repository.save(schedule);
    }

    @Override
    @Transactional
    public Schedule update(Long id, ScheduleRequest request) {
        final Schedule schedule = repository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(id));
        final Movie movie = findById(request.movieId(), movieService);
        final Room room = findById(request.roomId(), roomService);

        schedule.setMovie(movie);
        schedule.setRoom(room);
        schedule.setStatus(request.status());
        schedule.setScheduleDate(request.scheduleDate());
        schedule.setStartTime(request.startTime());
        schedule.setEndTime(request.endTime());
        schedule.setIsFull(request.isFull());

        return repository.save(schedule);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id))
            throw new ScheduleNotFoundException(id);
        repository.deleteById(id);
    }

    private <T> T findById(Long id, CrudService service) {
        return (T) service.findById(id);
    }
}
