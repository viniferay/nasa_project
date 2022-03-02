package com.nasa.explorer;

import com.nasa.explorer.enuns.Compass;

public class Explorer {
    private Compass direction;
    private int positionY;
    private int positionX;

    public Compass getDirection() {
        return direction;
    }

    public void setDirection(Compass direction) {
        this.direction = direction;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void move(){
        positionX += direction.getAxleX();
        positionY += direction.getAxleY();
    }
    
}
