package net.soderquist.mark.weather;

import java.io.IOException;

public class PerformPublisher extends HttpPublisher {

	private static final String VBIT = "vbit";
	private static final String MEM = "mem";

	public int publish( WeatherStation station ) throws IOException {
		return rest( "GET", generateRequest( station ) ).getCode();
	}

	String generateRequest( WeatherStation station ) {
		String stationId = "39";
		String accessKey = "b8f4c216-c54f-4c2f-bc33-5ab120accca3";
		StringBuilder builder = new StringBuilder( "https://perform.southbranchcontrols.com" );
		builder.append( "/api/stations/" ).append( stationId ).append( "/data/feed" );
		builder.append( "?accesskey=" ).append( accessKey );

		// Need to send online flag VBIT-0
		builder.append( add( VBIT, 0, 1 ) );

		// Timestamp
		builder.append( add( MEM, 0, station.getTimestamp() ) );

		// Basic data
		builder.append( add( MEM, 10, station.getTemperature() ) );
		builder.append( add( MEM, 11, station.getPressure() ) );
		builder.append( add( MEM, 12, station.getHumidity() ) );
		builder.append( add( MEM, 13, station.getDewPoint() ) );

		builder.append( add( MEM, 15, station.getWindChill() ) );
		builder.append( add( MEM, 16, station.getHeatIndex() ) );

		// Wind data
		builder.append( add( MEM, 20, station.getWindSpeed() ) );
		builder.append( add( MEM, 21, station.getWindDirection() ) );

		// Wind 2-min averaged
		builder.append( add( MEM, 30, station.getWindTwoMinAvg() ) );
		builder.append( add( MEM, 31, station.getWindDirectionTwoMinAvg() ) );
		builder.append( add( MEM, 32, station.getWindTwoMinMax() ) );
		builder.append( add( MEM, 33, station.getWindTwoMinMin() ) );

		// Wind 10-min averaged
		builder.append( add( MEM, 40, station.getWindTenMinAvg() ) );
		builder.append( add( MEM, 41, station.getWindDirectionTenMinAvg() ) );
		builder.append( add( MEM, 42, station.getWindTenMinMax() ) );
		builder.append( add( MEM, 43, station.getWindTenMinMin() ) );

		builder.append( add( MEM, 50, station.getRainRate() ) );
		builder.append( add( MEM, 51, station.getRainTotalDaily() ) );

		builder.append( add( MEM, 110, station.getTemperatureTrend() ) );
		builder.append( add( MEM, 111, station.getPressureTrend() ) );
		builder.append( add( MEM, 112, station.getHumidityTrend() ) );
		builder.append( add( MEM, 120, station.getWindSpeedTrend() ) );
		//builder.append( add( MEM, 121, station.getWindDirectionTrend() ) );

		return builder.toString();
	}

	private String add( String type, int address, long value ) {
		return "&" + type + "-" + address + "=" + value;
	}

	private String add( String type, int address, double value ) {
		return add( type, address, Double.doubleToLongBits( value ) );
	}

	//	private void addLong( WeatherDataEvent event, StringBuilder builder, WeatherDatumIdentifier identifier, String key ) {
	//		Long value = event.getValue( identifier );
	//		if( value == null ) return;
	//
	//		builder.append( "&" );
	//		builder.append( key );
	//		builder.append( "=" );
	//		builder.append( value );
	//	}
	//
	//	private void addDouble( WeatherDataEvent event, StringBuilder builder, WeatherDatumIdentifier identifier, String key ) {
	//		Double value = event.getValue( identifier );
	//		if( value == null ) return;
	//
	//		builder.append( "&" );
	//		builder.append( key );
	//		builder.append( "=" );
	//		builder.append( Double.doubleToLongBits( value ) );
	//	}

}
