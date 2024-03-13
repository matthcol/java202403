package cinema.model;

import lombok.*;

import java.util.StringJoiner;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of={"title", "year"})
public class Movie {

    private String title;
    private int year;
    private Integer duration;

}
