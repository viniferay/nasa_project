package com.nasa.explorer.exceptions;

public class CommandInvalidException extends RuntimeException{
    public CommandInvalidException() {
        super("Comandos não reconhecido. 'L' ou 'R' são os comandos validos para direcionamento");
    }
}
