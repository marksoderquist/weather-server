package net.soderquist.mark.weather;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parallelsymmetry.utility.log.Log;

public class WeatherServlet extends HttpServlet {

	private static final long serialVersionUID = -2358024754122910316L;

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss a" );

	private WeatherStation station;

	/**
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		Log.write( Log.TRACE, "Starting Weather Reader..." );

		station = new WeatherStation();
		station.put( "temperature-unit", WeatherStation.DEGREE + "F" );
		station.put( "humidity-unit", "%" );
		station.put( "pressure-unit", "inHg" );
		station.put( "pressure-trend-unit", "inHg/hr" );
		station.put( "wind-direction-unit", WeatherStation.DEGREE );
		station.put( "wind-unit", "mph" );
		station.put( "rain-total-daily-unit", "in" );
		station.put( "rain-rate-unit", "in/hr" );

		getServletContext().setAttribute( "wxstation", station );

		Log.write( Log.INFO, "Weather Reader started." );
	}

	@Override
	protected void doPut( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		Properties properties = new Properties();
		properties.load( request.getInputStream() );

		// Store all the values.
		for( Object key : properties.keySet() ) {
			station.put( key.toString(), properties.get( key ).toString() );
		}

		// Reformat the timestamp.
		station.put( "timestamp", DATE_FORMAT.format( new Date( Long.parseLong( properties.getProperty( "timestamp" ) ) ) ) );
	}

	/**
	 * @see javax.servlet.Servlet#destroy()
	 */
	@Override
	public void destroy() {
		Log.write( Log.TRACE, "Stopping Weather Reader..." );
		Log.write( Log.INFO, "Weather Reader stopped." );
	}

}
