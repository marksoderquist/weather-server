<%@ page language="java"%>
<%@ page import="net.soderquist.mark.weather.WeatherStation" %>

<%
WeatherStation wxstation = (WeatherStation)application.getAttribute( "wxstation" );
%>

<html>

<head>
  <title>Bluewing Weather</title>
  <meta http-equiv="expires" content="0">
  <link rel="icon" type="image/png" href="images/favicon.png"/>
  <link rel="stylesheet" type="text/css" href="style.css"/>
</head>

<body>

<h1>Bluewing Weather</h1>

<div id="wx-current">
	<div id="wx-timestamp">
		<span id="timestamp-label">Timestamp:&nbsp;<span><span id="timestamp-value"><%=wxstation.getTimestamp()%></span>
	</div>
	<div id="wx-temperature">
		<span id="temperature-label">Temperature:&nbsp;<span><span id="temperature-value"><%=wxstation.getTemperature()%></span>&nbsp;<span id="temperature-unit"><%=wxstation.getTemperatureUnit()%></span>
	</div>
	<div id="wx-humidity">
		<span id="humidity-label">Humidity:&nbsp;<span><span id="humidity-value"><%=wxstation.getHumidity()%></span>&nbsp;<span id="humidity"><%=wxstation.getHumidityUnit()%></span>
	</div>
	<div id="wx-pressure">
		<span id="pressure-label">Pressure:&nbsp;<span><span id="pressure-value"><%=wxstation.getPressure()%></span>&nbsp;<span id="pressure-unit"><%=wxstation.getPressureUnit()%></span>
	</div>
	<div id="wx-wind-direction">
		<span id="wind-direction-label">Wind Direction:&nbsp;<span><span id="wind-direction-value"><%=wxstation.getWindDirection()%></span>&nbsp;<span id="wind-direction-unit"><%=wxstation.getWindDirectionUnit()%></span>
	</div>
	<div id="wx-wind-instant">
		<span id="wind-instant-label">Wind Instant Speed:&nbsp;<span><span id="wind-instant-value"><%=wxstation.getWindInstant()%></span>&nbsp;<span id="wind-instant-unit"><%=wxstation.getWindUnit()%></span>
	</div>
	<div id="wx-wind-sustain">
		<span id="wind-sustain-label">Wind Sustain Speed:&nbsp;<span><span id="wind-sustain-value"><%=wxstation.getWindSustain()%></span>&nbsp;<span id="wind-sustain-unit"><%=wxstation.getWindUnit()%></span>
	</div>
	<div id="wx-rain-rate">
		<span id="rain-rate-label">Rain Rate:&nbsp;<span><span id="rain-rate-value"><%=wxstation.getRainRate()%></span>&nbsp;<span id="rain-rate-unit"><%=wxstation.getRainRateUnit()%></span>
	</div>
	<div id="wx-rain-total-daily">
		<span id="rain-total-daily-label">Rain Total Daily:&nbsp;<span><span id="rain-total-daily-value"><%=wxstation.getRainTotalDaily()%></span>&nbsp;<span id="rain-total-daily-unit"><%=wxstation.getRainTotalDailyUnit()%></span>
	</div>
</div>

</body>

</html>
