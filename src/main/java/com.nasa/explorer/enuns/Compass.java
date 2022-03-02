package com.nasa.explorer.enuns;

import java.util.Arrays;
import java.util.List;

public enum Compass {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    private int axleX;
    private int axleY;

    Compass(int x, int y){
        this.axleX = x;
        this.axleY = y;
    }

    public int getAxleX() {
        return axleX;
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
}
