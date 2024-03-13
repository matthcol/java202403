package cinema.utils;

import cinema.model.Movie;

import java.util.Arrays;

public class CsvAdapter {

    public static Movie movieFromLine(String line, String separator){
        var words = line.split(separator);
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

    public static Movie movieFromLineDefault(String line){
        return movieFromLine(line, ",");
    }

    public static Movie movieFromLineTsv(String line){
        return movieFromLine(line, "\t");
    }
}
