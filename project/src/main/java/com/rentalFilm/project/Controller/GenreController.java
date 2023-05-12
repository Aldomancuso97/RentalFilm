package com.rentalFilm.project.Controller;
import com.rentalFilm.project.Entities.DTO.GenreDTO;
import com.rentalFilm.project.Exceptions.GenreNotFoundException;
import com.rentalFilm.project.Service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    Logger logger = LoggerFactory.getLogger(GenreController.class);

    @PostMapping ("/addNewGenre")
    public ResponseEntity addNewGenre(@RequestBody GenreDTO genreDTO){
        try{
            logger.info("Trying to add a new genre");
            return ResponseEntity.status(HttpStatus.OK).body(genreService.addNewGenre(genreDTO));
        }catch (GenreNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    @GetMapping ("/show/{id}")
    public ResponseEntity getOneGenre(@PathVariable Long id){
        try{
            logger.info("Trying to get one genre");
            return ResponseEntity.status(HttpStatus.OK).body(genreService.getOneGenre(id));
        }catch (GenreNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/showAll")
    public ResponseEntity getAllGenres() {
        try{
            logger.info("Trying to get all genres");
            return ResponseEntity.status(HttpStatus.OK).body(genreService.getAllGenres());
        }catch (GenreNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());


        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateGenre(@PathVariable Long id,@RequestBody GenreDTO genreDTO){
        try{
            logger.info("Trying to update selected genre ");
            return ResponseEntity.status(HttpStatus.OK).body(genreService.updateGenre(id, genreDTO));
        }catch (GenreNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteGenre(@PathVariable Long id){
        try{
            logger.info("Trying to delete selected genre");
            return ResponseEntity.status(HttpStatus.OK).body(genreService.deleteGenre(id));
        }catch (GenreNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllGenres(){
        try{
            logger.info("Trying to delete all genres ");
            return ResponseEntity.status(HttpStatus.OK).body(genreService.deleteAllGenres());
        }catch (GenreNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
