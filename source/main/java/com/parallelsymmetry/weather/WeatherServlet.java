package com.parallelsymmetry.weather;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.parallelsymmetry.utility.log.Log;

public class WeatherServlet extends HttpServlet {

	private static final long serialVersionUID = -2358024754122910316L;

	private WeatherReader reader;

	/**
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		Log.write( Log.TRACE, "Starting Weather Reader..." );
		reader = new WeatherReader();
		reader.start();
		
		getServletContext().setAttribute( "wx-station", reader.getWeatherStation() );
		Log.write( Log.INFO, "Weather Reader started." );
	}

	/**
	 * @see javax.servlet.Servlet#destroy()
	 */
	@Override
	public void destroy() {
		Log.write( Log.TRACE, "Stopping Weather Reader..." );
		reader.stop();
		Log.write( Log.INFO, "Weather Reader stopped." );
	}

}
