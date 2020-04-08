import React, {Component} from 'react';
import {pad,getDowName} from './util'
import './app.css';

export default class Clock extends Component {

	state = {
		yy: '',
		mo: '',
		dd: '',
		hh: '',
		mm: '',
		ss: '',
		ap: ''
	};

	componentDidMount() {
		setTimeout(this.updateTime, 0);
		this.refreshTimer = setInterval(this.updateTime, 1000);
	}

	componentWillUnmount() {
		clearInterval(this.refreshTimer);
	}

	updateTime = () => {
		let timestamp = new Date();
		let yy = timestamp.getFullYear();
		let mo = timestamp.getMonth() + 1;
		let dd = timestamp.getDate();
		let hh = timestamp.getHours();
		let mm = timestamp.getMinutes();
		let ss = timestamp.getSeconds();
		let ap = hh < 12 ? "am" : "pm";
		let day = timestamp.getDay();
		let dw = getDowName( day );

		hh = hh % 12;
		hh = hh === 0 ? 12 : hh;

		this.setState({yy: yy, mo: mo, dd: dd, hh: hh, mm: mm, ss: ss, ap: ap, dw: dw});
	};

	render() {

		return (
			<div className="clock">
				<div className="time">{this.state.hh}:{pad( this.state.mm, 2)}<span className="ampm">{this.state.ap}</span></div>
				<div className="date">{pad(this.state.yy, 4)}-{pad(this.state.mo,2)}-{pad(this.state.dd,2)}</div>
				<div className="dow">{this.state.dw}</div>
			</div>
		);

	}

}
