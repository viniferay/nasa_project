import com.nasa.explorer.Explorer;
import com.nasa.explorer.enuns.Compass;
import org.junit.Assert;
import org.junit.Test;

public class ExplorerTest {

    @Test
    public void explorerMovieTest(){
        Explorer explorer = new Explorer();
        explorer.setPositionX(0);
        explorer.setPositionY(0);
        explorer.setDirection(Compass.NORTH);

        explorer.move();

        Assert.assertEquals(2, explorer.getPositionY());
        Assert.assertEquals(0, explorer.getPositionX());

        explorer.setDirection(Compass.EAST);
        explorer.move();

        Assert.assertEquals(2, explorer.getPositionY());
        Assert.assertEquals(1, explorer.getPositionX());
    }
}
