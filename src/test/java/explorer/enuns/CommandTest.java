package explorer.enuns;

import com.nasa.explorer.enuns.Command;
import com.nasa.explorer.exceptions.CommandInvalidException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CommandTest {

    @Test
    public void getCommandTest(){
        assertEquals(Command.LEFT, Command.getComand("L"));
        assertEquals(Command.RIGTH, Command.getComand("R"));
        assertEquals(Command.MOVE, Command.getComand("M"));
    }

    @Test
    public void getCommandExceptionCaseTest(){
        assertThrows(CommandInvalidException.class, () -> {Command.getComand("V");});
    }
}
