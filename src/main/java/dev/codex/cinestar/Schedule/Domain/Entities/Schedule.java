package dev.codex.cinestar.Schedule.Domain.Entities;

import dev.codex.cinestar.Movie.Domain.Entities.Movie;
import dev.codex.cinestar.Room.Domain.Entities.Room;
import dev.codex.cinestar.Schedule.Domain.ValueObjects.ScheduleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Movie movie;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Room room;

    @Enumerated(EnumType.STRING)
    private ScheduleStatus status;

    @Column(name = "schedule_date")
    private Date scheduleDate;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "is_full")
    private Boolean isFull = false;

    public Schedule(Movie movie, Room room, ScheduleStatus status, Date scheduleDate, String startTime, String endTime, Boolean isFull) {
        this.movie = movie;
        this.room = room;
        this.status = status;
        this.scheduleDate = scheduleDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isFull = isFull;
    }
}
