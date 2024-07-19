package dev.codex.cinestar.Booking.Domain.Entities;

import dev.codex.cinestar.Room.Domain.Entities.Zone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "seats")
public record Seat(
        @Id
        @GeneratedValue
        Long id,
        Long seatNumber,

        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        Zone zone
) {

}
