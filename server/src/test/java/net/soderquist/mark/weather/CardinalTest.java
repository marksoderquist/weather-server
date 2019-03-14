package net.soderquist.mark.weather;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CardinalTest {

	@Test
	public void testToCardinalPrimary() {
		assertThat( Cardinal.toCardinal( 0 ), is( Cardinal.N ) );
		assertThat( Cardinal.toCardinal( 90 ), is( Cardinal.E ) );
		assertThat( Cardinal.toCardinal( 180 ), is( Cardinal.S ) );
		assertThat( Cardinal.toCardinal( 270 ), is( Cardinal.W ) );
	}

	@Test
	public void testToCardinalSecondary() {
		assertThat( Cardinal.toCardinal( 45 ), is( Cardinal.NE ) );
		assertThat( Cardinal.toCardinal( 135 ), is( Cardinal.SE ) );
		assertThat( Cardinal.toCardinal( 225 ), is( Cardinal.SW ) );
		assertThat( Cardinal.toCardinal( 315 ), is( Cardinal.NW ) );
	}

	@Test
	public void testToCardinalTerciary() {
		double origin = 45.0 / 2;
		assertThat( Cardinal.toCardinal( origin ), is( Cardinal.NNE ) );
		assertThat( Cardinal.toCardinal( origin + 45 ), is( Cardinal.ENE ) );
		assertThat( Cardinal.toCardinal( origin + 2*45 ), is( Cardinal.ESE ) );
		assertThat( Cardinal.toCardinal( origin + 3*45 ), is( Cardinal.SSE ) );

		assertThat( Cardinal.toCardinal( origin + 4*45 ), is( Cardinal.SSW ) );
		assertThat( Cardinal.toCardinal( origin + 5*45 ), is( Cardinal.WSW ) );
		assertThat( Cardinal.toCardinal( origin + 6*45 ), is( Cardinal.WNW ) );
		assertThat( Cardinal.toCardinal( origin + 7*45 ), is( Cardinal.NNW ) );
	}

}
