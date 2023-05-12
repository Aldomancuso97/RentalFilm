package com.rentalFilm.project.Exceptions;

public class StaffNotFoundException extends Exception {
    public StaffNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
