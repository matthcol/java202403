package cinema.model.demo;

import cinema.model.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieDemo {

    @Test
    void demoOneMovie(){
        Movie movie = new Movie();
        System.out.println(movie);
    }

    @Test
    void demoOneMovieJava11(){
        var movie = new Movie();
        System.out.println(movie);
    }

    @Test
    void demoTwoMovies(){
        var movie1 = new Movie();
        var movie2 = new Movie();
        System.out.println(movie1);
        System.out.println(movie1);
    }

    @Test
    void demoMovieDune(){
        var movie = new Movie("Dune: Part Two", 2024, 166);
        System.out.println(movie);
        System.out.println(movie.toString());
        System.out.println(movie.getTitle());
        movie.setTitle("Dune : Partie 2");
        System.out.println(movie);
    }

}