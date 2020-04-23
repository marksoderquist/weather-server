package net.soderquist.mark.weather;

import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.junit.Assert.assertNotNull;

public class WeatherApplicationTests {

	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner().withConfiguration( AutoConfigurations.of( WeatherApplication.class ) );

	@Test
	public void contextLoads() {
		assertNotNull( contextRunner );
	}

}
