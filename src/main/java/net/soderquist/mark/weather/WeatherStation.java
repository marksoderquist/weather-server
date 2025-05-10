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

	private static final String DEGREE = "°";

	// Weather station

	@Getter
	@Setter
	private String id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private double latitude;

	@Getter
	@Setter
	private double longitude;

	@Getter
	@Setter
	private String serverVersion;

	@Getter
	@Setter
	private long timestamp;

	@Getter
	@Setter
	private TimeZone timeZone = TimeZone.getTimeZone( "America/Denver" );

	@Getter
	@Setter
	private UnitSystem unitSystem;

	// Weather basics

	@Getter
	@Setter
	private double temperature;

	@Getter
	@Setter
	private double pressure;

	@Getter
	@Setter
	private double humidity;

	@Getter
	@Setter
	private double dewPoint;

	@Getter
	@Setter
	private double windChill;

	@Getter
	@Setter
	private double heatIndex;

	@Getter
	@Setter
	private double feelsLike;

	@Getter
	@Setter
	private double windSpeed;

	@Getter
	private double windDirection;

	@Getter
	private Cardinal windCardinal;

	@Getter
	@Setter
	private double rainTotalDaily;

	@Getter
	@Setter
	private double rainRate;

	@Getter
	@Setter
	private double temperatureTrend;

	@Getter
	@Setter
	private double humidityTrend;

	@Getter
	@Setter
	private double pressureTrend;

	@Getter
	@Setter
	private double windSpeedTrend;

	@Getter
	@Setter
	private double windTenMinMax;

	@Getter
	@Setter
	private double windTenMinAvg;

	@Getter
	@Setter
	private double windTenMinMin;

	@Getter
	@Setter
	private double windTwoMinMax;

	@Getter
	@Setter
	private double windTwoMinAvg;

	@Getter
	@Setter
	private double windTwoMinMin;

	@Getter
	private double windDirectionTenMinAvg;

	@Getter
	private Cardinal windCardinalTenMinAvg;

	@Getter
	private double windDirectionTwoMinAvg;

	@Getter
	private Cardinal windCardinalTwoMinAvg;

	@Getter
	@Setter
	private double sunAltitude;

	@Getter
	@Setter
	private double sunIllumination;

	// Unit values.
	@Getter
	@Setter
	private String temperatureUnit = DEGREE + "F";

	@Getter
	@Setter
	private String humidityUnit = "%";

	@Getter
	@Setter
	private String pressureUnit = "in";

	@Getter
	@Setter
	private String windSpeedUnit = "mph";

	@Getter
	@Setter
	private String windDirectionUnit = DEGREE;

	@Getter
	@Setter
	private String rainUnit = "in";

	@Getter
	@Setter
	private String trendUnit = "/hr";

	@Getter
	@Setter
	private String rainRateUnit = rainUnit + "/hr";

	@Getter
	@Setter
	private String temperatureTrendUnit = temperatureUnit + "/hr";

	@Getter
	@Setter
	private String humidityTrendUnit = humidityUnit + "/hr";

	@Getter
	@Setter
	private String pressureTrendUnit = pressureUnit + "/hr";

	@Getter
	@Setter
	private String windSpeedTrendUnit = windSpeedUnit + "/hr";

	@Getter
	@Setter
	private String sunAltitudeUnit = DEGREE;

	@Getter
	@Setter
	private String sunIlluminationUnit = "%";

	@Getter
	@Setter
	private FlightCondition flightCondition;

	public WeatherStation( String id, String name, double latitude, double longitude, UnitSystem unitSystem ) {
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.unitSystem = unitSystem;
		this.flightCondition = new FlightCondition();
	}

	public void setWindDirection( double windDirection ) {
		this.windDirection = windDirection;
		this.windCardinal = Cardinal.toCardinal( windDirection );
	}

	public void setWindDirectionTenMinAvg( double windDirectionTenMinAvg ) {
		this.windDirectionTenMinAvg = windDirectionTenMinAvg;
		this.windCardinalTenMinAvg = Cardinal.toCardinal( windDirectionTenMinAvg );
	}

	public void setWindDirectionTwoMinAvg( double windDirectionTwoMinAvg ) {
		this.windDirectionTwoMinAvg = windDirectionTwoMinAvg;
		this.windCardinalTwoMinAvg = Cardinal.toCardinal( windDirectionTwoMinAvg );
	}

	/**
	 * Copy values from another weather station.
	 *
	 * @param that The other weather station to copy from.
	 */
	public void copyFrom( WeatherStation that ) {
		this.setTimestamp( that.getTimestamp() );

		double feelsLike = calcFeelsLikeFahrenheit( that.getTemperature(), that.getWindTenMinAvg(), that.getHumidity() );

		// basics
		this.setTemperature( convertTemperature( that, that.getTemperature() ) );
		this.setPressure( convertPressure( that, that.getPressure() ) );
		this.setHumidity( convertHumidity( that, that.getHumidity() ) );
		this.setDewPoint( convertTemperature( that, that.getDewPoint() ) );
		this.setWindChill( convertTemperature( that, that.getWindChill() ) );
		this.setHeatIndex( convertTemperature( that, that.getHeatIndex() ) );
		this.setFeelsLike( convertTemperature( that, feelsLike ) );
		this.setWindSpeed( convertSpeed( that, that.getWindSpeed() ) );
		this.setWindDirection( convertDirection( that, that.getWindDirection() ) );
		this.setRainTotalDaily( convertRainfall( that, that.getRainTotalDaily() ) );
		this.setRainRate( convertRainfall( that, that.getRainRate() ) );

		// trends
		this.setTemperatureTrend( convertTemperatureRate( that, that.getTemperatureTrend() ) );
		this.setHumidityTrend( convertHumidity( that, that.getHumidityTrend() ) );
		this.setPressureTrend( convertPressure( that, that.getPressureTrend() ) );
		this.setWindSpeedTrend( convertSpeed( that, that.getWindSpeedTrend() ) );

		// wind
		this.setWindTenMinMax( convertSpeed( that, that.getWindTenMinMax() ) );
		this.setWindTenMinAvg( convertSpeed( that, that.getWindTenMinAvg() ) );
		this.setWindTenMinMin( convertSpeed( that, that.getWindTenMinMin() ) );
		this.setWindTwoMinMax( convertSpeed( that, that.getWindTwoMinMax() ) );
		this.setWindTwoMinAvg( convertSpeed( that, that.getWindTwoMinAvg() ) );
		this.setWindTwoMinMin( convertSpeed( that, that.getWindTwoMinMin() ) );
		this.setWindDirectionTenMinAvg( convertDirection( that, that.getWindDirectionTenMinAvg() ) );
		this.setWindDirectionTwoMinAvg( convertDirection( that, that.getWindDirectionTwoMinAvg() ) );

		// units
		this.setTemperatureUnit( this.getUnitSystem().getTemperatureUnit().getSymbol() );
		this.setHumidityUnit( this.getUnitSystem().getHumidityUnit().getSymbol() );
		this.setPressureUnit( this.getUnitSystem().getPressureUnit().getSymbol() );
		this.setWindSpeedUnit( this.getUnitSystem().getSpeedUnit().getSymbol() );
		this.setWindDirectionUnit( this.getUnitSystem().getDirectionUnit().getSymbol() );
		this.setRainUnit( this.getUnitSystem().getRainfallUnit().getSymbol() );
		this.setRainRateUnit( getRainUnit() + trendUnit );
		this.setTemperatureTrendUnit( getTemperatureUnit() + trendUnit );
		this.setHumidityTrendUnit( getHumidityUnit() + trendUnit );
		this.setPressureTrendUnit( that.getPressureUnit() + trendUnit );
		this.setWindSpeedTrendUnit( that.getWindSpeedUnit() + trendUnit );

		// Using the sun altitude, calculate an illumination value
		// Civil twilight is -6 degrees (https://en.wikipedia.org/wiki/Twilight)
		SunPosition position = SunPosition.compute().on( new Date() ).at( latitude, longitude ).execute();
		double sunAltitude = position.getTrueAltitude();
		this.setSunAltitude( sunAltitude );
		this.setSunIllumination( sunAltitude <= 0 ? 0 : Math.sin( Math.toRadians( sunAltitude ) ) * 100 );

		updateFlyingConditions();
	}

	private double convertTemperature( WeatherStation that, double temperature ) {
		return that.getUnitSystem().getTemperatureUnit().convert( temperature, this.getUnitSystem().getTemperatureUnit() );
	}

	private double convertTemperatureRate( WeatherStation that, double temperature ) {
		return that.getUnitSystem().getTemperatureUnit().convertRate( temperature, this.getUnitSystem().getTemperatureUnit() );
	}

	private double convertPressure( WeatherStation that, double pressure ) {
		return that.getUnitSystem().getPressureUnit().convert( pressure, this.getUnitSystem().getPressureUnit() );
	}

	private double convertHumidity( WeatherStation that, double humidity ) {
		return that.getUnitSystem().getHumidityUnit().convert( humidity, this.getUnitSystem().getHumidityUnit() );
	}

	private double convertSpeed( WeatherStation that, double speed ) {
		return that.getUnitSystem().getSpeedUnit().convert( speed, this.getUnitSystem().getSpeedUnit() );
	}

	private double convertDirection( WeatherStation that, double direction ) {
		return that.getUnitSystem().getDirectionUnit().convert( direction, this.getUnitSystem().getDirectionUnit() );
	}

	private double convertRainfall( WeatherStation that, double rain ) {
		return that.getUnitSystem().getRainfallUnit().convert( rain, this.getUnitSystem().getRainfallUnit() );
	}

	static double calcFeelsLikeFahrenheit( double temperature, double wind, double humidity ) {
		if( temperature < 50 ) return calculateWindChill( temperature, wind );
		if( temperature > 80 ) return calculateHeatIndex( temperature, humidity );
		return temperature;
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

	void updateFlyingConditions() {
		Calendar calendar = Calendar.getInstance( getTimeZone() );

		getFlightCondition().reset();
		if( getUnitSystem() == UnitSystem.METRIC ) {
			updateFlyingConditionsMetric();
		} else {
			updateFlyingConditionsImperial();
		}

		double sun = getSunAltitude();
		boolean isPm = calendar.get( Calendar.AM_PM ) == Calendar.PM;
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

	private void updateFlyingConditionsMetric() {
		double temperature = getTemperature();
		if( temperature >= 35 ) {
			updateFlightCondition( FlightCondition.Summary.HOLD, FlightCondition.Reason.HOT );
		} else if( temperature < 35 && temperature >= 30 ) {
			updateFlightCondition( FlightCondition.Summary.POOR, FlightCondition.Reason.HOT );
		} else if( temperature < 30 && temperature >= 25 ) {
			updateFlightCondition( FlightCondition.Summary.FAIR, FlightCondition.Reason.HOT );
		} else if( temperature < 25 && temperature >= 20 ) {
			updateFlightCondition( FlightCondition.Summary.GOOD, FlightCondition.Reason.WARM );
		} else if( temperature < 20 && temperature >= 15 ) {
			updateFlightCondition( FlightCondition.Summary.GREAT );
		} else if( temperature < 15 && temperature >= 10 ) {
			updateFlightCondition( FlightCondition.Summary.GOOD, FlightCondition.Reason.COOL );
		} else if( temperature < 10 && temperature >= 5 ) {
			updateFlightCondition( FlightCondition.Summary.FAIR, FlightCondition.Reason.COLD );
		} else if( temperature < 5 && temperature >= 0 ) {
			updateFlightCondition( FlightCondition.Summary.POOR, FlightCondition.Reason.COLD );
		} else if( temperature < 0 ) {
			updateFlightCondition( FlightCondition.Summary.HOLD, FlightCondition.Reason.COLD );
		}

		double wind = getWindTwoMinAvg();
		double gust = getWindTwoMinMax();

		if( wind >= 40 ) {
			updateFlightCondition( FlightCondition.Summary.HOLD, FlightCondition.Reason.WINDY );
		} else if( wind >= 30 ) {
			updateFlightCondition( FlightCondition.Summary.POOR, FlightCondition.Reason.WINDY );
		} else if( wind >= 20 ) {
			updateFlightCondition( FlightCondition.Summary.FAIR, FlightCondition.Reason.BREEZY );
		} else if( wind >= 10 ) {
			updateFlightCondition( FlightCondition.Summary.GOOD, FlightCondition.Reason.BREEZY );
		} // otherwise GREAT

		//		if( gust >= 50 ) {
		//			updateFlightCondition( FlightCondition.Summary.HOLD, FlightCondition.Reason.GUSTY );
		//		} else if( gust >= 40 ) {
		//			updateFlightCondition( FlightCondition.Summary.POOR, FlightCondition.Reason.GUSTY );
		//		} else if( gust >= 30 ) {
		//			updateFlightCondition( FlightCondition.Summary.FAIR, FlightCondition.Reason.BUMPY );
		//		} else if( gust >= 20 ) {
		//			updateFlightCondition( FlightCondition.Summary.GOOD, FlightCondition.Reason.BUMPY );
		//		} // otherwise GREAT

	}

	private void updateFlyingConditionsImperial() {
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
		double gust = getWindTenMinMax();

		if( wind >= 25 ) {
			updateFlightCondition( FlightCondition.Summary.HOLD, FlightCondition.Reason.WINDY );
		} else if( wind >= 19 ) {
			updateFlightCondition( FlightCondition.Summary.POOR, FlightCondition.Reason.WINDY );
		} else if( wind >= 13 ) {
			updateFlightCondition( FlightCondition.Summary.FAIR, FlightCondition.Reason.BREEZY );
		} else if( wind >= 6 ) {
			updateFlightCondition( FlightCondition.Summary.GOOD, FlightCondition.Reason.BREEZY );
		} // otherwise GREAT

//		if( gust >= 31 ) {
//			updateFlightCondition( FlightCondition.Summary.HOLD, FlightCondition.Reason.GUSTY );
//		} else if( gust >= 25 ) {
//			updateFlightCondition( FlightCondition.Summary.POOR, FlightCondition.Reason.GUSTY );
//		} else if( gust >= 19 ) {
//			updateFlightCondition( FlightCondition.Summary.FAIR, FlightCondition.Reason.BUMPY );
//		} else if( gust >= 13 ) {
//			updateFlightCondition( FlightCondition.Summary.GOOD, FlightCondition.Reason.BUMPY );
//		} // otherwise GREAT
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
