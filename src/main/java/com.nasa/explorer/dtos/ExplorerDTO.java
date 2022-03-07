package com.nasa.explorer.dtos;

import com.nasa.explorer.annotations.CommandValidation;
import com.nasa.explorer.annotations.DirectionValidation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ExplorerDTO {
    @NotNull(message = "{not.null}")
    private int positionY;
    @NotNull(message = "{not.null}")
    private int positionX;
    @NotNull
    @Size(min = 1, max = 1, message = "{direction.not.null}")
    @DirectionValidation()
    private String direction;
    @CommandValidation()
    @NotNull(message = "{not.null}")
    private String instructions;

    public ExplorerDTO() {
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
