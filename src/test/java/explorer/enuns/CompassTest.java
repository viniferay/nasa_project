package explorer.enuns;

import com.nasa.explorer.enuns.Command;
import com.nasa.explorer.enuns.Compass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CompassTest {

    @Test
    public void getNewDirectionBasedCommand(){
        assertEquals(Compass.WEST, Compass.NORTH.getDirection(Command.LEFT));
        assertEquals(Compass.SOUTH, Compass.WEST.getDirection(Command.LEFT));
        assertEquals(Compass.EAST, Compass.SOUTH.getDirection(Command.LEFT));
        assertEquals(Compass.NORTH, Compass.EAST.getDirection(Command.LEFT));
        assertEquals(Compass.EAST, Compass.NORTH.getDirection(Command.RIGTH));
        assertEquals(Compass.SOUTH, Compass.EAST.getDirection(Command.RIGTH));
        assertEquals(Compass.WEST, Compass.SOUTH.getDirection(Command.RIGTH));
        assertEquals(Compass.NORTH, Compass.WEST.getDirection(Command.RIGTH));
    }

}