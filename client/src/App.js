import React, {Component} from 'react';
import logo from './cloud.svg';
import './App.css';

function fetchWeather(success) {
    return fetch('http://mark.soderquist.net/weather/api/station?id=bluewing', {
        headers: {
            Accept: 'application/json',
        },
    })
        .then(checkStatus)
        .then(parseJSON)
        .then(success);
}

function checkStatus(response) {
    if (response.status >= 200 && response.status < 300) {
        return response;
    } else {
        const error = new Error(`HTTP Error ${response.statusText}`);
        error.status = response.statusText;
        error.response = response;
        console.log(error);
        throw error;
    }
}

function parseJSON(response) {
    return response.json();
}

class App extends Component {

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
                <Header title={this.state.weather.name} timestamp={this.state.weather.timestamp}/>
                <Body weather={this.state.weather}/>
            </div>
        );
    }
}

class Header extends Component {
    render() {
        return (
            <div className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <div>
                    <div className="App-title">{this.props.title}</div>
                    <div>{toDatestamp(this.props.timestamp)}</div>
                    <div><a href="https://www.wunderground.com/weather/us/ut/riverton/KUTRIVER9">Weather Underground</a></div>
                </div>
            </div>
        );
    }
}

class Body extends Component {
    render() {
        return (
            <div className="content">
                <div className="column">
                    <div className="temperature">{parseFloat(this.props.weather.temperature).toFixed(1)}<span className="tempunit">{this.props.weather.temperatureUnit}</span></div>
                    <div className="wind">
                        <table>
                            <tr>
                                <td class="label">wind&nbsp;</td>
                                <td class="value">&nbsp;{parseFloat(this.props.weather.windTenMinAvg).toFixed(1)}</td>
                                <td class="unit">&nbsp;{this.props.weather.windSpeedUnit}</td>
                            </tr>
                            <tr>
                                <td class="label">gust&nbsp;</td>
                                <td class="value">&nbsp;{parseFloat(this.props.weather.windTenMinMax).toFixed(1)}</td>
                                <td class="unit">&nbsp;{this.props.weather.windSpeedUnit}</td>
                            </tr>
                            <tr>
                                <td className="label">from&nbsp;</td>
                                <td className="value">&nbsp;{this.props.weather.windCardinalTenMinAvg}</td>
                                <td className="unit">&nbsp;{parseFloat(this.props.weather.windDirectionTenMinAvg).toFixed(0)}{this.props.weather.windDirectionUnit}</td>
                            </tr>
                        </table>
                    </div>
                    <Separator/>
                    <NumberField name='Temperature Trend' value={this.props.weather.temperatureTrend} unit={this.props.weather.temperatureTrendUnit} fixed='1'/>
                    <NumberField name='Wind Speed Trend' value={this.props.weather.windSpeedTrend} unit={this.props.weather.windSpeedTrendUnit} fixed='1'/>
                    <Separator/>
                    <NumberField name='Temperature' value={this.props.weather.temperature} unit={this.props.weather.temperatureUnit} fixed='1'/>
                    <NumberField name='Dew Point' value={this.props.weather.dewPoint} unit={this.props.weather.temperatureUnit} fixed='1'/>
                    <NumberField name='Humidity' value={this.props.weather.humidity} unit={this.props.weather.humidityUnit}/>
                    <NumberField name='Pressure' value={this.props.weather.pressure} unit={this.props.weather.pressureUnit} fixed='2'/>
                    <Separator/>
                    <NumberField name='Wind Speed' value={this.props.weather.windTenMinAvg} unit={this.props.weather.windSpeedUnit}/>
                    <NumberField name='Wind Gusts' value={this.props.weather.windTenMinMax} unit={this.props.weather.windSpeedUnit}/>
                    <NumberField name='Wind Minimum' value={this.props.weather.windTenMinMin} unit={this.props.weather.windSpeedUnit}/>
                    <NumberField name='Wind Direction' value={this.props.weather.windDirectionTenMinAvg} unit={this.props.weather.windDirectionUnit}/>
                    <Separator/>
                    <NumberField name='Daily Rain' value={this.props.weather.rainTotalDaily} unit={this.props.weather.rainUnit} fixed='2'/>
                    <NumberField name='Rain Rate' value={this.props.weather.rainRate} unit={this.props.weather.rainRateUnit} fixed='2'/>
                    <Separator/>
                    <Separator/>
                    <NumberField name='Wind Chill' value={this.props.weather.windChill} unit={this.props.weather.temperatureUnit} fixed='1'/>
                    <NumberField name='Head Index' value={this.props.weather.heatIndex} unit={this.props.weather.temperatureUnit} fixed='1'/>
                    <Separator/>
                    <NumberField name='Humidity Trend' value={this.props.weather.humidityTrend} unit={this.props.weather.humidityTrendUnit} fixed='1'/>
                    <NumberField name='Pressure Trend' value={this.props.weather.pressureTrend} unit={this.props.weather.pressureTrendUnit} fixed='3'/>
                    <Separator/>
                    <NumberField name='Maximum Wind Speed (10 min)' value={this.props.weather.windTenMinMax} unit={this.props.weather.windSpeedUnit} fixed='1'/>
                    <NumberField name='Average Wind Speed (10 min)' value={this.props.weather.windTenMinAvg} unit={this.props.weather.windSpeedUnit} fixed='1'/>
                    <NumberField name='Minimum Wind Speed (10 min)' value={this.props.weather.windTenMinMin} unit={this.props.weather.windSpeedUnit} fixed='1'/>
                    <Separator/>
                    <NumberField name='Maximum Wind Speed (2 min)' value={this.props.weather.windTwoMinMax} unit={this.props.weather.windSpeedUnit} fixed='1'/>
                    <NumberField name='Average Wind Speed (2 min)' value={this.props.weather.windTwoMinAvg} unit={this.props.weather.windSpeedUnit} fixed='1'/>
                    <NumberField name='Minimum Wind Speed (2 min)' value={this.props.weather.windTwoMinMin} unit={this.props.weather.windSpeedUnit} fixed='1'/>
                    <Separator/>
                    <NumberField name='Instant Wind Speed' value={this.props.weather.windSpeed} unit={this.props.weather.windSpeedUnit}/>
                    <NumberField name='Instant Wind Direction' value={this.props.weather.windDirection} unit={this.props.weather.windDirectionUnit}/>
                    <Separator/>
                    <NumberField name='Timestamp' value={this.props.weather.timestamp} unit=' ms'/>
                </div>
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

export default App;
