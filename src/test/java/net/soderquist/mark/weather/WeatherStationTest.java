package net.soderquist.mark.weather;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherStationTest {

	@Test
	void testCalcHeatIndex() {
		assertThat( WeatherStation.calculateHeatIndex( 80, 40 ) ).isCloseTo( 80, Offset.offset( 1.0 ) );
		assertThat( WeatherStation.calculateHeatIndex( 80, 80 ) ).isEqualTo( 84, Offset.offset( 1.0 ) );
	}

}
