package com.nasa.explorer.exceptions;

public class CompassInvalidException extends RuntimeException{
    public CompassInvalidException() {
        super("Direção invalida.");
    }
}
