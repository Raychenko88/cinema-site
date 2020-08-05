package org.example.service;

import org.example.model.Film;

import java.time.LocalDate;
import java.util.List;

public interface FilmService {
    Film save(Film film) throws Exception;

    Film findById(Integer id) throws Exception;

    Film update(Film film) throws Exception;

    void delete(Film film);

    List<Film> findAllByMovieTitle(String movieTitle) throws Exception;

    List<Film> findAllByReleaseDate(LocalDate releaseDate) throws Exception;

    List<Film> findAllByReleaseDateBeforeAndReleaseDateIsAfter(LocalDate releaseDateBefore, LocalDate releaseDateAfter) throws Exception;
}
