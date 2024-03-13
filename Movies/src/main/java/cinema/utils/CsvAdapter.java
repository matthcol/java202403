package cinema.utils;

import cinema.model.Movie;

import java.util.Arrays;

public class CsvAdapter {

    public static Movie movieFromLine(String line){
        var words = line.split(",");
        // code inutile (juste pour jouer avec les streams)
        var infos = Arrays.stream(words)
                .limit(4)
                .toList();
        return new Movie(
                infos.get(1),
                Integer.parseInt(infos.get(2)),
                infos.get(3).isEmpty() ? null : Integer.parseInt(infos.get(3))
        );
    }
}
