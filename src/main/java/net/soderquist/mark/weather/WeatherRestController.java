package net.soderquist.mark.weather;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherRestController {

	private Map<String, WeatherStation> stations;

	WeatherStation station;

	public WeatherRestController() {
		stations = new HashMap<>();
		stations.put( "bluewing", new WeatherStation( "bluewing", "Bluewing Way" ) );
	}

	@RequestMapping( method = RequestMethod.GET, path = "/station" )
	public WeatherStation getStation( @RequestParam( value = "id", required = true ) String id) {
		return stations.get( id );
	}

	@RequestMapping( method = RequestMethod.PUT, path = "/station" )
	public void putStation( @RequestBody WeatherStation station ) {
		//return stations.get( id );
	}

}
