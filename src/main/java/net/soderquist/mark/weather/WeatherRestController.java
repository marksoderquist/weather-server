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
		// TODO We should update three versions of the station:
		// 1. The station as passed in the request for backward compatibility
		// 2. The station with metric units
		// 3. The station with imperial units

		WeatherStation target = getStations().get( id );
		if( target == null ) return null;
		target.setServerVersion( version );
		target.copyFrom( station );

		WeatherStation targetMetric = getStations().get( id + "-metric" );
		if( targetMetric == null ) return null;
		targetMetric.setServerVersion( version );
		targetMetric.copyFrom( station );

		WeatherStation targetImperial = getStations().get( id + "-imperial" );
		if( targetImperial == null ) return null;
		targetImperial.setServerVersion( version );
		targetImperial.copyFrom( station );

		try {
			publisher.publish( target );
			//publisher.publish( targetMetric );
			//publisher.publish( targetImperial );
		} catch( IOException exception ) {
			log.error( "Error publishing to Perform", exception );
		}

		return target;
	}

	private Map<String, WeatherStation> getStations() {
		if( stations == null ) {
			stations = new HashMap<>();
			stations.put( "bluewing", new WeatherStation( "bluewing", "Bluewing", 40.503923, -112.013373, UnitSystem.IMPERIAL ) );
			stations.put( "bluewing-metric", new WeatherStation( "bluewing", "Bluewing", 40.503923, -112.013373, UnitSystem.METRIC ) );
			stations.put( "bluewing-imperial", new WeatherStation( "bluewing", "Bluewing", 40.503923, -112.013373, UnitSystem.IMPERIAL ) );
		}
		return stations;
	}

}
