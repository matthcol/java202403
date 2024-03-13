package cinema.model.demo;

import cinema.model.Movie;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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
        var lines = Files.lines(path)
                .skip(1) // skip headers
                .limit(3)
                .toList();
        System.out.println(lines);
        // read all movies from csv file
        List<Movie> movies;
    }
}
