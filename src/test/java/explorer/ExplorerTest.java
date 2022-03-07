package explorer;

import com.nasa.explorer.Explorer;
import com.nasa.explorer.enuns.Command;
import com.nasa.explorer.enuns.Compass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class ExplorerTest {

    @Test
    public void explorerMovieTest(){
        Explorer explorer = new Explorer();
        explorer.setPositionX(0);
        explorer.setPositionY(0);
        explorer.setDirection(Compass.NORTH);

        explorer.move();

        assertEquals(2, explorer.getPositionY());
        assertEquals(0, explorer.getPositionX());

        explorer.setDirection(Compass.EAST);
        explorer.move();

        assertEquals(2, explorer.getPositionY());
        assertEquals(1, explorer.getPositionX());
    }

    @Test
    public void turnAroundTest(){
        Explorer explorer = new Explorer();
        explorer.setPositionX(0);
        explorer.setPositionY(0);
        explorer.setDirection(Compass.NORTH);

        explorer.turnAround(Command.LEFT);

        assertEquals(Compass.WEST, explorer.getDirection());    }
}
