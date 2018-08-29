package net.soderquist.mark.weather;

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
	private static final String temperatureUnit = DEGREE + "F";

	private static final String humidityUnit = "%";

	private static final String pressureUnit = "inHg";

	private static final String pressureRateUnit = "inHg/hr";

	private static final String windUnit = "MPH";

	private static final String windDirectionUnit = DEGREE;

	private static final String rainUnit = "in";

	private static final String rainRateUnit = "in/hr";

	public WeatherStation() {}

	public WeatherStation( String id, String name ) {
		this.id = id;
		this.name = name;
	}

	public String getId() {return this.id;}

	public String getName() {return this.name;}

	public long getTimestamp() {return this.timestamp;}

	public float getTemperature() {return this.temperature;}

	public float getPressure() {return this.pressure;}

	public float getHumidity() {return this.humidity;}

	public float getDewPoint() {return this.dewPoint;}

	public float getWindChill() {return this.windChill;}

	public float getHeatIndex() {return this.heatIndex;}

	public float getPressureTrend() {return this.pressureTrend;}

	public float getWindDirection() {return this.windDirection;}

	public float getWind() {return this.wind;}

	public float getWindTenMinMax() {return this.windTenMinMax;}

	public float getWindTenMinAvg() {return this.windTenMinAvg;}

	public float getWindTenMinMin() {return this.windTenMinMin;}

	public float getWindTwoMinMax() {return this.windTwoMinMax;}

	public float getWindTwoMinAvg() {return this.windTwoMinAvg;}

	public float getWindTwoMinMin() {return this.windTwoMinMin;}

	public float getRainTotalDaily() {return this.rainTotalDaily;}

	public float getRainRate() {return this.rainRate;}

	public void setId( String id ) {this.id = id; }

	public void setName( String name ) {this.name = name; }

	public void setTimestamp( long timestamp ) {this.timestamp = timestamp; }

	public void setTemperature( float temperature ) {this.temperature = temperature; }

	public void setPressure( float pressure ) {this.pressure = pressure; }

	public void setHumidity( float humidity ) {this.humidity = humidity; }

	public void setDewPoint( float dewPoint ) {this.dewPoint = dewPoint; }

	public void setWindChill( float windChill ) {this.windChill = windChill; }

	public void setHeatIndex( float heatIndex ) {this.heatIndex = heatIndex; }

	public void setPressureTrend( float pressureTrend ) {this.pressureTrend = pressureTrend; }

	public void setWindDirection( float windDirection ) {this.windDirection = windDirection; }

	public void setWind( float wind ) {this.wind = wind; }

	public void setWindTenMinMax( float windTenMinMax ) {this.windTenMinMax = windTenMinMax; }

	public void setWindTenMinAvg( float windTenMinAvg ) {this.windTenMinAvg = windTenMinAvg; }

	public void setWindTenMinMin( float windTenMinMin ) {this.windTenMinMin = windTenMinMin; }

	public void setWindTwoMinMax( float windTwoMinMax ) {this.windTwoMinMax = windTwoMinMax; }

	public void setWindTwoMinAvg( float windTwoMinAvg ) {this.windTwoMinAvg = windTwoMinAvg; }

	public void setWindTwoMinMin( float windTwoMinMin ) {this.windTwoMinMin = windTwoMinMin; }

	public void setRainTotalDaily( float rainTotalDaily ) {this.rainTotalDaily = rainTotalDaily; }

	public void setRainRate( float rainRate ) {this.rainRate = rainRate; }

	public boolean equals( Object o ) {
		if( o == this ) return true;
		if( !(o instanceof WeatherStation) ) return false;
		final WeatherStation other = (WeatherStation)o;
		if( !other.canEqual( (Object)this ) ) return false;
		final Object this$id = this.getId();
		final Object other$id = other.getId();
		if( this$id == null ? other$id != null : !this$id.equals( other$id ) ) return false;
		final Object this$name = this.getName();
		final Object other$name = other.getName();
		if( this$name == null ? other$name != null : !this$name.equals( other$name ) ) return false;
		if( this.getTimestamp() != other.getTimestamp() ) return false;
		if( Float.compare( this.getTemperature(), other.getTemperature() ) != 0 ) return false;
		if( Float.compare( this.getPressure(), other.getPressure() ) != 0 ) return false;
		if( Float.compare( this.getHumidity(), other.getHumidity() ) != 0 ) return false;
		if( Float.compare( this.getDewPoint(), other.getDewPoint() ) != 0 ) return false;
		if( Float.compare( this.getWindChill(), other.getWindChill() ) != 0 ) return false;
		if( Float.compare( this.getHeatIndex(), other.getHeatIndex() ) != 0 ) return false;
		if( Float.compare( this.getPressureTrend(), other.getPressureTrend() ) != 0 ) return false;
		if( Float.compare( this.getWindDirection(), other.getWindDirection() ) != 0 ) return false;
		if( Float.compare( this.getWind(), other.getWind() ) != 0 ) return false;
		if( Float.compare( this.getWindTenMinMax(), other.getWindTenMinMax() ) != 0 ) return false;
		if( Float.compare( this.getWindTenMinAvg(), other.getWindTenMinAvg() ) != 0 ) return false;
		if( Float.compare( this.getWindTenMinMin(), other.getWindTenMinMin() ) != 0 ) return false;
		if( Float.compare( this.getWindTwoMinMax(), other.getWindTwoMinMax() ) != 0 ) return false;
		if( Float.compare( this.getWindTwoMinAvg(), other.getWindTwoMinAvg() ) != 0 ) return false;
		if( Float.compare( this.getWindTwoMinMin(), other.getWindTwoMinMin() ) != 0 ) return false;
		if( Float.compare( this.getRainTotalDaily(), other.getRainTotalDaily() ) != 0 ) return false;
		if( Float.compare( this.getRainRate(), other.getRainRate() ) != 0 ) return false;
		return true;
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		final Object $name = this.getName();
		result = result * PRIME + ($name == null ? 43 : $name.hashCode());
		final long $timestamp = this.getTimestamp();
		result = result * PRIME + (int)($timestamp >>> 32 ^ $timestamp);
		result = result * PRIME + Float.floatToIntBits( this.getTemperature() );
		result = result * PRIME + Float.floatToIntBits( this.getPressure() );
		result = result * PRIME + Float.floatToIntBits( this.getHumidity() );
		result = result * PRIME + Float.floatToIntBits( this.getDewPoint() );
		result = result * PRIME + Float.floatToIntBits( this.getWindChill() );
		result = result * PRIME + Float.floatToIntBits( this.getHeatIndex() );
		result = result * PRIME + Float.floatToIntBits( this.getPressureTrend() );
		result = result * PRIME + Float.floatToIntBits( this.getWindDirection() );
		result = result * PRIME + Float.floatToIntBits( this.getWind() );
		result = result * PRIME + Float.floatToIntBits( this.getWindTenMinMax() );
		result = result * PRIME + Float.floatToIntBits( this.getWindTenMinAvg() );
		result = result * PRIME + Float.floatToIntBits( this.getWindTenMinMin() );
		result = result * PRIME + Float.floatToIntBits( this.getWindTwoMinMax() );
		result = result * PRIME + Float.floatToIntBits( this.getWindTwoMinAvg() );
		result = result * PRIME + Float.floatToIntBits( this.getWindTwoMinMin() );
		result = result * PRIME + Float.floatToIntBits( this.getRainTotalDaily() );
		result = result * PRIME + Float.floatToIntBits( this.getRainRate() );
		return result;
	}

	protected boolean canEqual( Object other ) {return other instanceof WeatherStation;}

	public String toString() {return "WeatherStation(id=" + this.getId() + ", name=" + this.getName() + ", timestamp=" + this.getTimestamp() + ", temperature=" + this.getTemperature() + ", pressure=" + this.getPressure() + ", humidity=" + this.getHumidity() + ", dewPoint=" + this.getDewPoint() + ", windChill=" + this.getWindChill() + ", heatIndex=" + this.getHeatIndex() + ", pressureTrend=" + this.getPressureTrend() + ", windDirection=" + this.getWindDirection() + ", wind=" + this.getWind() + ", windTenMinMax=" + this.getWindTenMinMax() + ", windTenMinAvg=" + this.getWindTenMinAvg() + ", windTenMinMin=" + this.getWindTenMinMin() + ", windTwoMinMax=" + this.getWindTwoMinMax() + ", windTwoMinAvg=" + this.getWindTwoMinAvg() + ", windTwoMinMin=" + this.getWindTwoMinMin() + ", rainTotalDaily=" + this.getRainTotalDaily() + ", rainRate=" + this.getRainRate() + ")";}
}
