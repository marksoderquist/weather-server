package net.soderquist.mark.weather;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TemperatureUnitTest {

	public static Stream<Arguments> provideTemperaturesToConvert() {
		return Stream.of(
			Arguments.of( UnitSystem.METRIC.getTemperatureUnit(), UnitSystem.METRIC.getTemperatureUnit(), 0.0, 0.0 ),
			Arguments.of( UnitSystem.METRIC.getTemperatureUnit(), UnitSystem.IMPERIAL.getTemperatureUnit(), 0.0, 32.0 ),
			Arguments.of( UnitSystem.IMPERIAL.getTemperatureUnit(), UnitSystem.IMPERIAL.getTemperatureUnit(), 32.0, 32.0 ),
			Arguments.of( UnitSystem.IMPERIAL.getTemperatureUnit(), UnitSystem.METRIC.getTemperatureUnit(), 32.0, 0.0 )
		);
	}

	@ParameterizedTest
	@MethodSource( "provideTemperaturesToConvert" )
	public void testConvert( UnitSystem.TemperatureUnit source, UnitSystem.TemperatureUnit target, double value, double expected) {
		assertThat( source.convert( value, target ) ).isEqualTo( expected );
	}

	public static Stream<Arguments> provideTemperaturesToConvertRate() {
		return Stream.of(
			Arguments.of( UnitSystem.METRIC.getTemperatureUnit(), UnitSystem.METRIC.getTemperatureUnit(), 1.0, 1.0 ),
			Arguments.of( UnitSystem.METRIC.getTemperatureUnit(), UnitSystem.IMPERIAL.getTemperatureUnit(), 1.0, 1.8 ),
			Arguments.of( UnitSystem.IMPERIAL.getTemperatureUnit(), UnitSystem.IMPERIAL.getTemperatureUnit(), 1.8, 1.8 ),
			Arguments.of( UnitSystem.IMPERIAL.getTemperatureUnit(), UnitSystem.METRIC.getTemperatureUnit(), 1.8, 1 )
		);
	}

	@ParameterizedTest
	@MethodSource( "provideTemperaturesToConvertRate" )
	public void testConvertRate( UnitSystem.TemperatureUnit source, UnitSystem.TemperatureUnit target, double value, double expected) {
		assertThat( source.convertRate( value, target ) ).isEqualTo( expected );
	}

}
