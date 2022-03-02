package com.nasa.io;

import com.nasa.explorer.enuns.Command;
import com.nasa.io.exceptions.UnrecognizedCommandsException;

import java.util.*;
import java.util.stream.Collectors;

public class Input {

    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    public static Map<String, String> getCommandLine(){
      return Map.of("coordinates", scanner().nextLine(), "commands", scanner().nextLine().toUpperCase());
    }

    public static List<Character> validateComands(String inputComands){
        List<Character> validCommands = Arrays.stream(Command.values()).map(object -> object.getShortcut().charAt(0))
                .collect(Collectors.toList());

        List<Character> commands = inputComands.chars().mapToObj(object -> (char) object).collect(Collectors.toList());

        List<Character> validateList = commands.stream().filter(object -> !validCommands.contains(object))
                .collect(Collectors.toList());

        if(!validateList.isEmpty()){
            throw new UnrecognizedCommandsException(validateList);
        }
        return commands;
    }

    public static Map<String, String> treatCoordinates(String coordinates){
        String[] xY = coordinates.split(" ");
        return Map.of("x", xY[0], "y", xY[1], "direction", xY[2]);
    }
}
