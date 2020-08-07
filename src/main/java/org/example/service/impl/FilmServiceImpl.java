package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.FilmDAO;
import org.example.model.Film;
import org.example.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmDAO filmDAO;


    @Override
    public Film save(Film film) throws Exception {

        //не пойму как сделать проверку если название одинаковое а год разный
        // сейчас реализация проверки не верна
        if (film.getId() != null &&
                (!filmDAO.findAllByMovieTitle(film.getMovieTitle()).isEmpty() &&
                        !filmDAO.findAllByReleaseDate(film.getReleaseDate()).isEmpty())) {
            throw new Exception("film already exists");
        }
        return filmDAO.save(film);
//        Film film1 = filmDAO.save(film).orElseThrow(() -> new NoEntityException(userId));
//        Film film2 =
    }

    @Override
    public Film findById(Integer id) throws Exception {
        return filmDAO.findById(id).orElseThrow(() -> new Exception("movie not found"));
    }

    @Override
    public Film update(Film film) throws Exception {
        if (film.getId() == null || filmDAO.findById(film.getId()) == null) {
            throw new Exception("movie id not found");
        }
        return filmDAO.save(film);
    }

    @Override
    public void delete(Film film) {
        filmDAO.delete(film);
    }

    @Override
    public List<Film> findAllByMovieTitle(String movieTitle) throws Exception {
        if (filmDAO.findAllByMovieTitle(movieTitle).isEmpty()){
            throw new Exception("no films with this name found");
        }
        return filmDAO.findAllByMovieTitle(movieTitle);
    }

    @Override
    public List<Film> findAllByReleaseDate(LocalDate releaseDate) throws Exception {
        if (filmDAO.findAllByReleaseDate(releaseDate).isEmpty()){
            throw new Exception("no films with this release date found");
        }
        return filmDAO.findAllByReleaseDate(releaseDate);
    }

    @Override
    public List<Film> findAllByReleaseDateBeforeAndReleaseDateIsAfter(LocalDate releaseDateBefore, LocalDate releaseDateAfter) throws Exception {
        if (filmDAO.findAllByReleaseDateBeforeAndReleaseDateIsAfter(releaseDateBefore, releaseDateAfter).isEmpty()){
            throw new Exception("no movies found in this time frame");
        }
        return filmDAO.findAllByReleaseDateBeforeAndReleaseDateIsAfter(releaseDateBefore, releaseDateAfter);
    }
}
