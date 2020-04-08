import {ApiService} from "./ApiService";

export default class WeatherService extends ApiService {

	URI = 'http://mark.soderquist.net/weather/api/station?id=bluewing';

	fetchWeather(success) {
		return fetch(this.URI, {
			headers: {
				Accept: 'application/json',
			},
		})
			.then(this.checkStatus)
			.then(this.parseJSON)
			.then(success);
	}

}
