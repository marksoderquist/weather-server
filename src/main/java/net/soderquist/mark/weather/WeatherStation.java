package net.soderquist.mark.weather;

import lombok.Getter;
import lombok.Setter;
import org.shredzone.commons.suncalc.SunPosition;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

@SuppressWarnings( "WeakerAccess" )
public class WeatherStation {

	public static final double DEGREES_C_PER_DEGREES_F = 5.0 / 9.0;

	public static final double DEGREES_F_PER_DEGREES_C = 9.0 / 5.0;

	public static final double KPH_PER_MPH = 1.609344;

	public static final double MPH_PER_KPH = 1.0 / 1.609344;

	private static final String DEGREE = "\u00B0";

	private String id;

	private String name;

	private double latitude;

	private double longitude;

	private String serverVersion;

	private long timestamp;

	@Getter
	@Setter
	private UnitSystem unitSystem;

	// Basic weather measures
	private double temperature;

	@Deprecated
	private double temperatureMetric;

	private double pressure;

	private double humidity;

	private double dewPoint;

	@Deprecated
	private double dewPointMetric;

	private double windChill;

	@Deprecated
	private double windChillMetric;

	private double heatIndex;

	@Deprecated
	private double heatIndexMetric;

	private double feelsLike;

	@Deprecated
	private double feelsLikeMetric;

	private double windSpeed;

	@Deprecated
	private double windSpeedMetric;

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

	private double sunAltitude;

	private double sunIllumination;

	// Unit values.
	private String temperatureUnit = DEGREE + "F";

	@Deprecated
	private String temperatureUnitMetric = DEGREE + "C";

	private String humidityUnit = "%";

	private String pressureUnit = "in";

	private String windSpeedUnit = "mph";

	@Deprecated
	private String windSpeedUnitMetric = "kph";

	private String windDirectionUnit = DEGREE;

	private String rainUnit = "in";

	@Deprecated
	private String rainUnitMetric = "mm";

	private String rainRateUnit = rainUnit + "/hr";

	private String temperatureTrendUnit = temperatureUnit + "/hr";

	private String humidityTrendUnit = humidityUnit + "/hr";

	private String pressureTrendUnit = pressureUnit + "/hr";

	private String windSpeedTrendUnit = windSpeedUnit + "/hr";

	private String sunAltitudeUnit = DEGREE;

	private String sunIlluminationUnit = "%";

	private FlightCondition flightCondition;

	public WeatherStation( String id, String name, double latitude, double longitude, UnitSystem unitSystem ) {
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.unitSystem = unitSystem;
		this.flightCondition = new FlightCondition();
	}

	public String getId() {return this.id;}

	public String getName() {return this.name;}

	public long getTimestamp() {return this.timestamp;}

	// Weather basics
	public double getTemperature() {return this.temperature;}

	public double getTemperatureMetric() {return this.temperatureMetric;}

	public double getPressure() {return this.pressure;}

	public double getHumidity() {return this.humidity;}

	public double getDewPoint() {return this.dewPoint;}

	public double getDewPointMetric() {return this.dewPointMetric;}

	public double getWindChill() {return this.windChill;}

	public double getWindChillMetric() {return this.windChillMetric;}

	public double getHeatIndex() {return this.heatIndex;}

	public double getHeatIndexMetric() {return this.heatIndexMetric;}

	public double getFeelsLike() {return this.feelsLike;}

	public double getFeelsLikeMetric() {return this.feelsLikeMetric;}

	public double getWindDirection() {return this.windDirection;}

	public Cardinal getWindCardinal() {return this.windCardinal;}

	public double getWindSpeed() {return this.windSpeed;}

	public double getWindSpeedMetric() {return this.windSpeedMetric;}

	public double getRainTotalDaily() {return this.rainTotalDaily;}

	public double getRainRate() {return this.rainRate;}

	// Avg, min, max and trends
	public double getTemperatureTrend() {return temperatureTrend;}

	public double getHumidityTrend() {return humidityTrend;}

	public double getPressureTrend() {return pressureTrend;}

	public double getWindSpeedTrend() {return windSpeedTrend;}

	public double getWindTenMinMax() {return this.windTenMinMax;}

	public double getWindTenMinAvg() {return this.windTenMinAvg;}

	public double getWindTenMinMin() {return this.windTenMinMin;}

	public double getWindTwoMinMax() {return this.windTwoMinMax;}

	public double getWindTwoMinAvg() {return this.windTwoMinAvg;}

	public double getWindTwoMinMin() {return this.windTwoMinMin;}

	public double getWindDirectionTenMinAvg() {return windDirectionTenMinAvg;}

	public Cardinal getWindCardinalTenMinAvg() {return windCardinalTenMinAvg;}

	public double getWindDirectionTwoMinAvg() {return windDirectionTwoMinAvg;}

	public Cardinal getWindCardinalTwoMinAvg() {return windCardinalTwoMinAvg;}

	public double getSunAltitude() {return sunAltitude;}

	public double getSunIllumination() {return sunIllumination;}

	public String getTemperatureUnit() {return temperatureUnit;}

	public String getTemperatureUnitMetric() {return temperatureUnitMetric;}

	public String getHumidityUnit() {return humidityUnit;}

	public String getPressureUnit() {return pressureUnit;}

	public String getWindSpeedUnit() {return windSpeedUnit;}

	public String getWindSpeedUnitMetric() {return windSpeedUnitMetric;}

	public String getWindDirectionUnit() {return windDirectionUnit;}

	public String getRainUnit() {return rainUnit;}

	public String getRainRateUnit() {return rainRateUnit;}

	public String getTemperatureTrendUnit() {return temperatureTrendUnit;}

	public String getHumidityTrendUnit() {return humidityTrendUnit;}

	public String getPressureTrendUnit() {return pressureTrendUnit;}

	public String getWindSpeedTrendUnit() {return windSpeedTrendUnit;}

	public String getSunAltitudeUnit() {return sunAltitudeUnit;}

	public String getSunIlluminationUnit() {return sunIlluminationUnit;}

	// Weather station
	public void setId( String id ) {this.id = id;}

	public void setName( String name ) {this.name = name;}

	public void setTimestamp( long timestamp ) {this.timestamp = timestamp;}

	// Weather basics
	public void setTemperature( double temperature ) {this.temperature = temperature;}

	public void setTemperatureMetric( double temperatureMetric ) {this.temperatureMetric = temperatureMetric;}

	public void setPressure( double pressure ) {this.pressure = pressure;}

	public void setHumidity( double humidity ) {this.humidity = humidity;}

	public void setDewPoint( double dewPoint ) {this.dewPoint = dewPoint;}

	public void setDewPointMetric( double dewPointMetric ) {this.dewPointMetric = dewPointMetric;}

	public void setWindChill( double windChill ) {this.windChill = windChill;}

	public void setWindChillMetric( double windChillMetric ) {this.windChillMetric = windChillMetric;}

	public void setHeatIndex( double heatIndex ) {this.heatIndex = heatIndex;}

	public void setHeatIndexMetric( double heatIndexMetric ) {this.heatIndexMetric = heatIndexMetric;}

	public void setFeelsLike( double feelsLike ) {this.feelsLike = feelsLike;}

	public void setFeelsLikeMetric( double feelsLikeMetric ) {this.feelsLikeMetric = feelsLikeMetric;}

	public void setWindSpeed( double windSpeed ) {this.windSpeed = windSpeed;}

	public void setWindSpeedMetric( double windSpeedMetric ) {this.windSpeedMetric = windSpeedMetric;}

	public void setWindDirection( double windDirection ) {
		this.windDirection = windDirection;
		this.windCardinal = Cardinal.toCardinal( windDirection );
	}

	public void setRainTotalDaily( double rainTotalDaily ) {this.rainTotalDaily = rainTotalDaily;}

	public void setRainRate( double rainRate ) {this.rainRate = rainRate;}

	// Avg, min, max and trend
	public void setTemperatureTrend( double temperatureTrend ) {this.temperatureTrend = temperatureTrend;}

	public void setHumidityTrend( double humidityTrend ) {this.humidityTrend = humidityTrend;}

	public void setPressureTrend( double pressureTrend ) {this.pressureTrend = pressureTrend;}

	public void setWindSpeedTrend( double windSpeedTrend ) {this.windSpeedTrend = windSpeedTrend;}

	public void setWindTenMinMax( double windTenMinMax ) {this.windTenMinMax = windTenMinMax;}

	public void setWindTenMinAvg( double windTenMinAvg ) {this.windTenMinAvg = windTenMinAvg;}

	public void setWindTenMinMin( double windTenMinMin ) {this.windTenMinMin = windTenMinMin;}

	public void setWindTwoMinMax( double windTwoMinMax ) {this.windTwoMinMax = windTwoMinMax;}

	public void setWindTwoMinAvg( double windTwoMinAvg ) {this.windTwoMinAvg = windTwoMinAvg;}

	public void setWindTwoMinMin( double windTwoMinMin ) {this.windTwoMinMin = windTwoMinMin;}

	public void setWindDirectionTenMinAvg( double windDirectionTenMinAvg ) {
		this.windDirectionTenMinAvg = windDirectionTenMinAvg;
		this.windCardinalTenMinAvg = Cardinal.toCardinal( windDirectionTenMinAvg );
	}

	public void setWindDirectionTwoMinAvg( double windDirectionTwoMinAvg ) {
		this.windDirectionTwoMinAvg = windDirectionTwoMinAvg;
		this.windCardinalTwoMinAvg = Cardinal.toCardinal( windDirectionTwoMinAvg );
	}

	public void setSunAltitude( double sunAltitude ) {this.sunAltitude = sunAltitude;}

	public void setSunIllumination( double sunIllumination ) {this.sunIllumination = sunIllumination;}

	public void setTemperatureUnit( String temperatureUnit ) {this.temperatureUnit = temperatureUnit;}

	public void setTemperatureUnitMetric( String temperatureUnitMetric ) {this.temperatureUnitMetric = temperatureUnitMetric;}

	public void setHumidityUnit( String humidityUnit ) {this.humidityUnit = humidityUnit;}

	public void setPressureUnit( String pressureUnit ) {this.pressureUnit = pressureUnit;}

	public void setWindSpeedUnit( String windSpeedUnit ) {this.windSpeedUnit = windSpeedUnit;}

	public void setWindSpeedUnitMetric( String windSpeedUnitMetric ) {this.windSpeedUnitMetric = windSpeedUnitMetric;}

	public void setWindDirectionUnit( String windDirectionUnit ) {this.windDirectionUnit = windDirectionUnit;}

	public void setRainUnit( String rainUnit ) {this.rainUnit = rainUnit;}

	public void setRainRateUnit( String rainRateUnit ) {this.rainRateUnit = rainRateUnit;}

	public void setTemperatureTrendUnit( String temperatureTrendUnit ) {this.temperatureTrendUnit = temperatureTrendUnit;}

	public void setHumidityTrendUnit( String humidityTrendUnit ) {this.humidityTrendUnit = humidityTrendUnit;}

	public void setPressureTrendUnit( String pressureTrendUnit ) {this.pressureTrendUnit = pressureTrendUnit;}

	public void setWindSpeedTrendUnit( String windSpeedTrendUnit ) {this.windSpeedTrendUnit = windSpeedTrendUnit;}

	public void setSunAltitudeUnit( String sunAltitudeUnit ) {this.sunAltitudeUnit = sunAltitudeUnit;}

	public void setSunIlluminationUnit( String sunIlluminationUnit ) {this.sunIlluminationUnit = sunIlluminationUnit;}

	public FlightCondition getFlightCondition() {
		return flightCondition;
	}

	public void setFlightCondition( FlightCondition flightCondition ) {
		this.flightCondition = flightCondition;
	}

	public String getServerVersion() {
		return serverVersion;
	}

	public void setServerVersion( String serverVersion ) {
		this.serverVersion = serverVersion;
	}

	public void copyFrom( WeatherStation that ) {
		this.setTimestamp( that.getTimestamp() );

		double calcFeelsLike = calcFeelsLike( that.getTemperature(), that.getWindTenMinAvg(), that.getHumidity() );

		this.setTemperature( that.getTemperature() );
		this.setTemperatureMetric( toDegreesC( that.getTemperature() ) );
		this.setPressure( that.getPressure() );
		this.setHumidity( that.getHumidity() );
		this.setDewPoint( that.getDewPoint() );
		this.setDewPointMetric( toDegreesC( that.getDewPoint() ) );
		this.setWindChill( that.getWindChill() );
		this.setWindChillMetric( toDegreesC( that.getWindChill() ) );
		this.setHeatIndex( that.getHeatIndex() );
		this.setHeatIndexMetric( toDegreesC( that.getHeatIndex() ) );
		this.setFeelsLike( calcFeelsLike );
		this.setFeelsLikeMetric( toDegreesC( calcFeelsLike ) );
		this.setWindSpeed( that.getWindSpeed() );
		this.setWindSpeedMetric( toKph( that.getWindSpeed() ) );
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
		this.setTemperatureUnitMetric( that.getTemperatureUnitMetric() );
		this.setHumidityUnit( that.getHumidityUnit() );
		this.setPressureUnit( that.getPressureUnit() );
		this.setWindSpeedUnit( that.getWindSpeedUnit() );
		this.setWindSpeedUnitMetric( that.getWindSpeedUnitMetric() );
		this.setWindDirectionUnit( that.getWindDirectionUnit() );
		this.setRainUnit( that.getRainUnit() );
		this.setRainRateUnit( that.getRainRateUnit() );
		this.setTemperatureTrendUnit( that.getTemperatureTrendUnit() );
		this.setHumidityTrendUnit( that.getHumidityTrendUnit() );
		this.setPressureTrendUnit( that.getPressureTrendUnit() );
		this.setWindSpeedTrendUnit( that.getWindSpeedTrendUnit() );

		// Using the sun altitude, calculate an illumination value
		// Civil twilight is -6 degrees (https://en.wikipedia.org/wiki/Twilight)
		SunPosition position = SunPosition.compute().on( new Date() ).at( latitude, longitude ).execute();
		double sunAltitude = position.getTrueAltitude();
		this.setSunAltitude( sunAltitude );
		this.setSunIllumination( sunAltitude <= 0 ? 0 : Math.sin( Math.toRadians( sunAltitude ) ) * 100 );

		updateFlyingConditions();
	}

	private double calcFeelsLike( double temperature, double wind, double humidity ) {
		if( temperature < 50 ) return calculateWindChill( temperature, wind );
		if( temperature > 80 ) return calculateHeatIndex( temperature, humidity );
		return temperature;
	}

	public static double toDegreesC( double degreesF ) {
		return (degreesF - 32) * DEGREES_C_PER_DEGREES_F;
	}

	public static double toDegreesF( double degreesC ) {
		return degreesC * DEGREES_F_PER_DEGREES_C + 32;
	}

	public static double toKph( double mph ) {
		return mph * KPH_PER_MPH;
	}

	public static double toMph( double kph ) {
		return kph * MPH_PER_KPH;
	}

	public static double calculateWindChill( double t, double w ) {
		if( w <= 3 || t >= 50 ) return t;

		return 35.74f + 0.6215f * t - 35.75f * Math.pow( w, 0.16 ) + 0.4275f * t * Math.pow( w, 0.16 );
	}

	public static double calculateHeatIndex( double t, double h ) {
		if( t < 80 || h < 40 ) return t;

		double c1 = -42.379;
		double c2 = 2.04901523;
		double c3 = 10.14333127;
		double c4 = -0.22475541;
		double c5 = -6.83783e-3;
		double c6 = -5.481717e-2;
		double c7 = 1.22874e-3;
		double c8 = 8.5282e-4;
		double c9 = -1.99e-6;

		double t2 = t * t;
		double h2 = h * h;

		double heatIndex = c1 + c2 * t + c3 * h + c4 * t * h + c5 * t2 + c6 * h2 + c7 * t2 * h + c8 * t * h2 + c9 * t2 * h2;
		return Math.max( t, heatIndex );
	}

	private void updateFlyingConditions() {
		getFlightCondition().reset();

		Calendar calendar = Calendar.getInstance( TimeZone.getTimeZone( "America/Denver" ) );
		boolean isPm = calendar.get( Calendar.AM_PM ) == Calendar.PM;

		double temperature = getTemperature();
		if( temperature >= 100 ) {
			updateFlightCondition( FlightCondition.Summary.HOLD, FlightCondition.Reason.HOT );
		} else if( temperature < 100 && temperature >= 90 ) {
			updateFlightCondition( FlightCondition.Summary.POOR, FlightCondition.Reason.HOT );
		} else if( temperature < 90 && temperature >= 80 ) {
			updateFlightCondition( FlightCondition.Summary.FAIR, FlightCondition.Reason.HOT );
		} else if( temperature < 80 && temperature >= 70 ) {
			updateFlightCondition( FlightCondition.Summary.GOOD, FlightCondition.Reason.WARM );
		} else if( temperature < 70 && temperature >= 60 ) {
			updateFlightCondition( FlightCondition.Summary.GREAT );
		} else if( temperature < 60 && temperature >= 50 ) {
			updateFlightCondition( FlightCondition.Summary.GOOD, FlightCondition.Reason.COOL );
		} else if( temperature < 50 && temperature >= 40 ) {
			updateFlightCondition( FlightCondition.Summary.FAIR, FlightCondition.Reason.COLD );
		} else if( temperature < 40 && temperature >= 30 ) {
			updateFlightCondition( FlightCondition.Summary.POOR, FlightCondition.Reason.COLD );
		} else if( temperature < 30 ) {
			updateFlightCondition( FlightCondition.Summary.HOLD, FlightCondition.Reason.COLD );
		}

		double wind = getWindTenMinAvg();
		double gust = getWindTwoMinMax();

		if( wind >= 20 ) {
			updateFlightCondition( FlightCondition.Summary.HOLD, FlightCondition.Reason.WINDY );
		} else if( wind >= 15 ) {
			updateFlightCondition( FlightCondition.Summary.POOR, FlightCondition.Reason.WINDY );
		} else if( wind >= 10 ) {
			updateFlightCondition( FlightCondition.Summary.FAIR, FlightCondition.Reason.BREEZY );
		} else if( wind >= 5 ) {
			updateFlightCondition( FlightCondition.Summary.GOOD, FlightCondition.Reason.BREEZY );
		} // otherwise GREAT

		if( gust >= 30 ) {
			updateFlightCondition( FlightCondition.Summary.HOLD, FlightCondition.Reason.GUSTY );
		} else if( gust >= 20 ) {
			updateFlightCondition( FlightCondition.Summary.POOR, FlightCondition.Reason.GUSTY );
		} else if( gust >= 15 ) {
			updateFlightCondition( FlightCondition.Summary.FAIR, FlightCondition.Reason.BUMPY );
		} else if( gust >= 10 ) {
			updateFlightCondition( FlightCondition.Summary.GOOD, FlightCondition.Reason.BUMPY );
		} // otherwise GREAT

		double sun = getSunAltitude();
		FlightCondition.Reason twilight = isPm ? FlightCondition.Reason.DUSK : FlightCondition.Reason.DAWN;
		if( sun <= -5 ) {
			updateFlightCondition( FlightCondition.Summary.HOLD, FlightCondition.Reason.DARK );
		} else if( sun <= 0 ) {
			updateFlightCondition( FlightCondition.Summary.POOR, twilight );
		} else if( sun <= 5 ) {
			updateFlightCondition( FlightCondition.Summary.FAIR, twilight );
		} // otherwise GREAT

		if( getRainRate() > 0 ) {
			updateFlightCondition( FlightCondition.Summary.POOR, FlightCondition.Reason.RAINY );
		} // otherwise GREAT
	}

	private void updateFlightCondition( FlightCondition.Summary summary ) {
		updateFlightCondition( summary, null );
	}

	private void updateFlightCondition( FlightCondition.Reason reason ) {
		updateFlightCondition( null, reason );
	}

	private void updateFlightCondition( FlightCondition.Summary summary, FlightCondition.Reason reason ) {
		if( summary != null && summary.ordinal() > getFlightCondition().getSummary().ordinal() ) getFlightCondition().setSummary( summary );
		if( reason != null ) getFlightCondition().getReasons().add( reason );
		getFlightCondition().getReasons().sort( null );
	}

	public boolean equals( Object o ) {
		if( o == this ) return true;
		if( !(o instanceof WeatherStation) ) return false;
		final WeatherStation other = (WeatherStation)o;
		if( !other.canEqual( this ) ) return false;
		return Objects.equals( this.getId(), other.getId() );
	}

	public int hashCode() {
		final int PRIME = 59;
		int result = 1;
		final Object $id = this.getId();
		result = result * PRIME + ($id == null ? 43 : $id.hashCode());
		return result;
	}

	protected boolean canEqual( Object other ) {return other instanceof WeatherStation;}

	public String toString() {
		return "WeatherStation(id=" + this.getId() + ", name=" + this.getName() + ", timestamp=" + this.getTimestamp() + ", temperature=" + this.getTemperature() + ", pressure=" + this.getPressure() + ", humidity=" + this.getHumidity() + ", dewPoint=" + this.getDewPoint() + ", windChill=" + this.getWindChill() + ", heatIndex=" + this.getHeatIndex() + ", wind=" + this.getWindSpeed() + ", windDirection=" + this.getWindDirection() + ", rainTotalDaily=" + this.getRainTotalDaily() + ", rainRate=" + this.getRainRate() + ")";
	}

}
