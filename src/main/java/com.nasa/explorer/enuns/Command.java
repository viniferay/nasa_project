package com.nasa.explorer.enuns;

import com.nasa.explorer.exceptions.CommandInvalidException;

import java.util.Arrays;
import java.util.Optional;

public enum Command {
    LEFT(-1, "L"),
    RIGTH(1, "R"),
    MOVE(0, "M");

    private int value;
    private String shortcut;

    Command(int value, String shortcut){
        this.value = value;
        this.shortcut = shortcut;
    }

    public int getValue() {
        return value;
    }

    public String getShortcut() {
        return shortcut;
    }

    public static Command getComand(String shortcut){
        Optional<Command> command = Arrays.stream(Command.values())
                .filter(object -> object.shortcut.equals(shortcut.toUpperCase())).findFirst();
        command.orElseThrow(() -> new CommandInvalidException());

        return command.get();
    }

}
