package dev.codex.cinestar.Room.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.codex.cinestar.Room.Domain.ValueObjects.ZonePosition;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "zones")
public class Zone {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long capacity;

    private Long price;

    @Enumerated(EnumType.STRING)
    private ZonePosition position;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "room_id")
    @JsonIgnore
    private Room room;
}
