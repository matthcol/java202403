package cinema.model.demo;

import cinema.model.Movie;
import cinema.model.Person;
import cinema.utils.CsvAdapter;
import cinema.utils.FilePathResourceUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                .forEach(movie -> System.out.println(movie)); // eq: System.out::println
        personList.stream()
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    void demoMovieByYear(){
        int year = 1977;
        movieList.stream()
                .filter(movie -> movie.getYear() == year)
                .forEach(System.out::println);
    }

    @Test
    void demoMovieByYearToList(){
        int year = 1977;
        var moviesThisYear =  movieList.stream()
                .filter(movie -> movie.getYear() == year)
                // .toList(); // Java 17
                .collect(Collectors.toList());
        System.out.println("Selection: " + moviesThisYear);
        System.out.println("Count: "
                + moviesThisYear.size()
                + " / " + movieList.size()
        );
    }

    @ParameterizedTest
    @ValueSource(strings={"jaws", "the", "Jedi", "The Gauntlet", "trek"})
    void demoMovieTitleContaining(String titlePart){
        // result in a list
        var result = movieList.stream()
                // .filter(movie -> movie.getTitle().equals(titlePart))
                .filter(movie -> movie.getTitle().toLowerCase().contains(titlePart.toLowerCase()))
                .toList();
        System.out.println(MessageFormat.format("Selection [{0}/{1}]: {2}",
                result.size(),
                movieList.size(),
                result
        ));
    }

    @Test
    void demoTitle60sToList(){
        // select title from years 60s
        var result = movieList.stream()
                .filter(movie -> (1960 <= movie.getYear()) && (movie.getYear() < 1970))
                // .map(movie -> movie.getTitle())
                .map(Movie::getTitle)
                .filter(title -> title.toLowerCase().contains("dollar"))
                .toList();
        System.out.println(result);
    }

    @Test
    void demoTitle60sToString(){
        // select title from years 60s
        var result = movieList.stream()
                .filter(movie -> (1960 <= movie.getYear()) && (movie.getYear() < 1970))
                // .map(movie -> movie.getTitle())
                .map(Movie::getTitle)
                .filter(title -> title.toLowerCase().contains("dollar"))
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }

    @Test
    void demoSortedTitle60s() {
        // select title from years 60s
        var result = movieList.stream()
                .filter(movie -> (1960 <= movie.getYear()) && (movie.getYear() < 1970))
                .map(Movie::getTitle)
                .sorted()
                .toList();
        System.out.println(result);
    }

    @ParameterizedTest
    @ValueSource(strings={"star wars", "star trek"})
    void demoCount(String titleBegin) {
        // result is a long !
        var result = movieList.stream()
                .filter(movie -> movie.getTitle().toLowerCase().startsWith(titleBegin))
                .count();
        System.out.println("Count: " + result);
    }

    @ParameterizedTest
    @ValueSource(strings={"star wars", "star trek"})
    void demoMinYear(String titleBegin) {
        var result = movieList.stream()
                .filter(movie -> movie.getTitle().toLowerCase().startsWith(titleBegin))
                .mapToInt(Movie::getYear)
                .min();
        System.out.println(result);
    }

    // durée totale des star wars
    @ParameterizedTest
    @ValueSource(strings={"star wars", "star trek", "hefty"})
    void demoSum(String titleBegin){
        var totalDuration = movieList.stream()
                .filter(movie -> movie.getTitle().toLowerCase().startsWith(titleBegin))
                .filter(movie -> Objects.nonNull(movie.getDuration()))
                .mapToInt(Movie::getDuration)
                .sum();
        System.out.println(totalDuration);
    }

    @ParameterizedTest
    @ValueSource(strings={"star wars", "star trek", "hefty"})
    void demoSumDouble(String titleBegin){
        var totalDuration = movieList.stream()
                .filter(movie -> movie.getTitle().toLowerCase().startsWith(titleBegin))
                .mapToDouble(movie -> Objects.nonNull(movie.getDuration())
                        ? (double)movie.getDuration()
                        : Double.NaN)
                .sum();
        System.out.println(totalDuration);
    }

    // longueur de titre minimale
    // longueur de titre maximale
    @Test
    void demoMinMaxLengthTitle(){
        int minLength = movieList.stream()
                .map(Movie::getTitle)
                .mapToInt(String::length)
                .min()
                .getAsInt();
        int maxLength = movieList.stream()
                .map(Movie::getTitle)
                .mapToInt(String::length)
                .max()
                .getAsInt();
        System.out.println(MessageFormat.format(
                "Title length: min = {0}, max = {1}",
                minLength,
                maxLength
        ));
    }

    // count, min, max, av, sum des star wars
    @ParameterizedTest
    @ValueSource(strings={"star wars", "star trek", "hefty"})
    void demoIntStatistics(String titleBegin){
        var result = movieList.stream()
                .filter(movie -> movie.getTitle().toLowerCase().startsWith(titleBegin))
                .filter(movie -> Objects.nonNull(movie.getDuration()))
                .mapToInt(Movie::getDuration)
                .summaryStatistics();
        System.out.println(MessageFormat.format(
                "Movies begining by '{0}': {1}",
                titleBegin,
                result
        ));
    }

    @Test
    void sumDrationWithReduce(){
        var result = movieList.stream()
                .filter(movie -> Objects.nonNull(movie.getDuration()))
                .mapToInt(Movie::getDuration)
                .reduce(0, (d1, d2) -> d1 + d2); // i.e. Integer::sum
    }

    // écart type avec reduce

    // titre le plus long (court)
    @Test
    void demoMovieWithLongestTitle(){
        OptionalInt optMaxLength = movieList.stream()
                .map(Movie::getTitle)
                .mapToInt(String::length)
                .max();
        if (optMaxLength.isPresent()){
            int maxLength = optMaxLength.getAsInt();
            var longestTitles = movieList.stream()
                    .map(Movie::getTitle)
                    .filter(t -> t.length() == maxLength)
                    .toList();
            System.out.println("Max length: " + maxLength);
            System.out.println(longestTitles);
        } else {
            System.out.println("No input data");
        }
    }

    @Test
    void demoMovieWithShortestTitle() {
        movieList.stream()
                .map(Movie::getTitle)
                .mapToInt(String::length)
                .min()
                .ifPresent(minLength -> movieList.stream()
                        .map(Movie::getTitle)
                        .filter(t -> t.length() == minLength)
                        .forEach(System.out::println)
                );
    }

    // compter films par année des années 80
    @Test
    void demoGroupingByYear(){
        var moviesByYear = movieList.stream()
                // .mapToInt(Movie::getYear)
                .filter(m -> (1980 <= m.getYear()) && (m.getYear() < 1990))
                .collect(Collectors.groupingBy(Movie::getYear));
        System.out.println(moviesByYear); // Map<Integer, List<Movie>>
        System.out.println();
        System.out.println(moviesByYear.get(1982)); // List<Movie>
        System.out.println();
        var countByYear = movieList.stream()
                .filter(m -> (1980 <= m.getYear()) && (m.getYear() < 1990))
                .collect(Collectors.groupingBy(
                        Movie::getYear,
                        TreeMap::new,
                        Collectors.counting()
                ));
        System.out.println(countByYear);  // Map<Integer, Long>
        System.out.println();
        System.out.println(countByYear.get(1982)); // Long
        System.out.println();
    }

    // Movie + 1 compteur

    static Stream<Comparator<Movie>> movieComparators(){
        return Stream.of(
                Comparator.comparing(Movie::getTitle),
                Comparator.comparing(Movie::getTitle, String::compareToIgnoreCase),
                Comparator.comparing(Movie::getTitle, Comparator.reverseOrder()),
                Comparator.comparingInt(Movie::getYear),
                Comparator.comparingInt(Movie::getYear)
                        .thenComparing(Movie::getTitle, String::compareToIgnoreCase),
                // year desc, title CI
                Comparator.comparingInt(Movie::getYear).reversed()
                        .thenComparing(Movie::getTitle, String::compareToIgnoreCase)
                // duration desc, title CI
                // title length desc, title CI
                // title CI reversed
        );
    }
    @ParameterizedTest
    @MethodSource("movieComparators")
    void demoSortMovies(Comparator<Movie> movieCmp){
        var sortedMovies = movieList.stream()
                .sorted(movieCmp)
                .toList();
        System.out.println(sortedMovies);
    }

    static Stream<Arguments> movieNamedComparators(){
        return Stream.of(
                Arguments.of(Named.of(
                        "title ASC",
                        Comparator.comparing(Movie::getTitle)
                )),
                Arguments.of(Named.of(
                        "title CI ASC",
                        Comparator.comparing(Movie::getTitle, String::compareToIgnoreCase)
                )),
                Arguments.of(Named.of(
                        "title DESC",
                        Comparator.comparing(Movie::getTitle, Comparator.reverseOrder())
                )),
                Arguments.of(Named.of(
                        "year ASC",
                        Comparator.comparingInt(Movie::getYear)
                )),
                Arguments.of(Named.of(
                        "year ASC, title CI ASC",
                        Comparator.comparingInt(Movie::getYear)
                                .thenComparing(Movie::getTitle, String::compareToIgnoreCase)
                )),
                Arguments.of(Named.of(
                        "year DESC title, CI ASC",
                        Comparator.comparingInt(Movie::getYear).reversed()
                                .thenComparing(Movie::getTitle, String::compareToIgnoreCase)
                )),
                Arguments.of(Named.of(
                        "duration DESC, title CI ASC",
                        Comparator.comparing(Movie::getDuration, Comparator.nullsLast(Comparator.reverseOrder()))
                                .thenComparing(Movie::getTitle, String::compareToIgnoreCase)
                )),
                //
                Arguments.of(Named.of(
                        "title length DESC, title CI ASC",
                        Comparator.comparingInt((Movie m) -> m.getTitle().length()).reversed()
                                .thenComparing(Movie::getTitle, String::compareToIgnoreCase)
                )),
                // title CI reversed
                Arguments.of(Named.of(
                        "title CI DESC",
                        Comparator.comparing((Movie m) -> m.getTitle().toLowerCase()).reversed()
                )),
                Arguments.of(Named.of(
                        "title CI DESC 2",
                        Comparator.comparing(Movie::getTitle, String::compareToIgnoreCase).reversed()
                )),
                Arguments.of(Named.of(
                        "title CI DESC 3",
                        Comparator.comparing((Movie m) -> m.getTitle().toLowerCase(), Comparator.reverseOrder())
                )),
                Arguments.of(Named.of(
                        "title CI DESC 3",
                        Comparator.comparing(Movie::getTitle, (t1, t2) -> t2.compareToIgnoreCase(t1))
                ))
        );
    }
    @ParameterizedTest
    @MethodSource("movieNamedComparators")
    void demoSortMovies2(Comparator<Movie> movieCmp){
        var sortedMovies = movieList.stream()
                .sorted(movieCmp)
                .toList();
        sortedMovies.forEach(m -> System.out.println(
                MessageFormat.format(
                        "- {0} ({1,number,####}, {2} mn)",
                        m.getTitle(),
                        m.getYear(),
                        m.getDuration()
                ))
        );
    }

}
