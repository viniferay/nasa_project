package explorer;

import com.nasa.Application;
import com.nasa.explorer.Explorer;
import com.nasa.explorer.ExplorerService;
import com.nasa.explorer.dtos.ExplorerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest(classes = Application.class)
public class ExplorerServiceTest {

    @Autowired
    ExplorerService explorerService;
    @MockBean
    Explorer explorer;

    ExplorerDTO explorerDTO;

    @BeforeEach
    public void setUp(){
        explorerDTO = new ExplorerDTO();
        explorerDTO.setDirection("N");
        explorerDTO.setPositionX(0);
        explorerDTO.setPositionY(0);
        explorerDTO.setInstructions("MLR");

    }

}
