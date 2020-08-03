package org.example.dao;

import org.example.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FilmDAO extends JpaRepository<Film, Integer> {

    @Query(value =
            "SELECT * FROM cinema_site c " +
                    "WHERE c.movie_title ILIKE %:movieTitle%", nativeQuery = true)
    List<Film> findAllByMovieTitle(String movieTitle);
    List<Film> findAllByReleaseDate(LocalDate releaseDate);
    List<Film> findAllByReleaseDateBeforeAndReleaseDateIsAfter(LocalDate releaseDateBefore, LocalDate releaseDateAfter);
}
