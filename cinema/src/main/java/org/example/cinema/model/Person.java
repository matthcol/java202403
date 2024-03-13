package org.example.cinema.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

// JPA
@Entity
// lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of = "name")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String name;

    private LocalDate birthdate;
}
