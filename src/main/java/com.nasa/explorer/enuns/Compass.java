package com.nasa.explorer.enuns;

import com.nasa.explorer.exceptions.CommandInvalidException;
import com.nasa.explorer.exceptions.CompassInvalidException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Compass {
    NORTH(0, 1, "N"),
    EAST(1, 0, "E"),
    SOUTH(0, -1, "S"),
    WEST(-1, 0, "W");

    private int axleX;
    private int axleY;
    private String surname;

    Compass(int x, int y, String surname){
        this.axleX = x;
        this.axleY = y;
        this.surname = surname;
    }

    public int getAxleX() {
        return axleX;
    }

    public String getSurname() {
        return surname;
    }

    public int getAxleY() {
        if(this.name().equals(NORTH.name())){
            return axleY+1;
        }
        return axleY;
    }

    public Compass getDirection(Command command){
        List<Compass> compass = Arrays.asList(Compass.values());
        int index = compass.indexOf(this);

        if(index <= 0  && command == Command.LEFT){
            return compass.get(compass.size()-1);
        }else if(index >= compass.size()-1 && command == Command.RIGTH){
            return compass.get(0);
        }
        return Compass.values()[index+command.getValue()];
    }


    public static Compass getCompassWithString(String surnameLine){
        Optional<Compass> compass = Arrays.stream(Compass.values())
                .filter(object -> object.surname.equals(surnameLine.toUpperCase())).findFirst();
        compass.orElseThrow(() -> new CompassInvalidException());

        return compass.get();
    }

}
