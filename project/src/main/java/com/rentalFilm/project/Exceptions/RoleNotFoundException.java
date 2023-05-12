package com.rentalFilm.project.Exceptions;

public class RoleNotFoundException extends Exception{
    public RoleNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
