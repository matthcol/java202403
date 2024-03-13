package cinema.model.demo;

import cinema.model.Movie;
import cinema.utils.CsvAdapter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MovieFileDemo {

    @ParameterizedTest
    @CsvFileSource(resources = "/movies.csv", numLinesToSkip = 1)
    void demoMovieForeach(int id, String title, int year, Integer duration, String synopsis, String poster_uri){
        var movie = new Movie(title, year, duration);
        System.out.println(movie);
    }

    @ParameterizedTest
    @ValueSource(strings = "target/test-classes/movies.csv")
    void demoMovieCollectionFromFile(String filename) throws IOException {
        File file = new File(filename);
        System.out.println(file.exists());
        // readAllLines => List<String>
        var lines = Files.readAllLines(file.toPath());
        System.out.println(lines);
        // read all movies from csv file
        // List<Movie> movies;
    }

    @ParameterizedTest
    @ValueSource(strings = "target/test-classes/movies.csv")
    void demoMovieCollectionFromPath(String filename) throws IOException {
        var path = Path.of(filename);
        System.out.println(path.toFile().exists());
        // lines => Stream<String>
        var movies = Files.lines(path)
                .skip(1) // skip headers
//                .skip(800)
//                .limit(50)
//                .peek(System.out::println) // manual debug, log, ..
                .limit(800)
                .filter(line -> Character.isDigit(line.split(",")[2].charAt(0)))
                .map(CsvAdapter::movieFromLineDefault)
                .toList();
        System.out.println(movies);
    }

    @ParameterizedTest
    @ValueSource(strings = "target/test-classes/movies.tsv")
    void demoMovieCollectionFromPathTsv(String filename) throws IOException {
        var path = Path.of(filename);
        System.out.println(path.toFile().exists());
        // lines => Stream<String>
        var movies = Files.lines(path)
                .skip(1) // skip headers
                .map(CsvAdapter::movieFromLineTsv)
                .toList();
        System.out.println(movies);
    }
}
