export function toDatestamp(time) {
	let date = new Date(time);
	let year = pad(date.getFullYear(), 4);
	let month = pad(date.getMonth() + 1, 2);
	let day = pad(date.getDate(), 2);
	let hour = pad(date.getHours() % 12, 2);
	let minute = pad(date.getMinutes(), 2);
	let second = pad(date.getSeconds(), 2);
	let ampm = amOrPm(date.getHours());

	hour = hour % 12;
	hour = hour === 0 ? 12 : hour;

	return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second + ' ' + ampm;
}

export function getDowName(day) {
	const weekday = new Array(7);
	weekday[0] = "Sunday";
	weekday[1] = "Monday";
	weekday[2] = "Tuesday";
	weekday[3] = "Wednesday";
	weekday[4] = "Thursday";
	weekday[5] = "Friday";
	weekday[6] = "Saturday";

	return weekday[day];
}

// Hour must be between 0 and 23
export function amOrPm(h) {
	return h < 12 ? 'am' : 'pm';
}

export function pad(n, z, p = 0) {
	n = n.toString();
	return n.length >= z ? n : new Array(z - n.length + 1).join(p) + n;
}
