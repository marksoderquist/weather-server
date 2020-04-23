package net.soderquist.mark.weather;

import java.io.IOException;

public interface WeatherPublisher {

	int publish( WeatherStation station ) throws IOException;

}
