package com.parallelsymmetry.weather;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.measure.Measure;

import com.parallelsymmetry.utility.log.Log;

public class WeatherStation implements WeatherDataListener {

	//	Log.write( "Bar: ", TextUtil.toPrintableString( buffer, 7, 2 ), " ", bar );
	//	Log.write( "Bar trend: ", TextUtil.toPrintableString( buffer, 3, 1 ), " ", barTrend.name() );
	//	Log.write( "Temp in: ", TextUtil.toPrintableString( buffer, 9, 2 ), " ", tempInside );
	//	Log.write( "Humid in: ", TextUtil.toPrintableString( buffer, 1, 1 ), " ", humidInside + "%" );
	//	Log.write( "Temp out: ", TextUtil.toPrintableString( buffer, 12, 2 ), " ", tempOutside );
	//	Log.write( "Wind speed: ", TextUtil.toPrintableString( buffer, 14, 1 ), " ", windSpeed );
	//	Log.write( "Wind speed 10 min. avg.: ", TextUtil.toPrintableString( buffer, 15, 1 ), " ", windSpeedTenMinAvg );
	//	Log.write( "Wind direction: ", TextUtil.toPrintableString( buffer, 16, 2 ), " ", windDirection );
	//
	//	Log.write( "Humid out: ", TextUtil.toPrintableString( buffer, 33, 1 ), " ", humidOutside );
	//	Log.write( "Rain rate: ", TextUtil.toPrintableString( buffer, 41, 2 ), " ", rainRate );

	private Map<WeatherDatumIdentifier, Measure<?, ?>> data;

	public WeatherStation() {
		data = new ConcurrentHashMap<WeatherDatumIdentifier, Measure<?, ?>>();
	}

	public Measure<?, ?> getMeasure( WeatherDatumIdentifier datum ) {
		return data.get( datum );
	}

	public float getTemperature() {
		Measure<?, ?> measure = getMeasure( WeatherDatumIdentifier.TEMPERATURE );
		if( measure == null ) return Float.NaN;
		return ( (Float)measure.getValue() ).floatValue();
	}

	@Override
	public void weatherDataEvent( WeatherDataEvent event ) {
		Log.write();
		Log.write( "Timestamp:", event.getTimestamp() );
		for( WeatherDatum datum : event.getData() ) {
			data.put( datum.getIdentifier(), datum.getMeasure() );

			//			Float value = (Float)datum.getMeasure().getValue();
			//			if( value.isNaN() ) {
			//				Log.write( Log.WARN, datum );
			//			} else {
			//				Log.write( datum );
			//			}
		}

		printValues();
	}

	private void printValues() {
		Log.write( "Temperature: ", getTemperature() );
	}

}
