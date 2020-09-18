package springBootServerless.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springBootServerless.dto.InfoDto;
import springBootServerless.services.InfoService;

@RestController
public class InfoController {

    @Autowired
    InfoService infoService;

    /**
     * Method to return the basic info about the service. This also serves the purpose of health check API.
     * @return Info object with service information
     */
    @GetMapping("/info")
    public InfoDto getInfo() {
        return infoService.getInfo();
    }

}
