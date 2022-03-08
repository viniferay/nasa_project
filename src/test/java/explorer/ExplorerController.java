package explorer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nasa.Application;
import com.nasa.explorer.Explorer;
import com.nasa.explorer.ExplorerService;
import com.nasa.explorer.dtos.ExplorerDTO;
import com.nasa.explorer.enuns.Compass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExplorerController.class)
@ComponentScan(basePackages = "com.nasa")
@ContextConfiguration(classes = Application.class)
public class ExplorerController {

    @MockBean
    ExplorerService explorerService;

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper;
    ExplorerDTO explorerDTO;
    Explorer explorer;

    @BeforeEach
    public void setUp(){
        objectMapper = new ObjectMapper();

        explorerDTO = new ExplorerDTO();
        explorerDTO.setInstructions("LMLMLMLMM");
        explorerDTO.setPositionX(1);
        explorerDTO.setPositionY(2);
        explorerDTO.setDirection("N");

        explorer = new Explorer();
        explorer.setPositionX(1);
        explorer.setPositionY(2);
        explorer.setDirection(Compass.NORTH);

    }

    public ResultActions callAPI(int expectedStatus, String json) throws Exception {
        ResultActions resultActions = mockMvc.perform(put("/explorer")
                .content(json).contentType(MediaType.APPLICATION_JSON)).andExpect(status()
                .is(expectedStatus));

        return resultActions;
    }

    @Test
    public void positiveCaseTest() throws Exception {
        String json = objectMapper.writeValueAsString(explorerDTO);
        when(explorerService.moveExplorer(any(ExplorerDTO.class))).thenReturn(explorer);

        ResultActions resultActions = callAPI(200, json);

        String responseJson = resultActions.andReturn().getResponse().getContentAsString();
        Explorer sucessExplorer = objectMapper.readValue(responseJson, Explorer.class);
    }

    @Test
    public void negativeCaseValidateDirectionTest() throws Exception{
        explorerDTO.setDirection("B");
        String json = objectMapper.writeValueAsString(explorerDTO);
        when(explorerService.moveExplorer(any(ExplorerDTO.class))).thenReturn(explorer);

        ResultActions resultActions = callAPI(422, json);
    }

    @Test
    public void negativeCaseValidateCommandTest() throws Exception{
        explorerDTO.setInstructions("XABLAU");
        String json = objectMapper.writeValueAsString(explorerDTO);
        when(explorerService.moveExplorer(any(ExplorerDTO.class))).thenReturn(explorer);

        ResultActions resultActions = callAPI(422, json);
        resultActions.andExpect(content().string("Commands invalido. São aceitos M (Mover), " +
                "L (Virar para esquerda), R (virar para direita)"));
    }
}
