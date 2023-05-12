package com.rentalFilm.project.Service;

import com.rentalFilm.project.Entities.DTO.FilmDTO;
import com.rentalFilm.project.Entities.Entity.Film;
import com.rentalFilm.project.Exceptions.FilmNotFoundException;
import com.rentalFilm.project.Repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;


    public Film addNewFilm(FilmDTO filmDTO) throws FilmNotFoundException {
        Film film = new Film();
        film.setID(filmDTO.getID());
        film.setTitle(filmDTO.getTitle());
        film.setDescription(filmDTO.getDescription());
        film.setReleaseYear(filmDTO.getReleaseYear());
        return filmRepository.save(film);
    }

    public Film getFilmById(Long id) throws FilmNotFoundException {
        Optional<Film> filmOptional = filmRepository.findById(id);
        if (filmOptional.isPresent()) {
            return filmOptional.get();
        }
        return null;
    }

    public List<Film> getAllFilms() throws FilmNotFoundException {
        List <Film> films = new ArrayList<>();
        films = filmRepository.findAll();
        films.stream()
                .findAny()
                .get()
                .toString();

        return films;
    }

    public Film updateFilm(Long id, FilmDTO filmDTO) throws FilmNotFoundException {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
            film.setDescription(filmDTO.getDescription());
            film.setTitle(filmDTO.getTitle());
            film.setReleaseYear(filmDTO.getReleaseYear());
            return filmRepository.save(film);
        }
        return null;
    }

    public Film deleteFilmById(Long id) throws FilmNotFoundException {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (optionalFilm.isPresent()) {
            filmRepository.deleteById(id);
        }
        return null;
    }

    public List <Film> deleteAllFilms() throws FilmNotFoundException {
        List <Film> films = new ArrayList<>();
        films = filmRepository.findAll();
        if(!films.isEmpty()){
            filmRepository.deleteAll();
        }

        return films;
    }
}

