package com.nasa.explorer.annotations;

import com.nasa.explorer.enuns.Command;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandValidator implements ConstraintValidator<CommandValidation, String> {

    @Override
    public boolean isValid(String commandsInput, ConstraintValidatorContext constraintValidatorContext) {
        List<Character> validCommands = Arrays.stream(Command.values()).map(object -> object.getShortcut().charAt(0))
                .collect(Collectors.toList());

        List<Character> commands = commandsInput.chars().mapToObj(object -> (char) object).collect(Collectors.toList());

        List<Character> validateList = commands.stream().filter(object -> !validCommands.contains(object))
                .collect(Collectors.toList());

        if(!validateList.isEmpty()){
            return false;
        }
        return true;
    }
}
