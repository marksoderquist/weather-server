import React, {Component} from 'react';
import './dashboard.css';

export default class FlightConditions extends Component {

	render() {
		let summary = (this.props.weather.flightCondition && this.props.weather.flightCondition.summary) || '';
		let reasons = (this.props.weather.flightCondition && this.props.weather.flightCondition.reasons) || [];
		return (
			<div className='flight-conditions'>
				<div className='title'>Flight Conditions</div>
				<div className='summary'>{summary}</div>
				<div className='reason'>
					{reasons.map((reason, index) => (
						<span key={index}>{index > 0 ? ' ' : ''}{reason}</span>
					))}
				</div>
			</div>
		);
	}
}
