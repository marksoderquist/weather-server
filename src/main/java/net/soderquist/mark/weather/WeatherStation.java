package net.soderquist.mark.weather;

import lombok.Data;
import lombok.NonNull;

public @Data class WeatherStation {

	public static final String DEGREE = "\u00B0";

	@NonNull
	private String id;

	@NonNull
	private String name;

	private float temperature;
	
	private float pressure;

	private float humidity;

	private final String temperatureUnit = DEGREE + "F";

	private final String humidityUnit = "%";

	private final String pressureUnit = "inHg";

	private final String pressureTrendUnit = "inHg/hr";

	private final String windUnit = "MPH";

	private final String windDirectionUnit = DEGREE;

}
