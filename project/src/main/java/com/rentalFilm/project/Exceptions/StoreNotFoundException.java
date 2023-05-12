package com.rentalFilm.project.Exceptions;

public class StoreNotFoundException extends Exception{
    public StoreNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
