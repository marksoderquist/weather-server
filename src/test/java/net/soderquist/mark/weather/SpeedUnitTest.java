package net.soderquist.mark.weather;

import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SpeedUnitTest {

	public static Stream<Arguments> provideSpeedsToConvert() {
		return Stream.of(
			Arguments.of( UnitSystem.METRIC.getSpeedUnit(), UnitSystem.METRIC.getSpeedUnit(), 16.1, 16.1, 0.1 ),
			Arguments.of( UnitSystem.METRIC.getSpeedUnit(), UnitSystem.IMPERIAL.getSpeedUnit(), 16.1, 10.0, 0.1 ),
			Arguments.of( UnitSystem.IMPERIAL.getSpeedUnit(), UnitSystem.IMPERIAL.getSpeedUnit(), 10.0, 10.0, 0.1 ),
			Arguments.of( UnitSystem.IMPERIAL.getSpeedUnit(), UnitSystem.METRIC.getSpeedUnit(), 10.0, 16.1, 0.1 )
		);
	}

	@ParameterizedTest
	@MethodSource( "provideSpeedsToConvert" )
	public void testConvert( UnitSystem.SpeedUnit source, UnitSystem.SpeedUnit target, double value, double expected, double delta ) {
		assertThat( source.convert( value, target ) ).isEqualTo( expected, Offset.offset( delta ) );
	}

}
