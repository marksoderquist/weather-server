package net.soderquist.mark.weather;

import lombok.Data;

@Data
public class WeatherStation {

	private static final String DEGREE = "\u00B0";

	private String id;

	private String name;

	private long timestamp;

	private float temperature;

	private float pressure;

	private float humidity;

	private float dewPoint;

	private float windChill;

	private float heatIndex;

	private float pressureTrend;

	private float windDirection;

	private float wind;

	private float windTenMinMax;

	private float windTenMinAvg;

	private float windTenMinMin;

	private float windTwoMinMax;

	private float windTwoMinAvg;

	private float windTwoMinMin;

	private float rainTotalDaily;

	private float rainRate;

	// Unit values.
	private final String temperatureUnit = DEGREE + "F";

	private final String humidityUnit = "%";

	private final String pressureUnit = "inHg";

	private final String pressureRateUnit = "inHg/hr";

	private final String windUnit = "MPH";

	private final String windDirectionUnit = DEGREE;

	private final String rainUnit = "in";

	private final String rainRateUnit = "in/hr";

	public WeatherStation() {}

	public WeatherStation( String id, String name ) {
		this.id = id;
		this.name = name;
	}

}
