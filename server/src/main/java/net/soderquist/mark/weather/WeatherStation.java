package net.soderquist.mark.weather;

import java.util.HashSet;
import java.util.Set;

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

	private double windSpeed;

	private double windDirection;

	private Cardinal windCardinal;

	private double rainTotalDaily;

	private double rainRate;

	// Avg, min, max and trends
	private double temperatureTrend;

	private double humidityTrend;

	private double pressureTrend;

	private double windSpeedTrend;

	private double windTenMinMax;

	private double windTenMinAvg;

	private double windTenMinMin;

	private double windTwoMinMax;

	private double windTwoMinAvg;

	private double windTwoMinMin;

	private double windDirectionTenMinAvg;

	private Cardinal windCardinalTenMinAvg;

	private double windDirectionTwoMinAvg;

	private Cardinal windCardinalTwoMinAvg;

	// Unit values.
	private String temperatureUnit = DEGREE + "F";

	private String humidityUnit = "%";

	private String pressureUnit = "in";

	private String windSpeedUnit = "mph";

	private String windDirectionUnit = DEGREE;

	private String rainUnit = "in";

	private String rainRateUnit = rainUnit + "/hr";

	private String temperatureTrendUnit = temperatureUnit + "/hr";

	private String humidityTrendUnit = humidityUnit + "/hr";

	private String pressureTrendUnit = pressureUnit + "/hr";

	private String windSpeedTrendUnit = windSpeedUnit + "/hr";

	private Flying flying;

	public WeatherStation() {}

	public WeatherStation( String id, String name ) {
		this.id = id;
		this.name = name;
		this.flying = new Flying();
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

	public Cardinal getWindCardinal() { return this.windCardinal;}

	public double getWindSpeed() {return this.windSpeed;}

	public double getRainTotalDaily() {return this.rainTotalDaily;}

	public double getRainRate() {return this.rainRate;}

	// Avg, min, max and trends
	public double getTemperatureTrend() { return temperatureTrend; }

	public double getHumidityTrend() { return humidityTrend; }

	public double getPressureTrend() { return pressureTrend; }

	public double getWindSpeedTrend() { return windSpeedTrend; }

	public double getWindTenMinMax() {return this.windTenMinMax;}

	public double getWindTenMinAvg() {return this.windTenMinAvg;}

	public double getWindTenMinMin() {return this.windTenMinMin;}

	public double getWindTwoMinMax() {return this.windTwoMinMax;}

	public double getWindTwoMinAvg() {return this.windTwoMinAvg;}

	public double getWindTwoMinMin() {return this.windTwoMinMin;}

	public double getWindDirectionTenMinAvg() { return windDirectionTenMinAvg; }

	public Cardinal getWindCardinalTenMinAvg() { return windCardinalTenMinAvg; }

	public double getWindDirectionTwoMinAvg() { return windDirectionTwoMinAvg; }

	public Cardinal getWindCardinalTwoMinAvg() { return windCardinalTwoMinAvg; }

	public String getTemperatureUnit() { return temperatureUnit; }

	public String getHumidityUnit() { return humidityUnit; }

	public String getPressureUnit() { return pressureUnit; }

	public String getWindSpeedUnit() { return windSpeedUnit; }

	public String getWindDirectionUnit() { return windDirectionUnit; }

	public String getRainUnit() { return rainUnit; }

	public String getRainRateUnit() { return rainRateUnit; }

	public String getTemperatureTrendUnit() { return temperatureTrendUnit; }

	public String getHumidityTrendUnit() { return humidityTrendUnit; }

	public String getPressureTrendUnit() { return pressureTrendUnit; }

	public String getWindSpeedTrendUnit() { return windSpeedTrendUnit; }

	// Weather station
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

	public void setWindSpeed( double windSpeed ) {this.windSpeed = windSpeed; }

	public void setWindDirection( double windDirection ) {
		this.windDirection = windDirection;
		this.windCardinal = Cardinal.toCardinal( windDirection );
	}

	public void setRainTotalDaily( double rainTotalDaily ) {this.rainTotalDaily = rainTotalDaily; }

	public void setRainRate( double rainRate ) {this.rainRate = rainRate; }

	// Avg, min, max and trend
	public void setTemperatureTrend( double temperatureTrend ) { this.temperatureTrend = temperatureTrend; }

	public void setHumidityTrend( double humidityTrend ) { this.humidityTrend = humidityTrend; }

	public void setPressureTrend( double pressureTrend ) { this.pressureTrend = pressureTrend; }

	public void setWindSpeedTrend( double windSpeedTrend ) { this.windSpeedTrend = windSpeedTrend; }

	public void setWindTenMinMax( double windTenMinMax ) {this.windTenMinMax = windTenMinMax; }

	public void setWindTenMinAvg( double windTenMinAvg ) {this.windTenMinAvg = windTenMinAvg; }

	public void setWindTenMinMin( double windTenMinMin ) {this.windTenMinMin = windTenMinMin; }

	public void setWindTwoMinMax( double windTwoMinMax ) {this.windTwoMinMax = windTwoMinMax; }

	public void setWindTwoMinAvg( double windTwoMinAvg ) {this.windTwoMinAvg = windTwoMinAvg; }

	public void setWindTwoMinMin( double windTwoMinMin ) {this.windTwoMinMin = windTwoMinMin; }

	public void setWindDirectionTenMinAvg( double windDirectionTenMinAvg ) {
		this.windDirectionTenMinAvg = windDirectionTenMinAvg;
		this.windCardinalTenMinAvg = Cardinal.toCardinal( windDirectionTenMinAvg );
	}

	public void setWindDirectionTwoMinAvg( double windDirectionTwoMinAvg ) {
		this.windDirectionTwoMinAvg = windDirectionTwoMinAvg;
		this.windCardinalTwoMinAvg = Cardinal.toCardinal( windDirectionTwoMinAvg );
	}

	public void setTemperatureUnit( String temperatureUnit ) { this.temperatureUnit = temperatureUnit; }

	public void setHumidityUnit( String humidityUnit ) { this.humidityUnit = humidityUnit; }

	public void setPressureUnit( String pressureUnit ) { this.pressureUnit = pressureUnit; }

	public void setWindSpeedUnit( String windSpeedUnit ) { this.windSpeedUnit = windSpeedUnit; }

	public void setWindDirectionUnit( String windDirectionUnit ) { this.windDirectionUnit = windDirectionUnit; }

	public void setRainUnit( String rainUnit ) { this.rainUnit = rainUnit; }

	public void setRainRateUnit( String rainRateUnit ) { this.rainRateUnit = rainRateUnit; }

	public void setTemperatureTrendUnit( String temperatureTrendUnit ) { this.temperatureTrendUnit = temperatureTrendUnit; }

	public void setHumidityTrendUnit( String humidityTrendUnit ) {this.humidityTrendUnit = humidityTrendUnit; }

	public void setPressureTrendUnit( String pressureTrendUnit ) { this.pressureTrendUnit = pressureTrendUnit; }

	public void setWindSpeedTrendUnit( String windSpeedTrendUnit ) { this.windSpeedTrendUnit = windSpeedTrendUnit; }

	public Flying getFlying() {
		return flying;
	}

	public void setFlying( Flying flying ) {
		this.flying = flying;
	}

	public void copyFrom( WeatherStation that ) {
		this.setTimestamp( that.getTimestamp() );

		this.setTemperature( that.getTemperature() );
		this.setPressure( that.getPressure() );
		this.setHumidity( that.getHumidity() );
		this.setDewPoint( that.getDewPoint() );
		this.setWindChill( that.getWindChill() );
		this.setHeatIndex( that.getHeatIndex() );
		this.setWindSpeed( that.getWindSpeed() );
		this.setWindDirection( that.getWindDirection() );
		this.setRainTotalDaily( that.getRainTotalDaily() );
		this.setRainRate( that.getRainRate() );

		this.setTemperatureTrend( that.getTemperatureTrend() );
		this.setHumidityTrend( that.getHumidityTrend() );
		this.setPressureTrend( that.getPressureTrend() );
		this.setWindSpeedTrend( that.getWindSpeedTrend() );

		this.setWindTenMinMax( that.getWindTenMinMax() );
		this.setWindTenMinAvg( that.getWindTenMinAvg() );
		this.setWindTenMinMin( that.getWindTenMinMin() );
		this.setWindTwoMinMax( that.getWindTwoMinMax() );
		this.setWindTwoMinAvg( that.getWindTwoMinAvg() );
		this.setWindTwoMinMin( that.getWindTwoMinMin() );
		this.setWindDirectionTenMinAvg( that.getWindDirectionTenMinAvg() );
		this.setWindDirectionTwoMinAvg( that.getWindDirectionTwoMinAvg() );

		this.setTemperatureUnit( that.getTemperatureUnit() );
		this.setHumidityUnit( that.getHumidityUnit() );
		this.setPressureUnit( that.getPressureUnit() );
		this.setWindSpeedUnit( that.getWindSpeedUnit() );
		this.setWindDirectionUnit( that.getWindDirectionUnit() );
		this.setRainUnit( that.getRainUnit() );
		this.setRainRateUnit( that.getRainRateUnit() );
		this.setTemperatureTrendUnit( that.getTemperatureTrendUnit() );
		this.setHumidityTrendUnit( that.getHumidityTrendUnit() );
		this.setPressureTrendUnit( that.getPressureTrendUnit() );
		this.setWindSpeedTrendUnit( that.getWindSpeedTrendUnit() );

		updateFlyingConditions();
	}

	private void updateFlyingConditions() {
		updateFlyingCondition( Flying.Condition.GREAT );
		Set<Flying.Reason> reasons = new HashSet<>();

		double temperature = getTemperature();
		if( temperature >= 100 ) {
			updateFlyingCondition( Flying.Condition.POOR );
			reasons.add( Flying.Reason.HOT );
		} else if( temperature < 100 && temperature >= 90 ) {
			updateFlyingCondition( Flying.Condition.FAIR );
			reasons.add( Flying.Reason.WARM );
		} else if( temperature < 90 && temperature >= 80 ) {
			updateFlyingCondition( Flying.Condition.GOOD );
			//reasons.add( Flying.Reason.WARM );
		} else if( temperature < 80 && temperature >= 70 ) {
			updateFlyingCondition( Flying.Condition.GREAT );
		} else if( temperature < 70 && temperature >= 60 ) {
			updateFlyingCondition( Flying.Condition.GOOD );
			//reasons.add( Flying.Reason.COOL );
		} else if( temperature < 60 && temperature >= 50 ) {
			updateFlyingCondition( Flying.Condition.FAIR );
			reasons.add( Flying.Reason.COOL );
		} else if( temperature < 50 && temperature >= 30 ) {
			updateFlyingCondition( Flying.Condition.POOR );
			reasons.add( Flying.Reason.COLD );
		} else if( temperature < 30 ) {
			updateFlyingCondition( Flying.Condition.BAD );
			reasons.add( Flying.Reason.COLD );
		}

		double wind = getWindTenMinAvg();
		if( wind >= 25 ) {
			updateFlyingCondition( Flying.Condition.BAD );
			reasons.add( Flying.Reason.WINDY );
		} else if( wind < 25 && wind >= 20 ) {
			updateFlyingCondition( Flying.Condition.POOR );
			reasons.add( Flying.Reason.WINDY );
		} else if( wind < 20 && wind >= 15 ) {
			updateFlyingCondition( Flying.Condition.FAIR );
			reasons.add( Flying.Reason.BREEZY );
		} else if( wind < 15 && wind >= 10 ) {
			updateFlyingCondition( Flying.Condition.GOOD );
			reasons.add( Flying.Reason.BREEZY );
		} else if( wind < 10 ) {
			updateFlyingCondition( Flying.Condition.GREAT );
		}

		this.getFlying().setReasons( reasons );
	}

	private void updateFlyingCondition( Flying.Condition condition ) {
		if( condition.ordinal() > getFlying().getCondition().ordinal() ) getFlying().setCondition( condition );
	}

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

	public String toString() {return "WeatherStation(id=" + this.getId() + ", name=" + this.getName() + ", timestamp=" + this.getTimestamp() + ", temperature=" + this.getTemperature() + ", pressure=" + this.getPressure() + ", humidity=" + this.getHumidity() + ", dewPoint=" + this.getDewPoint() + ", windChill=" + this.getWindChill() + ", heatIndex=" + this.getHeatIndex() + ", wind=" + this.getWindSpeed() + ", windDirection=" + this.getWindDirection() + ", rainTotalDaily=" + this.getRainTotalDaily() + ", rainRate=" + this.getRainRate() + ")";}
}
