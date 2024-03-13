package cinema.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of = "name")
public class Person {
    private String name;
    private LocalDate birthdate;
}
