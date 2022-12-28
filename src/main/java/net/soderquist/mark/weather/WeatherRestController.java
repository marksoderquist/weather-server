package net.soderquist.mark.weather;

import jakarta.annotation.security.PermitAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

@RestController
@SuppressWarnings( "unused" )
public class WeatherRestController {

	private final Logger log = LoggerFactory.getLogger( MethodHandles.lookup().lookupClass() );

	private final PerformPublisher publisher;

	@Value( "${spring.application.version:unknown}" )
	private String version;

	private Map<String, WeatherStation> stations;

	public WeatherRestController(PerformPublisher performPublisher) {
		this.publisher = performPublisher;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion( String version ) {
		this.version = version;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping( method = RequestMethod.GET, path = "/station" )
	public @ResponseBody
	WeatherStation getStation( @RequestParam( value = "id" ) String id ) {
		return getStations().get( id );
	}

	@RequestMapping( method = RequestMethod.PUT, path = "/station" )
	public void putStation( @RequestParam( value = "id" ) String id, @RequestBody WeatherStation station ) {
		WeatherStation target = getStations().get( id );
		if( target == null ) return;
		target.copyFrom( station );
		target.setServerVersion( version );
		try {
			publisher.publish( target );
		} catch( IOException exception ) {
			log.error( "Error publishing to Perform", exception );
		}
	}

	private Map<String, WeatherStation> getStations() {
		if( stations == null ) {
			stations = new HashMap<>();
			stations.put( "bluewing", new WeatherStation( "bluewing", "Bluewing", 40.503923, -112.013373 ) );
		}
		return stations;
	}

}
