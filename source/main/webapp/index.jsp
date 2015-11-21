<%@ page language="java"%>
<%@ page import="net.soderquist.mark.weather.WeatherStation"%>

<%
	WeatherStation wxstation = (WeatherStation) application.getAttribute("wxstation");
%>

<html>

<head>
<title>Bluewing Weather</title>
<meta http-equiv="expires" content="0">
<meta http-equiv="refresh" content="5">
<link rel="icon" type="image/png" href="images/favicon.png" />
<link rel="stylesheet" type="text/css" href="style.css" />
</head>

<body>

	<div id="wx-current-new">
		<table id="wx-table">
			<colgroup>
				<col width="20%">
				<col width="10%">
				<col width="40%">
				<col width="10%">
				<col width="20%">
			</colgroup>
			<tr>
				<td colspan="2"><h1>Bluewing Weather</h1></td>
				<td></td>
				<td colspan="2"><%=wxstation.get("timestamp")%></td>
			</tr>
			<tr>
				<td>Temperature:</td>
				<td><%=wxstation.get("temperature")%> <%=wxstation.get("temperature-unit")%></td>
				<td></td>
				<td>Wind Speed:</td>
				<td><%=wxstation.get("wind-current")%> <%=wxstation.get("wind-unit")%></td>
			</tr>
			<tr>
				<td>Relative Humidity:</td>
				<td><%=wxstation.get("humidity")%> <%=wxstation.get("humidity-unit")%></td>
				<td></td>
				<td>Wind Direction:</td>
				<td><%=wxstation.get("wind-direction")%> <%=wxstation.get("wind-direction-unit")%></td>
			</tr>
			<tr>
				<td>Air Pressure:</td>
				<td><%=wxstation.get("pressure")%> <%=wxstation.get("pressure-unit")%></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>Wind 10 min. Maximum:</td>
				<td><%=wxstation.get("wind-10-min-max")%> <%=wxstation.get("wind-unit")%></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>Wind 10 min. Average:</td>
				<td><%=wxstation.get("wind-10-min-avg")%> <%=wxstation.get("wind-unit")%></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>Wind 10 min. Minimum:</td>
				<td><%=wxstation.get("wind-10-min-min")%> <%=wxstation.get("wind-unit")%></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>Wind 2 min. Maximum:</td>
				<td><%=wxstation.get("wind-2-min-max")%> <%=wxstation.get("wind-unit")%></td>
			</tr>
			<tr>
				<td>Rain Total Daily:</td>
				<td><%=wxstation.get("rain-total-daily")%> <%=wxstation.get("rain-total-daily-unit")%></td>
				<td></td>
				<td>Wind 2 min. Average:</td>
				<td><%=wxstation.get("wind-2-min-avg")%> <%=wxstation.get("wind-unit")%></td>
			</tr>
			<tr>
				<td>Rain Rate:</td>
				<td><%=wxstation.get("rain-rate")%> <%=wxstation.get("rain-rate-unit")%></td>
				<td></td>
				<td>Wind 2 min. Minimum:</td>
				<td><%=wxstation.get("wind-2-min-min")%> <%=wxstation.get("wind-unit")%></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>

</body>

</html>
