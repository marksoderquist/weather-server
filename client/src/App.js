import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

function getWeather(success) {
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
    state = {
        weather : {
            "id": "bluewing",
            "name": "Bluewing Way",
            "timestamp": 0,
            "temperature": 0,
            "pressure": 0,
            "humidity": 0,
            "dewPoint": 0,
            "windChill": 0,
            "heatIndex": 0,
            "pressureTrend": 0,
            "windDirection": 0,
            "wind": 0,
            "windTenMinMax": 0,
            "windTenMinAvg": 0,
            "windTenMinMin": 0,
            "windTwoMinMax": 0,
            "windTwoMinAvg": 0,
            "windTwoMinMin": 0,
            "rainTotalDaily": 0,
            "rainRate": 0
        }
    };

    componentDidMount() {
        this.loadWeatherFromServer();
        setInterval(this.loadWeatherFromServer, 5000);
    }


    loadWeatherFromServer = () => {
        getWeather((weatherFromServer) => (
                this.setState({ weather: weatherFromServer })
            )
        );
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
                    <Field name='Timestamp' value={this.props.weather.timestamp} unit=''/>
                    <Field name='Temperature' value={this.props.weather.temperature} unit='&deg;'/>
                </div>
                <div className="column">
                    <Field name='Wind Speed' value={this.props.weather.wind} unit=' mph'/>
                </div>
            </div>
        )
    }
}

class Field extends Component {
    render() {
        return (
            <div>{this.props.name}: {this.props.value}{this.props.unit}</div>
        );
    }
}


export default App;
