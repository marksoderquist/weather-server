package net.soderquist.mark.weather;

import java.util.HashMap;
import java.util.Map;

public class WeatherStation {

	public static final String DEGREE = "\u00B0";

	private Map<String, String> fields;

	public WeatherStation() {
		fields = new HashMap<String, String>();
	}

	public String get( String key ) {
		return fields.get( key );
	}

	public void put( String key, String value ) {
		if( value == null ) {
			fields.remove( key );
		} else {
			fields.put( key, value );
		}
	}

}
