package com.rentalFilm.project.Exceptions;

public class LanguagesNotFoundException extends Exception{
    public LanguagesNotFoundException (String errorMessage){
        super(errorMessage);
        errorMessage = "Languages not found";
    }
}
