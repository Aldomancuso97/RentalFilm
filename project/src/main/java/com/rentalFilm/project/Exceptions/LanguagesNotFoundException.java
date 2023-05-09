package com.rentalFilm.project.Exceptions;

import lombok.Data;

public class LanguagesNotFoundException extends Exception{
    public LanguagesNotFoundException (String errorMessage){
        super(errorMessage);
        errorMessage = "Languages not found";
    }
}
