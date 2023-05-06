package com.rentalFilm.project.Service;

import com.rentalFilm.project.Entities.Entity.Film;
import com.rentalFilm.project.Exceptions.FilmNotFoundException;
import com.rentalFilm.project.Repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public Film getFilmById(Long id) throws FilmNotFoundException {
        Optional <Film> filmOptional = filmRepository.findById(id);
        if(filmOptional.isPresent()) {
            return filmOptional.get(); }
        return null;
    }
}
