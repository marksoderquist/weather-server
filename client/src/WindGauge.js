import React, {Component} from 'react';
import './dashboard.css';

export default class WindGauge extends Component {

	render() {
		const windSpeed = parseFloat(this.props.weather.windTenMinAvg).toFixed(1);
		const gustSpeed = parseFloat(this.props.weather.windTenMinMax).toFixed(1);
		const windCardinal = windSpeed < 0.1 ? "---" : this.props.weather.windCardinalTenMinAvg;
		const windDirection = windSpeed < 0.1 ? "---" : parseFloat(this.props.weather.windDirectionTenMinAvg).toFixed(0);
		return (
			<div className="wind">
				<table>
					<tbody>
					<tr>
						<td className="label">wind&nbsp;</td>
						<td className="value">&nbsp;{windSpeed}</td>
						<td className="unit">&nbsp;{this.props.weather.windSpeedUnit}</td>
					</tr>
					<tr>
						<td className="label">gust&nbsp;</td>
						<td className="value">&nbsp;{gustSpeed}</td>
						<td className="unit">&nbsp;{this.props.weather.windSpeedUnit}</td>
					</tr>
					<tr>
						<td className="label">from&nbsp;</td>
						<td className="value">&nbsp;{windCardinal}</td>
						<td className="unit">&nbsp;{windDirection}{this.props.weather.windDirectionUnit}</td>
					</tr>
					</tbody>
				</table>
			</div>
		);
	}

}
