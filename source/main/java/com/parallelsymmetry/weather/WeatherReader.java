package com.parallelsymmetry.weather;

import com.parallelsymmetry.utility.agent.Agent;

public class WeatherReader extends Agent {

	private WeatherStation station;

	private DavisReader reader;

	public static final void main( String[] commands ) {
		new WeatherReader().start();
	}

	public WeatherReader() {
		station = new WeatherStation();
		reader = new DavisReader();
		reader.addWeatherDataListener( station );
	}
	
	public WeatherStation getWeatherStation() {
		return station;
	}

	@Override
	protected void startAgent() throws Exception {
		reader.start();
	}

	@Override
	protected void stopAgent() throws Exception {
		reader.stop();
	}

}
