package net.soderquist.mark.weather;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
public enum UnitSystem {

	METRIC( "Metric",
		new CelsiusUnit(),
		new HectoPascalUnit(),
		new KilometerUnit(),
		new KilometerPerHourUnit(),
		new DegreeUnit(),
		new MillimeterUnit(),
		new PercentUnit()
	),

	IMPERIAL( "Imperial",
		new FahrenheitUnit(),
		new InchMercuryUnit(),
		new MileUnit(),
		new MilePerHourUnit(),
		new DegreeUnit(),
		new InchUnit(),
		new PercentUnit()
	);

	private final String name;

	private final TemperatureUnit temperatureUnit;

	private final PressureUnit pressureUnit;

	private final DistanceUnit distanceUnit;

	private final SpeedUnit speedUnit;

	private final DirectionUnit directionUnit;

	private final RainfallUnit rainfallUnit;

	private final HumidityUnit humidityUnit;

	private final TimeUnit timeUnit = TimeUnit.SECONDS;

	UnitSystem(
		String name,
		TemperatureUnit temperatureUnit,
		PressureUnit pressureUnit,
		DistanceUnit distanceUnit,
		SpeedUnit speedUnit,
		DirectionUnit directionUnit,
		RainfallUnit rainfallUnit,
		HumidityUnit humidityUnit
	) {
		this.name = name;
		this.temperatureUnit = temperatureUnit;
		this.pressureUnit = pressureUnit;
		this.distanceUnit = distanceUnit;
		this.speedUnit = speedUnit;
		this.directionUnit = directionUnit;
		this.rainfallUnit = rainfallUnit;
		this.humidityUnit = humidityUnit;
	}

	private interface Unit {

		String getName();

		String getSymbol();

		double to( double value );

		double from( double value );

	}

	public interface TemperatureUnit extends Unit {}

	public interface PressureUnit extends Unit {}

	public interface DistanceUnit extends Unit {}

	public interface SpeedUnit extends Unit {}

	public interface DirectionUnit extends Unit {}

	public interface RainfallUnit extends Unit {}

	public interface HumidityUnit extends Unit {}

	private static class CelsiusUnit implements TemperatureUnit {

		@Override
		public String getName() {
			return "Celsius";
		}

		@Override
		public String getSymbol() {
			return "C";
		}

		@Override
		public double to( double value ) {
			return value;
		}

		@Override
		public double from( double value ) {
			return value;
		}

	}

	private static class FahrenheitUnit implements TemperatureUnit {

		@Override
		public String getName() {
			return "Fahrenheit";
		}

		@Override
		public String getSymbol() {
			return "F";
		}

		@Override
		public double to( double value ) {
			return value * 9 / 5 + 32;
		}

		@Override
		public double from( double value ) {
			return (value - 32) * 5 / 9;
		}

	}

	private static class HectoPascalUnit implements PressureUnit {

		@Override
		public String getName() {
			return "HectoPascal";
		}

		@Override
		public String getSymbol() {
			return "hPa";
		}

		@Override
		public double to( double value ) {
			return value;
		}

		@Override
		public double from( double value ) {
			return value;
		}

	}

	private static class InchMercuryUnit implements PressureUnit {

		@Override
		public String getName() {
			return "Inch Mercury";
		}

		@Override
		public String getSymbol() {
			return "inHg";
		}

		@Override
		public double to( double value ) {
			return value * 0.02953;
		}

		@Override
		public double from( double value ) {
			return value * 3386.39;
		}

	}

	private static class KilometerUnit implements DistanceUnit {

		@Override
		public String getName() {
			return "Kilometer";
		}

		@Override
		public String getSymbol() {
			return "km";
		}

		@Override
		public double to( double value ) {
			return value;
		}

		@Override
		public double from( double value ) {
			return value;
		}

	}

	private static class MileUnit implements DistanceUnit {

		@Override
		public String getName() {
			return "Mile";
		}

		@Override
		public String getSymbol() {
			return "mi";
		}

		@Override
		public double to( double value ) {
			return value * 0.621371;
		}

		@Override
		public double from( double value ) {
			return value * 1.60934;
		}

	}

	private static class KilometerPerHourUnit implements SpeedUnit {

		@Override
		public String getName() {
			return "Kilometer per Hour";
		}

		@Override
		public String getSymbol() {
			return "kph";
		}

		@Override
		public double to( double value ) {
			return value;
		}

		@Override
		public double from( double value ) {
			return value;
		}

	}

	private static class MilePerHourUnit implements SpeedUnit {

		@Override
		public String getName() {
			return "Mile per Hour";
		}

		@Override
		public String getSymbol() {
			return "mph";
		}

		@Override
		public double to( double value ) {
			return value * 0.621371;
		}

		@Override
		public double from( double value ) {
			return value * 1.60934;
		}

	}

	private static class DegreeUnit implements DirectionUnit {

		@Override
		public String getName() {
			return "Degree";
		}

		@Override
		public String getSymbol() {
			return "°";
		}

		@Override
		public double to( double value ) {
			return value;
		}

		@Override
		public double from( double value ) {
			return value;
		}

	}

	private static class MillimeterUnit implements RainfallUnit {

		@Override
		public String getName() {
			return "Millimeter";
		}

		@Override
		public String getSymbol() {
			return "mm";
		}

		@Override
		public double to( double value ) {
			return value;
		}

		@Override
		public double from( double value ) {
			return value;
		}

	}

	private static class InchUnit implements RainfallUnit {

		@Override
		public String getName() {
			return "Inch";
		}

		@Override
		public String getSymbol() {
			return "in";
		}

		@Override
		public double to( double value ) {
			return value * 0.0393701;
		}

		@Override
		public double from( double value ) {
			return value * 25.4;
		}

	}

	private static class PercentUnit implements HumidityUnit {

		@Override
		public String getName() {
			return "Percent";
		}

		@Override
		public String getSymbol() {
			return "%";
		}

		@Override
		public double to( double value ) {
			return value;
		}

		@Override
		public double from( double value ) {
			return value;
		}

	}

}
