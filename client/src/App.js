import React, {Component} from 'react';
import logo from './logo.svg';
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
        super(props)
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
        return (
            <div className="App">
                <Header title={this.state.weather.name}/>
                <Body weather={this.state.weather}/>
            </div>
        );
    }
}

class Header extends Component {
    render() {
        return (
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <h1 className="App-title">{this.props.title}</h1>
            </header>
        );
    }
}

class Body extends Component {
    render() {
        return (
            <div className="two-column-layout">
                <div className="column">
                    <Field name='Temperature' value={this.props.weather.temperature} unit='&deg;'/>
                    <Field name='Wind Chill' value={this.props.weather.windChill} unit='&deg;'/>
                    <Field name='Head Index' value={this.props.weather.heatIndex} unit='&deg;'/>
                    <Field name='Dew Point' value={this.props.weather.dewPoint} unit='&deg;'/>
                    <Separator/>
                    <Field name='Humidity' value={this.props.weather.humidity} unit='%'/>
                    <Separator/>
                    <Field name='Pressure' value={this.props.weather.pressure} unit=' in'/>
                    <Field name='Pressure Trend' value={this.props.weather.pressureTrend} unit=' in/h'/>
                    <Separator/>
                    <Field name='Daily Rain' value={this.props.weather.rainTotalDaily} unit=' in'/>
                    <Field name='Rain Rate' value={this.props.weather.rainRate} unit=' in/h'/>
                </div>
                <div className="column">
                    <Field name='Wind Speed' value={this.props.weather.windTenMinAvg} unit=' mph'/>
                    <Field name='Wind Direction' value={this.props.weather.windDirection} unit='&deg;'/>
                    <Separator/>
                    <Field name='Maximum Wind Speed (10 min)' value={this.props.weather.windTenMinMax} unit=' mph'/>
                    <Field name='Average Wind Speed (10 min)' value={this.props.weather.windTenMinAvg} unit=' mph'/>
                    <Field name='Minimum Wind Speed (10 min)' value={this.props.weather.windTenMinMin} unit=' mph'/>
                    <Separator/>
                    <Field name='Maximum Wind Speed (2 min)' value={this.props.weather.windTwoMinMax} unit=' mph'/>
                    <Field name='Average Wind Speed (2 min)' value={this.props.weather.windTwoMinAvg} unit=' mph'/>
                    <Field name='Minimum Wind Speed (2 min)' value={this.props.weather.windTwoMinMin} unit=' mph'/>
                    <Separator/>
                    <Field name='Instant Wind Speed' value={this.props.weather.wind} unit=' mph'/>
                </div>
            </div>
        )
    }
}

class Field extends Component {
    render() {
        return (
            <div className="weather-field"><div className="weather-cell">{this.props.name}:</div><div className="weather-cell">{this.props.value}{this.props.unit}</div></div>
        );
    }
}

class Separator extends Component {
    render() {
        return (
            <div className="weather-field"><div className="weather-cell"/>&nbsp;</div>
        );
    }
}


export default App;
