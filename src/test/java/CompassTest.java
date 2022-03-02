import com.nasa.explorer.enuns.Command;
import com.nasa.explorer.enuns.Compass;
import org.junit.Assert;
import org.junit.Test;

public class CompassTest {

    @Test
    public void getNewDirectionBasedCommand(){
        Assert.assertEquals(Compass.WEST, Compass.NORTH.getDirection(Command.LEFT));
        Assert.assertEquals(Compass.SOUTH, Compass.WEST.getDirection(Command.LEFT));
        Assert.assertEquals(Compass.EAST, Compass.SOUTH.getDirection(Command.LEFT));
        Assert.assertEquals(Compass.NORTH, Compass.EAST.getDirection(Command.LEFT));
        Assert.assertEquals(Compass.EAST, Compass.NORTH.getDirection(Command.RIGTH));
        Assert.assertEquals(Compass.SOUTH, Compass.EAST.getDirection(Command.RIGTH));
        Assert.assertEquals(Compass.WEST, Compass.SOUTH.getDirection(Command.RIGTH));
        Assert.assertEquals(Compass.NORTH, Compass.WEST.getDirection(Command.RIGTH));
    }

}
