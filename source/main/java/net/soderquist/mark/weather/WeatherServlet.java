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

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

	private WeatherStation station;

	/**
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		Log.write(Log.TRACE, "Starting Weather Reader...");

		station = new WeatherStation();
		getServletContext().setAttribute("wxstation", station);

		Log.write(Log.INFO, "Weather Reader started.");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Call this method with:
		// http://<host>[:<port>]/<context>/station/put?id=21&t=42.1&h=57&p=29.92

		// Log.write( "Station ID: ", request.getParameter( "id" ) );
		// Log.write( "Timestamp: ", request.getParameter( "ts" ) );
		// Log.write( "Temperature: ", request.getParameter( "t" ) );
		// Log.write( "Humidity: ", request.getParameter( "h" ) );
		// Log.write( "Pressure: ", request.getParameter( "p" ) );
		// Log.write( "Wind direction: ", request.getParameter( "wd" ) );
		// Log.write( "Wind instant: ", request.getParameter( "wi" ) );
		// Log.write( "Wind sustain: ", request.getParameter( "ws" ) );
		// Log.write( "Rain rate: ", request.getParameter( "rr" ) );
		// Log.write( "Rain total daily: ", request.getParameter( "rd" ) );

		Date timestamp = null;
		String timestampValue = request.getParameter("ts");
		if (timestampValue != null) timestamp = new Date(Long.parseLong(timestampValue));
		station.put("timestamp", timestamp == null ? null : DATE_FORMAT.format(timestamp));

		station.put("temperature", request.getParameter("t"));
		station.put("temperature-unit", WeatherStation.DEGREE + "F");

		station.put("humidity", request.getParameter("h"));
		station.put("humidity-unit", "%");

		station.put("pressure", request.getParameter("p"));
		station.put("pressure-unit", "inHg");

		station.put("wind-direction", request.getParameter("wd"));
		station.put("wind-direction-unit", WeatherStation.DEGREE);

		station.put("wind-current", request.getParameter("wi"));
		station.put("wind-10-min-max", request.getParameter("wmax10"));
		station.put("wind-10-min-avg", request.getParameter("wavg10"));
		station.put("wind-10-min-min", request.getParameter("wmin10"));
		station.put("wind-2-min-max", request.getParameter("wmax2"));
		station.put("wind-2-min-avg", request.getParameter("wavg2"));
		station.put("wind-2-min-min", request.getParameter("wmin2"));
		station.put("wind-unit", "mph");

		station.put("rain-total-daily", request.getParameter("rd"));
		station.put("rain-total-daily-unit", "in");

		station.put("rain-rate", request.getParameter("rr"));
		station.put("rain-rate-unit", "in/hr");
	}

	/**
	 * @see javax.servlet.Servlet#destroy()
	 */
	@Override
	public void destroy() {
		Log.write(Log.TRACE, "Stopping Weather Reader...");
		Log.write(Log.INFO, "Weather Reader stopped.");
	}

}
