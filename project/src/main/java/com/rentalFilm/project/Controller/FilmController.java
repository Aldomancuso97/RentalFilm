package com.rentalFilm.project.Controller;
import com.rentalFilm.project.Exceptions.FilmNotFoundException;
import com.rentalFilm.project.Service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    Logger logger = LoggerFactory.getLogger(FilmController.class);
    @GetMapping("/{Id}")
    public ResponseEntity getFilmById(@PathVariable Long  Id) {
        try {
            logger.info("try to find a film by ID" + Id);
            return ResponseEntity.status(HttpStatus.OK).body(filmService.getFilmById(Id));
    }catch(FilmNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }

    }
}
