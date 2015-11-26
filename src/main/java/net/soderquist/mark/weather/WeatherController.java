package net.soderquist.mark.weather;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.*;

@RestController
public class WeatherController {

    @RequestMapping("/")
    public String index() {
        return "{ \"name\": \"Bluewing\" }";
    }
	
}
