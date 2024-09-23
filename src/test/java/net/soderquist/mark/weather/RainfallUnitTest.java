package net.soderquist.mark.weather;

import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RainfallUnitTest {

	public static Stream<Arguments> provideSpeedsToConvert() {
		return Stream.of(
			Arguments.of( UnitSystem.METRIC.getRainfallUnit(), UnitSystem.METRIC.getRainfallUnit(), 17.8, 17.8, 0.1 ),
			Arguments.of( UnitSystem.METRIC.getRainfallUnit(), UnitSystem.IMPERIAL.getRainfallUnit(), 17.8, 0.7, 0.1 ),
			Arguments.of( UnitSystem.IMPERIAL.getRainfallUnit(), UnitSystem.IMPERIAL.getRainfallUnit(), 0.7, 0.7, 0.1 ),
			Arguments.of( UnitSystem.IMPERIAL.getRainfallUnit(), UnitSystem.METRIC.getRainfallUnit(), 0.7, 17.8, 0.1 )
		);
	}

	@ParameterizedTest
	@MethodSource( "provideSpeedsToConvert" )
	public void testConvert( UnitSystem.RainfallUnit source, UnitSystem.RainfallUnit target, double value, double expected, double delta ) {
		assertThat( source.convert( value, target ) ).isEqualTo( expected, Offset.offset( delta ) );
	}

}
