<%@ page language="java"%>

<jsp:useBean id="wxstation" scope="application" class="com.parallelsymmetry.weather.WeatherStation"/>
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
	<div id="wx-temperature">
		<span id="temperature-label">Temperature:<span><span id="temperature-fahrenheit"><%=wxstation.getTemperature()%></span><span id="temperature-unit">&deg;F</span>
	</div>
</div>

</body>

</html>
