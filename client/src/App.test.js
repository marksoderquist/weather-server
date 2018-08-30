import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import FetchMock from 'fetch-mock';

const defaultWeatherContent = {
    weather: {
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

it('renders without crashing', () => {
    FetchMock.mock('begin:http://mark.soderquist.net/weather/api/station?id=', defaultWeatherContent);

    const div = document.createElement('div');
    ReactDOM.render(<App/>, div);
    ReactDOM.unmountComponentAtNode(div);

    FetchMock.restore();
});
