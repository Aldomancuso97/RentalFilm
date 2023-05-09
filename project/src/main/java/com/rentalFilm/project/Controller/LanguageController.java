package com.rentalFilm.project.Controller;
import com.rentalFilm.project.Entities.DTO.LanguageDTO;
import com.rentalFilm.project.Exceptions.LanguagesNotFoundException;
import com.rentalFilm.project.Service.LanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    Logger logger = LoggerFactory.getLogger(LanguageController.class);

    @PostMapping("/addNewLanguage")
    public ResponseEntity addNewLanguage(@RequestBody LanguageDTO languageDTO){
        try{
            logger.info("Trying to add a new language");
            return ResponseEntity.status(HttpStatus.OK).body(languageService.addNewLanguage(languageDTO));
        }catch (LanguagesNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    @GetMapping("/show/{id}")
    public ResponseEntity getOneLanguage(@PathVariable Long id){
        try{
            logger.info("Trying to get one language");
            return ResponseEntity.status(HttpStatus.OK).body(languageService.getOneLanguage(id));
        }catch (LanguagesNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/showAll")
    public ResponseEntity getAllLanguages() throws LanguagesNotFoundException {
        try{
            logger.info("Trying to get all languages");
            languageService.getAllLanguages();
        }catch (LanguagesNotFoundException e){
            logger.warn(e.getMessage());
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }finally {
            return ResponseEntity.status(HttpStatus.OK).body(languageService.getAllLanguages());

        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateLanguage(@PathVariable Long id,@RequestBody LanguageDTO languageDTO){
        try{
            logger.info("Trying to update selected language ");
            return ResponseEntity.status(HttpStatus.OK).body(languageService.updateLanguage(id, languageDTO));
        }catch (LanguagesNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLanguage(@PathVariable Long id){
        try{
            logger.info("Trying to delete selected language");
            return ResponseEntity.status(HttpStatus.OK).body(languageService.deleteLanguage(id));
        }catch (LanguagesNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllLanguages() throws LanguagesNotFoundException{
        try{
            logger.info("Trying to delete all languages ");
            return ResponseEntity.status(HttpStatus.OK).body(languageService.deleteAllLanguages());
        }catch (LanguagesNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }
}
