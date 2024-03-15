package cinema.model.demo;

import cinema.model.Movie;
import cinema.utils.CsvAdapter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class DemoResource {

    @Test
    void openCloseFileProperly() throws IOException {
        String filename = "/movies.tsv";
        File file = new File(getClass().getResource(filename).getFile());
        System.out.println(file);

        try (var fileStream = Files.lines(file.toPath())){
            fileStream.skip(1)
                    .map(CsvAdapter::movieFromLineTsv)
                    .forEach(System.out::println);
        } // auto try fileStream.close() => free file descriptor

    }

    @Test
    void openCloseFileProperly2() throws IOException {
        String filename = "/movies.tsv";
        File file = new File(getClass().getResource(filename).getFile());
        System.out.println(file);

        List<Movie> movieList;
        try (var fileStream = Files.lines(file.toPath())) {
            movieList = fileStream.skip(1)
                    .map(CsvAdapter::movieFromLineTsv)
                    .toList();
        } // auto try fileStream.close() => free file descriptor

        // use Data ?
        System.out.println(movieList);

    }
}
