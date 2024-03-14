package cinema.model.demo;

import cinema.model.Movie;
import cinema.model.Person;
import cinema.utils.CsvAdapter;
import cinema.utils.FilePathResourceUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MovieStreamDemo {

    static List<Movie> movieList;
    static List<Person> personList;

    @BeforeAll
    static void readMovies() {
        movieList = CsvAdapter.readFileWithHeader(
                FilePathResourceUtils.pathFromResource(MovieStreamDemo.class, "/movies.tsv"),
                CsvAdapter::movieFromLineTsv
        );
        personList = CsvAdapter.readFileWithHeader(
                FilePathResourceUtils.pathFromResource(MovieStreamDemo.class, "/persons.tsv"),
                CsvAdapter::personFromLineTsv
        );
    }

    @Test
    void demoPeakFirst(){
        movieList.stream()
                .limit(3)
                .forEach(System.out::println);
        personList.stream()
                .limit(3)
                .forEach(System.out::println);
    }
}
