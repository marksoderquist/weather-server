package net.soderquist.mark.weather;

@SuppressWarnings( "WeakerAccess" )
public class WeatherStation {

	private static final String DEGREE = "\u00B0";

	private String id;

	private String name;

	private long timestamp;

	// Basic weather measures
	private double temperature;

	private double pressure;

	private double humidity;

	private double dewPoint;

	private double windChill;

	private double heatIndex;

	private double wind;

	private double windDirection;

	private double rainTotalDaily;

	private double rainRate;

	// Avg, min, max and trends
	private double temperatureOneMinTrend;

	private double humidityOneHourTrend;

	private double pressureOneHourTrend;

	private double windOneMinTrend;

	private double windTenMinMax;

	private double windTenMinAvg;

	private double windTenMinMin;

	private double windTwoMinMax;

	private double windTwoMinAvg;

	private double windTwoMinMin;

	private double windDirectionTenMinAvg;

	private double windDirectionTwoMinAvg;

	// Unit values.
	private static final String temperatureUnit = DEGREE + "F";

	private static final String humidityUnit = "%";

	private static final String pressureUnit = "inHg";

	private static final String windUnit = "MPH";

	private static final String windDirectionUnit = DEGREE;

	private static final String rainUnit = "in";

	private static final String rainRateUnit = "in/hr";

	private static final String temperatureTrendUnit = temperatureUnit + "/min";

	private static final String pressureTrendUnit = pressureUnit + "inHg/";

	private static final String windTrendUnit = windUnit + "/min";

	public WeatherStation() {}

	public WeatherStation( String id, String name ) {
		this.id = id;
		this.name = name;
	}

	public String getId() {return this.id;}

	public String getName() {return this.name;}

	public long getTimestamp() {return this.timestamp;}

	// Weather basics
	public double getTemperature() {return this.temperature;}

	public double getPressure() {return this.pressure;}

	public double getHumidity() {return this.humidity;}

	public double getDewPoint() {return this.dewPoint;}

	public double getWindChill() {return this.windChill;}

	public double getHeatIndex() {return this.heatIndex;}

	public double getWindDirection() {return this.windDirection;}

	public double getWind() {return this.wind;}

	public double getRainTotalDaily() {return this.rainTotalDaily;}

	public double getRainRate() {return this.rainRate;}

	public double getTemperatureOneMinTrend() { return temperatureOneMinTrend; }

	public double getHumidityOneHourTrend() { return humidityOneHourTrend; }

	// Avg, min, max and trends
	public double getPressureTrend() {return getPressureOneHourTrend();}

	public double getPressureOneHourTrend() { return pressureOneHourTrend; }

	public double getWindOneMinTrend() { return windOneMinTrend; }

	public double getWindTenMinMax() {return this.windTenMinMax;}

	public double getWindTenMinAvg() {return this.windTenMinAvg;}

	public double getWindTenMinMin() {return this.windTenMinMin;}

	public double getWindTwoMinMax() {return this.windTwoMinMax;}

	public double getWindTwoMinAvg() {return this.windTwoMinAvg;}

	public double getWindTwoMinMin() {return this.windTwoMinMin;}

	public double getWindDirectionTenMinAvg() { return windDirectionTenMinAvg; }

	public double getWindDirectionTwoMinAvg() { return windDirectionTwoMinAvg; }

	public static String getTemperatureUnit() { return temperatureUnit; }

	public static String getHumidityUnit() { return humidityUnit; }

	public static String getPressureUnit() { return pressureUnit; }

	public static String getWindUnit() { return windUnit; }

	public static String getWindDirectionUnit() { return windDirectionUnit; }

	public static String getRainUnit() { return rainUnit; }

	public static String getRainRateUnit() { return rainRateUnit; }

	public static String getTemperatureTrendUnit() { return temperatureTrendUnit; }

	public static String getPressureTrendUnit() { return pressureTrendUnit; }

	public static String getWindTrendUnit() { return windTrendUnit; }

	public void setId( String id ) {this.id = id; }

	public void setName( String name ) {this.name = name; }

	public void setTimestamp( long timestamp ) {this.timestamp = timestamp; }

	// Weather basics
	public void setTemperature( double temperature ) {this.temperature = temperature; }

	public void setPressure( double pressure ) {this.pressure = pressure; }

	public void setHumidity( double humidity ) {this.humidity = humidity; }

	public void setDewPoint( double dewPoint ) {this.dewPoint = dewPoint; }

	public void setWindChill( double windChill ) {this.windChill = windChill; }

	public void setHeatIndex( double heatIndex ) {this.heatIndex = heatIndex; }

	public void setWind( double wind ) {this.wind = wind; }

	public void setWindDirection( double windDirection ) {this.windDirection = windDirection; }

	public void setRainTotalDaily( double rainTotalDaily ) {this.rainTotalDaily = rainTotalDaily; }

	public void setRainRate( double rainRate ) {this.rainRate = rainRate; }

	public void setTemperatureOneMinTrend( double temperatureOneMinTrend ) { this.temperatureOneMinTrend = temperatureOneMinTrend; }

	public void setHumidityOneHourTrend( double humidityOneHourTrend ) { this.humidityOneHourTrend = humidityOneHourTrend; }

	// Avg, min, max and trend
	public void setPressureOneHourTrend( double pressureOneHourTrend ) { this.pressureOneHourTrend = pressureOneHourTrend; }

	public void setWindOneMinTrend( double windOneMinTrend ) { this.windOneMinTrend = windOneMinTrend; }

	public void setWindTenMinMax( double windTenMinMax ) {this.windTenMinMax = windTenMinMax; }

	public void setWindTenMinAvg( double windTenMinAvg ) {this.windTenMinAvg = windTenMinAvg; }

	public void setWindTenMinMin( double windTenMinMin ) {this.windTenMinMin = windTenMinMin; }

	public void setWindTwoMinMax( double windTwoMinMax ) {this.windTwoMinMax = windTwoMinMax; }

	public void setWindTwoMinAvg( double windTwoMinAvg ) {this.windTwoMinAvg = windTwoMinAvg; }

	public void setWindTwoMinMin( double windTwoMinMin ) {this.windTwoMinMin = windTwoMinMin; }

	public void setWindDirectionTenMinAvg( double windDirectionTenMinAvg ) { this.windDirectionTenMinAvg = windDirectionTenMinAvg; }

	public void setWindDirectionTwoMinAvg( double windDirectionTwoMinAvg ) { this.windDirectionTwoMinAvg = windDirectionTwoMinAvg; }

	public boolean equals( Object o ) {
		if( o == this ) return true;
		if( !(o instanceof WeatherStation) ) return false;
		final WeatherStation other = (WeatherStation)o;
		if( !other.canEqual( this ) ) return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		return this$id == null ? other$id == null : this$id.equals( other$id );
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		return result;
	}

	protected boolean canEqual( Object other ) {return other instanceof WeatherStation;}

	public String toString() {return "WeatherStation(id=" + this.getId() + ", name=" + this.getName() + ", timestamp=" + this.getTimestamp() + ", temperature=" + this.getTemperature() + ", pressure=" + this.getPressure() + ", humidity=" + this.getHumidity() + ", dewPoint=" + this.getDewPoint() + ", windChill=" + this.getWindChill() + ", heatIndex=" + this.getHeatIndex() + ", wind=" + this.getWind() + ", windDirection=" + this.getWindDirection() + ", rainTotalDaily=" + this.getRainTotalDaily() + ", rainRate=" + this.getRainRate() + ")";}
}
