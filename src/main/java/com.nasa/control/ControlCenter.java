package com.nasa.control;

import com.nasa.explorer.Explorer;
import com.nasa.io.Input;
import com.nasa.io.Output;

import java.util.List;
import java.util.Map;

public class ControlCenter {

    public static void run(){
        try{
            Map<String, String> commandLine = getInitialInformations();
            Explorer explorer = startSistem(commandLine.get("coordinates"));
            List<Character> commands = Input.validateComands(commandLine.get("commands"));
            for (Character command: commands){
                explorer.playCommand(command.toString());
            }
            Output.print(explorer.toString());
        }catch (RuntimeException e){
            Output.print(e.getMessage());
        }finally {
            run();
        }
    }

    public static Explorer startSistem(String coordinates){
        Map<String, String> explorerData = Input.treatCoordinates(coordinates);
        Explorer explorer = new Explorer(explorerData.get("direction"), explorerData.get("y"), explorerData.get("x"));
        return explorer;
    }

    public static Map<String, String> getInitialInformations(){
        Output.print("_________________________________________________");
        Output.print("Seja bem vindo, digite as cordenadas iniciais da sonda \n Exemplo: \n 3 2 N \n MLRLRM");
        Output.print("___________________");
        Map<String, String> commandLine = Input.getCommandLine();
        return commandLine;
    }
}
