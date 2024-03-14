package cinema.utils;

import cinema.model.Movie;
import cinema.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public class CsvAdapter {

    public static Movie movieFromLine(String line, String separator){
        var words = line.split(separator, -1);
        // code suivant inutile (juste pour jouer avec les streams)
        // var infos = Arrays.stream(words)
        //        .limit(4)
        //        .toList();
        return new Movie(
                words[1],
                Integer.parseInt(words[2]),
                words[3].isEmpty() ? null : Integer.parseInt(words[3])
        );
    }

    public static Movie movieFromLineDefault(String line){
        return movieFromLine(line, ",");
    }

    public static Movie movieFromLineTsv(String line){
        return movieFromLine(line, "\t");
    }

    public static Person personFromLine(String line, String separator){
        var words = line.split(separator, -1);
        // code suivant inutile (juste pour jouer avec les streams)
        // var infos = Arrays.stream(words)
        //        .limit(4)
        //        .toList();
        return new Person(
                words[1],
                words[2].isEmpty() ? null : LocalDate.parse(words[2])
        );
    }

    public static Person personFromLineDefault(String line){
        return personFromLine(line, ",");
    }

    public static Person personFromLineTsv(String line){
        return personFromLine(line, "\t");
    }

    public static <T> List<T> readFileWithHeader(Path path, Function<String,T> adapter){
        try (var stream = Files.lines(path)) {
            return stream
                    .skip(1) // omit headers
                    .map(adapter)
                    .toList();
            // auto close file in any case (ok or error)
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file:" + path, e);
        }
    }
}
