package dev.codex.cinestar.Booking.Domain.Entities;

import dev.codex.cinestar.Schedule.Domain.Entities.Schedule;
import dev.codex.cinestar.User.Domain.Entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User member;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Schedule schedule;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Seat seat;
}
