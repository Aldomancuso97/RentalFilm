package com.rentalFilm.project.Service;

import com.rentalFilm.project.Entities.DTO.LanguageDTO;
import com.rentalFilm.project.Entities.Entity.Film;
import com.rentalFilm.project.Entities.Entity.Language;
import com.rentalFilm.project.Exceptions.FilmNotFoundException;
import com.rentalFilm.project.Exceptions.LanguagesNotFoundException;
import com.rentalFilm.project.Repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    LanguageRepository languageRepository;


    public List<Language> getAllLanguages() throws LanguagesNotFoundException {
        List <Language> optionalLanguage = languageRepository.findAll();
        if(optionalLanguage.isEmpty()) {
            return null;
        }
        return optionalLanguage;
    }

    public Language addNewLanguage(LanguageDTO languageDTO) throws LanguagesNotFoundException {
        Language language = new Language();
        language.setLanguage(languageDTO.getLanguage());
        language.setID(languageDTO.getID());
        return languageRepository.save(language);

    }

    public Language getOneLanguage(Long id) throws LanguagesNotFoundException{
        Optional <Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()){
            return optionalLanguage.get();
        }
        return null;
    }

    public Language updateLanguage(Long id, LanguageDTO languageDTO) throws LanguagesNotFoundException{
        Optional <Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()){
            Language language = optionalLanguage.get();
            language.setLanguage(languageDTO.getLanguage());
            return languageRepository.save(language);
        }


        return null;
    }

    public Language deleteLanguage(Long id) throws LanguagesNotFoundException {
        Optional <Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()){
            languageRepository.deleteById(id);
        }
        return null;
    }
    public List <Language> deleteAllLanguages() throws LanguagesNotFoundException {
        List <Language> languages = new ArrayList<>();
        languages = languageRepository.findAll();
        if(!languages.isEmpty()){
            languageRepository.deleteAll();
        }

        return languages;
    }
}
