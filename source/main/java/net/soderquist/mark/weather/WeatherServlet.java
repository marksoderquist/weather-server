package net.soderquist.mark.weather;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		getServletContext().setAttribute( "wxstation", station );

		Log.write( Log.INFO, "Weather Reader started." );
	}

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// Call this method with:
		// http://<host>[:<port>]/<context>/station/put?id=21&t=42.1&h=57&p=29.92

		//		Log.write( "Station ID: ", request.getParameter( "id" ) );
		//		Log.write( "Timestamp: ", request.getParameter( "ts" ) );
		//		Log.write( "Temperature: ", request.getParameter( "t" ) );
		//		Log.write( "Humidity: ", request.getParameter( "h" ) );
		//		Log.write( "Pressure: ", request.getParameter( "p" ) );
		//		Log.write( "Wind direction: ", request.getParameter( "wd" ) );
		//		Log.write( "Wind instant: ", request.getParameter( "wi" ) );
		//		Log.write( "Wind sustain: ", request.getParameter( "ws" ) );
		//		Log.write( "Rain rate: ", request.getParameter( "rr" ) );
		//		Log.write( "Rain total daily: ", request.getParameter( "rd" ) );

		Date timestamp = null;
		String timestampValue = request.getParameter( "ts" );
		if( timestampValue != null ) timestamp = new Date( Long.parseLong( timestampValue ) );
		station.setTimestamp( timestamp == null ? null : DATE_FORMAT.format( timestamp ) );

		station.setTemperature( request.getParameter( "t" ) );
		station.setTemperatureUnit( WeatherStation.DEGREE + "F" );

		station.setHumidity( request.getParameter( "h" ) );
		station.setHumidityUnit( "%" );

		station.setPressure( request.getParameter( "p" ) );
		station.setPressureUnit( "inHg" );

		station.setWindDirection( request.getParameter( "wd" ) );
		station.setWindDirectionUnit( WeatherStation.DEGREE );

		station.setWindInstant( request.getParameter( "wi" ) );
		station.setWind2MinMin( request.getParameter( "wmin2" ) );
		station.setWind2MinAverage( request.getParameter( "wavg2" ) );
		station.setWind2MinMax( request.getParameter( "wmax2" ) );
		station.setWind10MinMin( request.getParameter( "wmin10" ) );
		station.setWind10MinAverage( request.getParameter( "wavg10" ) );
		station.setWind10MinMax( request.getParameter( "wmax10" ) );
		station.setWindUnit( "mph" );

		station.setRainRate( request.getParameter( "rr" ) );
		station.setRainRateUnit( "in/hr" );

		station.setRainTotalDaily( request.getParameter( "rd" ) );
		station.setRainTotalDailyUnit( "in" );
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
