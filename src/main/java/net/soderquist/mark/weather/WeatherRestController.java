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
	public void putStation( @RequestParam( value = "id", required = true ) String id, @RequestBody WeatherStation station) {
		WeatherStation target = stations.get( id );
		if( target == null ) return;

		target.setTemperature( station.getTemperature() );
		target.setPressure( station.getPressure() );
		target.setHumidity( station.getHumidity() );
		
		target.setDewPoint( station.getDewPoint() );
		target.setWindChill( station.getWindChill() );
		target.setHeatIndex( station.getHeatIndex() );
		target.setPressureTrend( station.getPressureTrend() );
		
		target.setWindDirection( station.getWindDirection() );
		target.setWind( station.getWind() );
		target.setWindTenMinMax( station.getWindTenMinMax() );
		target.setWindTenMinAvg( station.getWindTenMinAvg() );
		target.setWindTenMinMin( station.getWindTenMinMin() );
		target.setWindTwoMinMax( station.getWindTwoMinMax() );
		target.setWindTwoMinAvg( station.getWindTwoMinAvg() );
		target.setWindTwoMinMin( station.getWindTwoMinMin() );
		
		target.setRainTotalDaily( station.getRainTotalDaily() );
		target.setRainRate( station.getRainRate() );
	}

}
