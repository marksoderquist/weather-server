package net.soderquist.mark.weather;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherStationTest {

	@Test
	void testCopyFrom() {
		// given
		WeatherStation source = new WeatherStation( "bluewing-i", "Bluewing", 40.503923, -112.013373, UnitSystem.IMPERIAL );
		source.setTemperature( 80 );
		source.setPressure( 30.05 );
		source.setHumidity( 50 );
		source.setDewPoint( 60 );
		source.setWindChill( WeatherStation.calculateWindChill( 80, 10 ) );
		source.setHeatIndex( WeatherStation.calculateHeatIndex( 80, 50 ) );
		source.setFeelsLike( WeatherStation.calcFeelsLikeFahrenheit( 80, 50, 10 ) );
		source.setWindSpeed( 10 );
		source.setWindDirection( 180 );
		source.setRainTotalDaily( 0.3 );
		source.setRainRate( 0.7 );

		source.setTemperatureTrend( -0.4 );
		source.setPressureTrend( 0.1 );
		source.setHumidityTrend( 0.2 );
		//source.setDewPointTrend( 0.3 );
		source.setWindSpeedTrend( 0.4 );

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

}
