package org.example.cinema.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

// JPA
@Entity
// lombok
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(of={"id", "title", "year"})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min=1, max=30)
    @Column(nullable = false, length = 350)
    private String title;

    @Min(1888)
    private int year;

    @Min(40)
    private Integer duration;

    @Max(4000)
    @Column(length = 4000)
    private String synopsis;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="director_id")
    private Person director;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "play",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="actor_id")
    )
    private Set<Person> actors = new HashSet<>();
}
