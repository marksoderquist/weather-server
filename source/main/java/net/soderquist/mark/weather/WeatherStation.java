package net.soderquist.mark.weather;

public class WeatherStation {

	public static final String DEGREE = "\u00B0";
	
	private String timestamp;

	private String temperature;

	private String temperatureUnit;

	private String humidity;

	private String humidityUnit;

	private String pressure;

	private String pressureUnit;
	
	private String pressureTrend;
	
	private String pressureTrendUnit;
	
	private String windDirection;
	
	private String windDirectionUnit;
	
	private String windInstant;
	
	private String windSustain;
	
	private String windUnit;
	
	private String rainRate;
	
	private String rainRateUnit;
	
	private String rainTotalDaily;
	
	private String rainTotalDailyUnit;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp( String timestamp ) {
		this.timestamp = timestamp;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature( String temperature ) {
		this.temperature = temperature;
	}

	public String getTemperatureUnit() {
		return temperatureUnit;
	}

	public void setTemperatureUnit( String temperatureUnit ) {
		this.temperatureUnit = temperatureUnit;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity( String humidity ) {
		this.humidity = humidity;
	}

	public String getHumidityUnit() {
		return humidityUnit;
	}

	public void setHumidityUnit( String humidityUnit ) {
		this.humidityUnit = humidityUnit;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure( String pressure ) {
		this.pressure = pressure;
	}

	public String getPressureUnit() {
		return pressureUnit;
	}

	public void setPressureUnit( String pressureUnit ) {
		this.pressureUnit = pressureUnit;
	}

	public String getPressureTrend() {
		return pressureTrend;
	}

	public void setPressureTrend( String pressureTrend ) {
		this.pressureTrend = pressureTrend;
	}

	public String getPressureTrendUnit() {
		return pressureTrendUnit;
	}

	public void setPressureTrendUnit( String pressureTrendUnit ) {
		this.pressureTrendUnit = pressureTrendUnit;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection( String windDirection ) {
		this.windDirection = windDirection;
	}

	public String getWindDirectionUnit() {
		return windDirectionUnit;
	}

	public void setWindDirectionUnit( String windDirectionUnit ) {
		this.windDirectionUnit = windDirectionUnit;
	}

	public String getWindInstant() {
		return windInstant;
	}

	public void setWindInstant( String windInstant ) {
		this.windInstant = windInstant;
	}

	public String getWindSustain() {
		return windSustain;
	}

	public void setWindSustain( String windSustain ) {
		this.windSustain = windSustain;
	}

	public String getWindUnit() {
		return windUnit;
	}

	public void setWindUnit( String windUnit ) {
		this.windUnit = windUnit;
	}

	public String getRainRate() {
		return rainRate;
	}

	public void setRainRate( String rainRate ) {
		this.rainRate = rainRate;
	}

	public String getRainRateUnit() {
		return rainRateUnit;
	}

	public void setRainRateUnit( String rainRateUnit ) {
		this.rainRateUnit = rainRateUnit;
	}

	public String getRainTotalDaily() {
		return rainTotalDaily;
	}

	public void setRainTotalDaily( String rainTotalDaily ) {
		this.rainTotalDaily = rainTotalDaily;
	}

	public String getRainTotalDailyUnit() {
		return rainTotalDailyUnit;
	}

	public void setRainTotalDailyUnit( String rainTotalDailyUnit ) {
		this.rainTotalDailyUnit = rainTotalDailyUnit;
	}

}
