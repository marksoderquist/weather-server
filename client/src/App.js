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
        setTimeout(this.loadWeatherFromServer, 0);
        this.refreshTimer = setInterval(this.loadWeatherFromServer, 5000);
    }

    componentWillUnmount() {
        clearInterval(this.refreshTimer);
    }

    loadWeatherFromServer = () => {
        fetchWeather((weatherFromServer) => (
                this.setState({weather: weatherFromServer})
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
