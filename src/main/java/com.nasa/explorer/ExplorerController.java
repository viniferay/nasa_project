package com.nasa.explorer;

import com.nasa.explorer.dtos.ExplorerDTO;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/explorer")
public class ExplorerController {

    @Autowired
    private ExplorerService explorerService;

    @PutMapping
    @ApiResponses(@ApiResponse(code = 422, message = "Informações que não podem ser processadas por falta de compatibilidade"))
    public Explorer moveExplorer(@RequestBody @Valid ExplorerDTO explorerDTO){
        return explorerService.moveExplorer(explorerDTO);
    }

}
