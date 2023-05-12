package com.rentalFilm.project.Exceptions;

public class GenreNotFoundException extends Exception{
    public GenreNotFoundException (String errorMessage){
        super(errorMessage);
    }
}
