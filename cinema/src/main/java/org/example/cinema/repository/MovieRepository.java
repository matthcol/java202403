package org.example.cinema.repository;

import org.example.cinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByTitle(String title);
    List<Movie> findByYearBetween(int year1, int year2);

    @Query("select m from Movie m join m.director d where d.name = :name")
    List<Movie> findByDirector(String name);
}
