package com.nasa.explorer;

import com.nasa.explorer.dtos.ExplorerDTO;
import org.springframework.stereotype.Service;

@Service
public class ExplorerService {

       public Explorer moveExplorer(ExplorerDTO explorerDTO){
           Explorer explorer = new Explorer(explorerDTO.getDirection(), explorerDTO.getPositionY(),
                   explorerDTO.getPositionX());

           for (String command : explorerDTO.getInstructions().split("")){
               explorer.playCommand(command);
           }
            return explorer;
       }
}
