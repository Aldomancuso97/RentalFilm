package com.rentalFilm.project.Service;

import com.rentalFilm.project.Entities.DTO.GenreDTO;
import com.rentalFilm.project.Entities.Entity.Genre;
import com.rentalFilm.project.Exceptions.GenreNotFoundException;
import com.rentalFilm.project.Repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public Genre addNewGenre(GenreDTO genreDTO) throws GenreNotFoundException {
        Genre genre = new Genre();
        genre.setGenreName(genreDTO.getGenreName());
        genre.setID(genreDTO.getID());
        return genreRepository.save(genre);

    }

    public Genre getOneGenre(Long id) throws GenreNotFoundException{
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        if(optionalGenre.isPresent()){
            return optionalGenre.get();
        }
        return null;
    }

    public List<Genre> getAllGenres() throws GenreNotFoundException {
        List <Genre> optionalGenre = genreRepository.findAll();
        if(optionalGenre.isEmpty()) {
            return null;
        }
        return optionalGenre;
    }

    public Genre updateGenre(Long id, GenreDTO genreDTO) throws GenreNotFoundException{
        Optional <Genre> optionalGenre = genreRepository.findById(id);
        if(optionalGenre.isPresent()){
            Genre genre = optionalGenre.get();
            genre.setGenreName(genreDTO.getGenreName());
            return genreRepository.save(genre);
        }


        return null;
    }

    public Genre deleteGenre(Long id) throws GenreNotFoundException {
        Optional <Genre> optionalGenre = genreRepository.findById(id);
        if(optionalGenre.isPresent()){
            genreRepository.deleteById(id);
        }
        return null;
    }
    public List <Genre> deleteAllGenres() throws GenreNotFoundException {
        List <Genre> genres = new ArrayList<>();
        genres = genreRepository.findAll();
        if(!genres.isEmpty()){
            genreRepository.deleteAll();
        }

        return genres;
    }
}
