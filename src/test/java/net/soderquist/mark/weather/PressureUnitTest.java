package net.soderquist.mark.weather;

import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PressureUnitTest {

	public static Stream<Arguments> providePressuresToConvert() {
		return Stream.of(
			Arguments.of( UnitSystem.METRIC.getPressureUnit(), UnitSystem.METRIC.getPressureUnit(), 1014.2234, 1014.2234, 0.1 ),
			Arguments.of( UnitSystem.METRIC.getPressureUnit(), UnitSystem.IMPERIAL.getPressureUnit(), 1014.2234, 29.95, 0.01 ),
			Arguments.of( UnitSystem.IMPERIAL.getPressureUnit(), UnitSystem.IMPERIAL.getPressureUnit(), 29.95, 29.95, 0.01 ),
			Arguments.of( UnitSystem.IMPERIAL.getPressureUnit(), UnitSystem.METRIC.getPressureUnit(), 29.95, 1014.2234, 0.1 )
		);
	}

	@ParameterizedTest
	@MethodSource( "providePressuresToConvert" )
	public void testConvert( UnitSystem.PressureUnit source, UnitSystem.PressureUnit target, double value, double expected, double delta ) {
		assertThat( source.convert( value, target ) ).isEqualTo( expected, Offset.offset( delta ) );
	}

}
