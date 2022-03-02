import com.nasa.explorer.enuns.Command;
import com.nasa.explorer.exceptions.CommandInvalidException;
import org.junit.Assert;
import org.junit.Test;

public class CommandTest {

    @Test
    public void getCommandTest(){
        Assert.assertEquals(Command.LEFT, Command.getComand("L"));
        Assert.assertEquals(Command.RIGTH, Command.getComand("R"));
        Assert.assertEquals(Command.MOVE, Command.getComand("M"));
    }

    @Test
    public void getCommandExceptionCaseTest(){
        Assert.assertThrows(CommandInvalidException.class, () -> {Command.getComand("V");});
    }
}
