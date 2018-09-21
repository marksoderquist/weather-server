package net.soderquist.mark.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

@RestController
@SuppressWarnings( "unused" )
public class WeatherRestController {

	private Logger log = LoggerFactory.getLogger( MethodHandles.lookup().lookupClass() );

	@Value( "${spring.application.name}" )
	private String name;

	@Value( "${spring.application.version}" )
	private String version;

	private Map<String, WeatherStation> stations;

	WeatherStation station;

	public WeatherRestController() {
		log.info( name + " " + version );
		stations = new HashMap<>();
		stations.put( "bluewing", new WeatherStation( "bluewing", "Bluewing Way" ) );
	}

	@CrossOrigin
	@RequestMapping( method = RequestMethod.GET, path = "/station" )
	public @ResponseBody WeatherStation getStation( @RequestParam( value = "id" ) String id) {
		return stations.get( id );
	}

	@RequestMapping( method = RequestMethod.PUT, path = "/station" )
	public void putStation( @RequestParam( value = "id" ) String id, @RequestBody WeatherStation station) {
		WeatherStation target = stations.get( id );
		if( target == null ) return;
		target.copyFrom( station );
	}

}
