package com.rentalFilm.project.Exceptions;

public class FilmNotFoundException extends Exception {
    public FilmNotFoundException(String errorMessage){
        super(errorMessage);
        errorMessage = "Film not found";
}}
