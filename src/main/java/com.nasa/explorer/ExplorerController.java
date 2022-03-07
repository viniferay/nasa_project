package com.nasa.explorer;

import com.nasa.explorer.dtos.ExplorerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/explorer")
public class ExplorerController {

    @Autowired
    private ExplorerService explorerService;

    @PutMapping
    public Explorer moveExplorer(@RequestBody @Valid ExplorerDTO explorerDTO){
        return explorerService.moveExplorer(explorerDTO);
    }

}
