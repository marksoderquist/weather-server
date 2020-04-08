import React, {Component} from 'react';
import logo from './cloud.svg';
import './app-old.css';
import packageJson from '../package.json';

class AppOld extends Component {

	componentDidMount() {
		// The initial load
		setTimeout(this.loadWeatherFromServer, 0);
		// The remaining loads
		this.refreshTimer = setInterval(this.loadWeatherFromServer, 2500);
	}

	componentWillUnmount() {
		clearInterval(this.refreshTimer);
	}

	loadWeatherFromServer = () => {
		fetchWeather((weatherFromServer) => this.setState({weather: weatherFromServer}));
	};

	render() {
		return (
			<div className="App">
				<Header/>
				<div className="content">
					<Clock/>
					<Weather/>
				</div>
			</div>
		);
	}

}

class Header extends Component {
	render() {
		return (
			<div className="App-header">
				<a href='https://www.wunderground.com/dashboard/pws/KUTRIVER9?cm_ven=localwx_pwsdash'><img src={logo} className="App-logo" alt="logo"/></a>
				<div className="App-title-box">
					<div className="App-title">Bluewing</div>
				</div>
			</div>
		);
	}
}

class Clock extends Component {

	state = {
		hh: '00',
		mm: '00',
		ss: '00',
		ap: '--'
	};

	componentDidMount() {
		setTimeout(this.updateTime, 0);
		this.refreshTimer = setInterval(this.updateTime, 1000);
	}

	componentWillUnmount() {
		clearInterval(this.refreshTimer);
	}

	updateTime = () => {
		var timestamp = new Date();
		var hh = timestamp.getHours();
		var mm = timestamp.getMinutes();
		var ss = timestamp.getSeconds();
		var ap = hh < 12 ? "am" : "pm";

		hh = hh % 12;
		hh = hh === 0 ? 12 : hh;

		//hh = pad( hh, 2 );
		mm = pad(mm, 2);
		ss = pad(ss, 2);

		this.setState({hh: hh, mm: mm, ss: ss, ap: ap});
	};

	render() {

		return (
			<div className="clock">{this.state.hh}:{this.state.mm}<span className="unit">{this.state.ap}</span></div>
		);
	}

}

class Weather extends Component {

	constructor(props) {
		super(props);
		this.state = {
			weather: {}
		}
	}

	componentDidMount() {
		// The initial load
		setTimeout(this.loadWeatherFromServer, 0);
		// The remaining loads
		this.refreshTimer = setInterval(this.loadWeatherFromServer, 5000);
	}

	componentWillUnmount() {
		clearInterval(this.refreshTimer);
	}

	loadWeatherFromServer = () => {
		fetchWeather((weatherFromServer) => this.setState({weather: weatherFromServer}));
	};

	render() {
		//console.log(JSON.stringify(this.props.weather));
		return (
			<div className="column">
				<Details/>
				<Separator/>
				<NumberField name='Temperature Trend' value={this.state.weather.temperatureTrend} unit={this.state.weather.temperatureTrendUnit} fixed='1'/>
				<NumberField name='Wind Speed Trend' value={this.state.weather.windSpeedTrend} unit={this.state.weather.windSpeedTrendUnit} fixed='1'/>
				<Separator/>
				<NumberField name='Temperature' value={this.state.weather.temperature} unit={this.state.weather.temperatureUnit} fixed='1'/>
				<NumberField name='Dew Point' value={this.state.weather.dewPoint} unit={this.state.weather.temperatureUnit} fixed='1'/>
				<NumberField name='Humidity' value={this.state.weather.humidity} unit={this.state.weather.humidityUnit}/>
				<NumberField name='Pressure' value={this.state.weather.pressure} unit={this.state.weather.pressureUnit} fixed='2'/>
				<Separator/>
				<NumberField name='Wind Speed' value={this.state.weather.windTenMinAvg} unit={this.state.weather.windSpeedUnit}/>
				<NumberField name='Wind Gusts' value={this.state.weather.windTenMinMax} unit={this.state.weather.windSpeedUnit}/>
				<NumberField name='Wind Minimum' value={this.state.weather.windTenMinMin} unit={this.state.weather.windSpeedUnit}/>
				<NumberField name='Wind Direction' value={this.state.weather.windDirectionTenMinAvg} unit={this.state.weather.windDirectionUnit}/>
				<Separator/>
				<NumberField name='Daily Rain' value={this.state.weather.rainTotalDaily} unit={this.state.weather.rainUnit} fixed='2'/>
				<NumberField name='Rain Rate' value={this.state.weather.rainRate} unit={this.state.weather.rainRateUnit} fixed='2'/>
				<Separator/>
				<Separator/>
				<NumberField name='Wind Chill' value={this.state.weather.windChill} unit={this.state.weather.temperatureUnit} fixed='1'/>
				<NumberField name='Head Index' value={this.state.weather.heatIndex} unit={this.state.weather.temperatureUnit} fixed='1'/>
				<Separator/>
				<NumberField name='Humidity Trend' value={this.state.weather.humidityTrend} unit={this.state.weather.humidityTrendUnit} fixed='1'/>
				<NumberField name='Pressure Trend' value={this.state.weather.pressureTrend} unit={this.state.weather.pressureTrendUnit} fixed='3'/>
				<Separator/>
				<NumberField name='Maximum Wind Speed (10 min)' value={this.state.weather.windTenMinMax} unit={this.state.weather.windSpeedUnit} fixed='1'/>
				<NumberField name='Average Wind Speed (10 min)' value={this.state.weather.windTenMinAvg} unit={this.state.weather.windSpeedUnit} fixed='1'/>
				<NumberField name='Minimum Wind Speed (10 min)' value={this.state.weather.windTenMinMin} unit={this.state.weather.windSpeedUnit} fixed='1'/>
				<Separator/>
				<NumberField name='Maximum Wind Speed (2 min)' value={this.state.weather.windTwoMinMax} unit={this.state.weather.windSpeedUnit} fixed='1'/>
				<NumberField name='Average Wind Speed (2 min)' value={this.state.weather.windTwoMinAvg} unit={this.state.weather.windSpeedUnit} fixed='1'/>
				<NumberField name='Minimum Wind Speed (2 min)' value={this.state.weather.windTwoMinMin} unit={this.state.weather.windSpeedUnit} fixed='1'/>
				<Separator/>
				<NumberField name='Instant Wind Speed' value={this.state.weather.windSpeed} unit={this.state.weather.windSpeedUnit}/>
				<NumberField name='Instant Wind Direction' value={this.state.weather.windDirection} unit={this.state.weather.windDirectionUnit}/>
				<Separator/>
				<NumberField name='Sun Altitude' value={this.state.weather.sunAltitude} unit={this.state.weather.sunAltitudeUnit}/>
				<Separator/>
				<StringField name='Flight Condition' value={this.state.weather.flightCondition && this.state.weather.flightCondition.summary}/>
				<StringField name='Flight Reasons' value={this.state.weather.flightCondition && this.state.weather.flightCondition.reasons}/>
				<Separator/>
				<NumberField name='Timestamp' value={this.state.weather.timestamp} unit=' ms'/>
				<StringField name='Client Version' value={packageJson.version}/>
				<StringField name='Server Version' value={this.state.weather.serverVersion}/>
			</div>
		)
	}
}

class Details extends Component {
	render() {
		return (
			<div className='details'>
				<table>
					<tbody>
					<tr>
						<th colSpan='100'>Detailed Weather Metrics</th>
					</tr>
					</tbody>
				</table>
			</div>
		)
	}
}

class NumberField extends Component {
	render() {
		return (
			<div className="weather-field">
				<div className="weather-field-prompt">{this.props.name}</div>
				<div className="weather-field-value">{parseFloat(this.props.value).toFixed(this.props.fixed)} {this.props.unit}</div>
			</div>
		);
	}
}

class StringField extends Component {
	render() {
		return (
			<div className="weather-field">
				<div className="weather-field-prompt">{this.props.name}</div>
				<div className="weather-field-value">{this.props.value}</div>
			</div>
		);
	}
}

class Separator extends Component {
	render() {
		return (
			<div className="weather-field">
				<div className="weather-field-prompt"/>
				&nbsp;</div>
		);
	}
}

function toDatestamp(time) {
	const date = new Date(time);
	const year = pad(date.getFullYear(), 4);
	const month = pad(date.getMonth() + 1, 2);
	const day = pad(date.getDate(), 2);
	const hour = pad(date.getHours() % 12, 2);
	const minute = pad(date.getMinutes(), 2);
	const second = pad(date.getSeconds(), 2);
	const ampm = isAmOrPm(date.getHours());

	//if (hour === '00') hour = '12';

	return year + '-' + month + '-' + day + ' ' + (hour === '00' ? 12 : hour) + ':' + minute + ':' + second + ' ' + ampm;
}

// Hour must be between 0 and 23
function isAmOrPm(h) {
	return h < 12 ? 'am' : 'pm';
}

function pad(n, z, p = 0) {
	n = n.toString();
	return n.length >= z ? n : new Array(z - n.length + 1).join(p) + n;
}

export default AppOld;
