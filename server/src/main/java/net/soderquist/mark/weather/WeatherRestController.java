package net.soderquist.mark.weather;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@SuppressWarnings( "unused" )
public class WeatherRestController {

	private Map<String, WeatherStation> stations;

	WeatherStation station;

	public WeatherRestController() {
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

		target.setTimestamp( station.getTimestamp() );

		target.setTemperature( station.getTemperature() );
		target.setPressure( station.getPressure() );
		target.setHumidity( station.getHumidity() );
		target.setDewPoint( station.getDewPoint() );
		target.setWindChill( station.getWindChill() );
		target.setHeatIndex( station.getHeatIndex() );
		target.setWind( station.getWind() );
		target.setWindDirection( station.getWindDirection() );
		target.setRainTotalDaily( station.getRainTotalDaily() );
		target.setRainRate( station.getRainRate() );

		target.setTemperatureOneMinTrend( station.getTemperatureOneMinTrend() );
		target.setHumidityOneHourTrend( station.getHumidityOneHourTrend() );
		target.setPressureOneHourTrend( station.getPressureOneHourTrend() );
		target.setWindOneMinTrend( station.getWindOneMinTrend() );

		target.setWindTenMinMax( station.getWindTenMinMax() );
		target.setWindTenMinAvg( station.getWindTenMinAvg() );
		target.setWindTenMinMin( station.getWindTenMinMin() );
		target.setWindTwoMinMax( station.getWindTwoMinMax() );
		target.setWindTwoMinAvg( station.getWindTwoMinAvg() );
		target.setWindTwoMinMin( station.getWindTwoMinMin() );
		target.setWindDirectionTenMinAvg( station.getWindDirectionTenMinAvg() );
		target.setWindDirectionTwoMinAvg( station.getWindDirectionTwoMinAvg() );
	}

}
