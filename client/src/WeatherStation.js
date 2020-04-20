import React, {Component} from 'react';
import './dashboard.css';
import TemperatureGauge from "./TemperatureGauge";
import WindGauge from "./WindGauge";
import {toDatestamp} from './util'

export default class WeatherStation extends Component {

	render() {
		return (
			<div className='weather'>
				<div className='title'>{this.props.weather.name} Station</div>
				<div className='subtitle'>{toDatestamp(this.props.weather.timestamp)}</div>
				<TemperatureGauge weather={this.props.weather}/>
				<WindGauge weather={this.props.weather}/>
			</div>
		);
	}

}