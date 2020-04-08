import React, {Component} from 'react';
import './dashboard.css';
import TemperatureGauge from "./TemperatureGauge";
import WindGauge from "./WindGauge";

export default class Weather extends Component {

	render() {
		return (
			<div className='weather'>
				<div className='title'>{this.props.weather.name} Station</div>
				<TemperatureGauge weather={this.props.weather}/>
				<WindGauge weather={this.props.weather}/>
			</div>
		);
	}

}