package com.nasa.io.exceptions;

import java.util.List;

public class UnrecognizedCommandsException extends RuntimeException{

    public UnrecognizedCommandsException(List<Character> commandsUnrecognized) {
        super(makeMensage(commandsUnrecognized));

    }

    private static String makeMensage(List<Character> commandsUnrecognized){
        StringBuilder mensage = new StringBuilder();
        mensage.append("Os comandos ");
        for(char commands: commandsUnrecognized){
            mensage.append(commands);
            mensage.append(",");
        }
        mensage.append(" não são reconhecidos");

        return mensage.toString();
    }
}
