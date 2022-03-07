package com.nasa.explorer;

import com.nasa.explorer.enuns.Command;
import com.nasa.explorer.enuns.Compass;

public class Explorer {
    private Compass direction;
    private int positionY;
    private int positionX;

    public Explorer() {
    }

    public Explorer(String direction, String positionY, String positionX) {
        this.direction = Compass.getCompassWithString(direction);
        this.positionY = Integer.parseInt(positionY);
        this.positionX = Integer.parseInt(positionX);
    }

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

    public void turnAround(Command command){
        this.direction = direction.getDirection(command);
    }

    public void move(){
        positionX += direction.getAxleX();
        positionY += direction.getAxleY();
    }

    public void playCommand(String commandLine){
        Command command = Command.getComand(commandLine);
        if (command.isMoveCommand()){
            move();
        }else{
            turnAround(command);
        }
    }

}