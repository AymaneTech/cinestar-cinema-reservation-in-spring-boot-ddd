package dev.codex.cinestar.Room.Domain.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long capacity;

    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Zone> zones;

    public Room(String name, Long capacity) {
        this.name = name;
        this.capacity = capacity;
        this.zones = zones;
    }
}
