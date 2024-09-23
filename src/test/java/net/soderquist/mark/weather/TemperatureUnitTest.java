package net.soderquist.mark.weather;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TemperatureUnitTest {

	public static Stream<Arguments> provideTemperatureUnitConversion() {
		return Stream.of(
			Arguments.of( UnitSystem.METRIC.getTemperatureUnit(), UnitSystem.IMPERIAL.getTemperatureUnit(), 0.0, 32.0 ),
			Arguments.of( UnitSystem.IMPERIAL.getTemperatureUnit(), UnitSystem.METRIC.getTemperatureUnit(), 32.0, 0.0 )
		);
	}

	@ParameterizedTest
	@MethodSource("provideTemperatureUnitConversion")
	public void testTemperature( UnitSystem.TemperatureUnit source, UnitSystem.TemperatureUnit target, double value, double expected) {
		assertThat( source.convert( value, target ) ).isEqualTo( expected );
	}

}
