package com.nasa.explorer.enuns;

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
        return axleY;
    }

}
