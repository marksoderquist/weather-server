package net.soderquist.mark.weather;

import lombok.Getter;
import lombok.Setter;
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

	@Setter
	@Getter
	@Value( "${spring.application.version:unknown}" )
	private String version;

	private Map<String, WeatherStation> stations;

	public WeatherRestController(PerformPublisher performPublisher) {
		this.publisher = performPublisher;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping( method = RequestMethod.GET, path = "/station" )
	public @ResponseBody
	WeatherStation getStation( @RequestParam( value = "id" ) String id ) {
		return getStations().get( id );
	}

	@RequestMapping( method = RequestMethod.PUT, path = "/station" )
	public WeatherStation putStation( @RequestParam( value = "id" ) String id, @RequestBody WeatherStation station ) {
		WeatherStation target = getStations().get( id );
		if( target == null ) return null;
		target.setServerVersion( version );
		target.copyFrom( station );

		try {
			publisher.publish( target );
		} catch( IOException exception ) {
			log.error( "Error publishing to Perform", exception );
		}

		return target;
	}

	// NEXT How to support metric and imperial units for weather stations?
	// Options:
	// 1. Add a field to the WeatherStation class to indicate the unit type
	// 2. Add a separate station for each unit type to the station map

	private Map<String, WeatherStation> getStations() {
		if( stations == null ) {
			stations = new HashMap<>();
			stations.put( "bluewing", new WeatherStation( "bluewing", "Bluewing", 40.503923, -112.013373, UnitSystem.IMPERIAL ) );
		}
		return stations;
	}

}
