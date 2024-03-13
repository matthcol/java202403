package cinema.utils;

import cinema.model.Movie;

import java.util.Arrays;

public class CsvAdapter {

    public static Movie fromLine(String line){
        var words = line.split(",");
        var infos = Arrays.stream(words)
                .limit(4)
                .toList();
        return new Movie(
                infos.get(1),
                Integer.parseInt(infos.get(2)),
                Integer.parseInt(infos.get(3))
        );
    }
}
