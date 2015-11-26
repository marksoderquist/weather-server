package net.soderquist.mark.weather;

import lombok.Data;
import lombok.NonNull;

public @Data class WeatherStation {

	@NonNull
	private String id;

	@NonNull
	private String name;

	private float temperature;
	
	private float humidity;

	private String temperatureUnit;

	private String humidityUnit;

	private String pressureUnit;

	private String windUnit;
	
}
