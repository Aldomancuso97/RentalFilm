package com.rentalFilm.project.Controller;
import com.rentalFilm.project.Entities.DTO.FilmDTO;
import com.rentalFilm.project.Exceptions.FilmNotFoundException;
import com.rentalFilm.project.Service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    private final Logger logger = LoggerFactory.getLogger(FilmController.class);

    @PostMapping("/addNewFilm")
    public ResponseEntity addFilms(@RequestBody FilmDTO filmDTO){
        try{
            logger.info("Trying to add a new film : " +  " " + filmDTO);
            return ResponseEntity.status(HttpStatus.OK).body(filmService.addNewFilm(filmDTO));
        }catch (FilmNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{Id}")
    public ResponseEntity getFilmById(@PathVariable Long  Id) {
        try {
            logger.info("try to find a film by ID" + " : " + Id);
            return ResponseEntity.status(HttpStatus.OK).body(filmService.getFilmById(Id));
        }catch(FilmNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }

    }
    @GetMapping("/showAll")
    public ResponseEntity showFilms(){
        try{
            logger.info("finding all present films: ");
            return ResponseEntity.status(HttpStatus.OK).body(filmService.getAllFilms());
        }catch (FilmNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateFilm(@PathVariable Long id, @RequestBody FilmDTO filmDTO){
        try{
            logger.info("Trying to update selected film : " + id);
            return ResponseEntity.status(HttpStatus.OK).body(filmService.updateFilm(id, filmDTO));
        }catch (FilmNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteFilm(@PathVariable Long id){
        try{
            logger.info("Trying to delete selected film : " + id);
            return ResponseEntity.status(HttpStatus.OK).body(filmService.deleteFilmById(id));
        }catch (FilmNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllFilms(){
        try{
            logger.info("Trying to delete all films " );
            return ResponseEntity.status(HttpStatus.OK).body(filmService.deleteAllFilms());
        }catch (FilmNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
