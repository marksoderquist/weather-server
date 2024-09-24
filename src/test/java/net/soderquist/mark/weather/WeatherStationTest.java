package net.soderquist.mark.weather;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherStationTest {

	private WeatherStation metricStation;

	private WeatherStation imperialStation;

	@BeforeEach
	void setup() {
		metricStation = metricWeatherStation();
		imperialStation = imperialWeatherStation();
	}

	@Test
	void testCopyFrom() {
		// given
		WeatherStation source = imperialStation;

		// when
		WeatherStation target = new WeatherStation( "bluewing-m", "Bluewing", 40.503923, -112.013373, UnitSystem.METRIC );
		target.copyFrom( source );

		// then
		assertThat( target.getTemperature() ).isEqualTo( 26.7, Offset.offset( 0.1 ) );
		assertThat( target.getPressure() ).isEqualTo( 1017.61, Offset.offset( 0.1 ) );
		assertThat( target.getHumidity() ).isEqualTo( 50 );
		assertThat( target.getDewPoint() ).isEqualTo( 15.6, Offset.offset( 0.1 ) );
		assertThat( target.getWindChill() ).isEqualTo( 26.7, Offset.offset( 0.1 ) );
		assertThat( target.getHeatIndex() ).isEqualTo( 27.1, Offset.offset( 0.1 ) );
		assertThat( target.getFeelsLike() ).isEqualTo( 26.7, Offset.offset( 0.1 ) );
		assertThat( target.getWindSpeed() ).isEqualTo( 16.1, Offset.offset( 0.1 ) );
		assertThat( target.getWindDirection() ).isEqualTo( 180 );
		assertThat( target.getRainTotalDaily() ).isEqualTo( 7.6, Offset.offset( 0.1 ) );
		assertThat( target.getRainRate() ).isEqualTo( 17.8, Offset.offset( 0.1 ) );

		// trends
		assertThat( target.getTemperatureTrend() ).isEqualTo( -0.2, Offset.offset( 0.1 ) );
		assertThat( target.getPressureTrend() ).isEqualTo( 3.39, Offset.offset( 0.01 ) );
		assertThat( target.getHumidityTrend() ).isEqualTo( 0.2, Offset.offset( 0.0 ) );
		//assertThat( target.getDewPointTrend() ).isEqualTo( 0.3, Offset.offset( 0.1 ) );
		assertThat( target.getWindSpeedTrend() ).isEqualTo( 0.6, Offset.offset( 0.1 ) );

		// wind

		// units
		assertThat( target.getTemperatureUnit() ).isEqualTo( "°C" );
		assertThat( target.getPressureUnit() ).isEqualTo( "hPa" );
		assertThat( target.getHumidityUnit() ).isEqualTo( "%" );
		assertThat( target.getWindSpeedUnit() ).isEqualTo( "kph" );
		assertThat( target.getWindDirectionUnit() ).isEqualTo( "°" );
		assertThat( target.getRainUnit() ).isEqualTo( "mm" );
	}

	@Test
	void testUpdateFlyingConditionsMetric() {
		// given
		WeatherStation source = metricStation;

		// when
		source.updateFlyingConditions();

		// then
		assertThat( source.getFlightCondition().getSummary() ).isEqualTo( FlightCondition.Summary.POOR );
	}

	@ParameterizedTest
	@MethodSource( "heatIndexValues" )
	void testCalcHeatIndex( double temperature, double humidity, double heatIndex ) {
		assertThat( WeatherStation.calculateHeatIndex( temperature, humidity ) ).isCloseTo( heatIndex, Offset.offset( 0.5 ) );
	}

	// These values come from the NOAA table of values at: https://en.wikipedia.org/wiki/Heat_index
	private static Stream<Arguments> heatIndexValues() {
		return Stream.of(
			Arguments.of( 80, 40, 80 ),
			Arguments.of( 80, 50, 81 ),
			Arguments.of( 80, 60, 82 ),
			Arguments.of( 80, 70, 83 ),
			Arguments.of( 80, 80, 84 ),
			Arguments.of( 80, 90, 86 ),
			Arguments.of( 80, 100, 87 ),
			Arguments.of( 90, 40, 91 ),
			Arguments.of( 90, 50, 95 ),
			Arguments.of( 90, 60, 100 ),
			Arguments.of( 90, 70, 106 ),
			Arguments.of( 90, 80, 113 ),
			Arguments.of( 90, 90, 122 ),
			Arguments.of( 90, 100, 132 ),
			Arguments.of( 100, 40, 109 ),
			Arguments.of( 100, 50, 118 ),
			Arguments.of( 100, 60, 129 ),
			Arguments.of( 110, 40, 136 )
		);
	}

	private WeatherStation metricWeatherStation() {
		WeatherStation station = new WeatherStation( "bluewing-m", "Bluewing", 40.503923, -112.013373, UnitSystem.METRIC );
		station.setTemperature( 20 );
		station.setPressure( 1014 );
		station.setHumidity( 50 );
		station.setDewPoint( 10 );
		station.setWindChill( WeatherStation.calculateWindChill( 80, 10 ) );
		station.setHeatIndex( WeatherStation.calculateHeatIndex( 80, 50 ) );
		station.setFeelsLike( WeatherStation.calcFeelsLikeFahrenheit( 80, 50, 10 ) );
		station.setWindSpeed( 10 );
		station.setWindDirection( 180 );
		station.setRainTotalDaily( 0.3 );
		station.setRainRate( 0.7 );

		station.setTemperatureTrend( -0.4 );
		station.setPressureTrend( 0.1 );
		station.setHumidityTrend( 0.2 );
		//source.setDewPointTrend( 0.3 );
		station.setWindSpeedTrend( 0.4 );

		return station;
	}

	private WeatherStation imperialWeatherStation() {
		WeatherStation station = new WeatherStation( "bluewing-i", "Bluewing", 40.503923, -112.013373, UnitSystem.IMPERIAL );
		station.setTemperature( 80 );
		station.setPressure( 30.05 );
		station.setHumidity( 50 );
		station.setDewPoint( 60 );
		station.setWindChill( WeatherStation.calculateWindChill( 80, 10 ) );
		station.setHeatIndex( WeatherStation.calculateHeatIndex( 80, 50 ) );
		station.setFeelsLike( WeatherStation.calcFeelsLikeFahrenheit( 80, 50, 10 ) );
		station.setWindSpeed( 10 );
		station.setWindDirection( 180 );
		station.setRainTotalDaily( 0.3 );
		station.setRainRate( 0.7 );

		station.setTemperatureTrend( -0.4 );
		station.setPressureTrend( 0.1 );
		station.setHumidityTrend( 0.2 );
		//source.setDewPointTrend( 0.3 );
		station.setWindSpeedTrend( 0.4 );

		return station;
	}
}
