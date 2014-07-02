package com.parallelsymmetry.weather;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import com.parallelsymmetry.utility.EnumerationIterator;
import com.parallelsymmetry.utility.IoPump;
import com.parallelsymmetry.utility.TextUtil;
import com.parallelsymmetry.utility.ThreadUtil;
import com.parallelsymmetry.utility.comm.SerialAgent;
import com.parallelsymmetry.utility.log.Log;

/**
 * In order to use RXTX there are three things that need to be configured:
 * <ol>
 * <li>The RXTX shared library must be found on the java.library.path</li>
 * <li>The RXTX java library must be found on the java class path</li>
 * <li>The user running the program must have read access to the ports</li>
 * <ol>
 * On Linux Mint the user must be assigned to the dialout group.
 * 
 * @author mvsoder
 */
public class DavisReader {

	private boolean console = false;

	public static final void main( String[] commands ) {
		Log.setLevel( Log.DEBUG );
		new DavisReader().start();
	}

	private void start() {
		Log.write( "Starting reader..." );

		for( CommPortIdentifier identifier : new EnumerationIterator<CommPortIdentifier>( CommPortIdentifier.getPortIdentifiers() ) ) {
			Log.write( "Port: ", identifier.getName() );
		}

		String port = "/dev/ttyUSB0";

		try {
			SerialAgent agent = new SerialAgent( "Davis Reader", port, 19200, SerialPort.DATABITS_8, SerialPort.PARITY_NONE, SerialPort.STOPBITS_1 );
			agent.setReconnectDelay( 5000 );
			agent.setStopOnException( true );
			agent.start();

			if( console ) {
				IoPump reader = new IoPump( agent.getInputStream(), new WatcherOutputStream( System.out ) );
				reader.start();

				IoPump console = new IoPump( System.in, agent.getOutputStream() );
				console.start();
			} else {
				while( true ) {
					getData( agent );
					ThreadUtil.pause( 3000 );
				}
			}
		} catch( Exception exception ) {
			exception.printStackTrace( System.err );
		}

		//		synchronized( this ) {
		//			try {
		//				Log.write( "Waiting for data..." );
		//				wait();
		//			} catch( InterruptedException exception ) {
		//				exception.printStackTrace( System.err );
		//			}
		//		}

		Log.write( "Reader stopped!" );
	}

	private boolean isReceiverConnected( SerialAgent agent ) throws IOException {
		PrintStream output = new PrintStream( agent.getOutputStream() );
		output.println( "RECEIVERS" );

		byte[] buffer = new byte[8];
		BufferedInputStream input = new BufferedInputStream( agent.getInputStream() );

		int read = input.read( buffer );
		int count = read;
		while( count < 7 ) {
			read = input.read( buffer );
			count += read;
		}

		boolean connected = ( buffer[6] & 1 ) != 0;
		
		Log.write();
		Log.write( "Read: ", TextUtil.toPrintableString( buffer, 0, 7 ) );
		Log.write( "Connected: ", connected );

		return connected;
	}

	private void getData( SerialAgent agent ) throws IOException {
		boolean connected = isReceiverConnected( agent );
		
		PrintStream output = new PrintStream( agent.getOutputStream() );
		output.println( "LOOP 1" );

		byte[] buffer = new byte[128];
		BufferedInputStream input = new BufferedInputStream( agent.getInputStream() );

		int read = input.read( buffer );
		int count = read;
		while( count < 100 ) {
			read = input.read( buffer );
			count += read;
		}

		System.arraycopy( buffer, 1, buffer, 0, 99 );

		// Barometer trend
		BarometerTrend barTrend = parseBarometerTrend( buffer[3] );

		// Barometer
		int barRaw = getUnsignedByte( buffer[7] ) + ( getUnsignedByte( buffer[8] ) << 8 );
		float bar = barRaw == 0x7fff ? Float.NaN : barRaw / 1000.0f;

		// Inside temperature
		int tempInsideRaw = getUnsignedByte( buffer[9] ) + ( getUnsignedByte( buffer[10] ) << 8 );
		float tempInside = tempInsideRaw == 0x7fff ? Float.NaN : tempInsideRaw / 10.0f;

		// Inside humidity
		int humidInsideRaw = getUnsignedByte( buffer[11] );
		float humidInside = humidInsideRaw == 0xff ? Float.NaN : humidInsideRaw;

		// Outside temperature
		int tempOutsideRaw = getUnsignedByte( buffer[12] ) + ( ( buffer[13] ) << 8 );
		float tempOutside = tempOutsideRaw == 0x7fff ? Float.NaN : tempOutsideRaw / 10.0f;

		// Wind speed
		int windSpeedRaw = getUnsignedByte( buffer[14] );
		float windSpeed = windSpeedRaw == 0xff ? Float.NaN : windSpeedRaw;

		// Wind speed 10 minute average
		int windSpeedTenMinAvgRaw = getUnsignedByte( buffer[15] );
		float windSpeedTenMinAvg = windSpeedTenMinAvgRaw == 0xff ? Float.NaN : windSpeedTenMinAvgRaw;

		// Wind direction
		int windDirectionRaw = getUnsignedByte( buffer[16] ) + ( getUnsignedByte( buffer[17] ) << 8 );
		float windDirection = windDirectionRaw == 0x7fff ? Float.NaN : windDirectionRaw;

		// Outside humidity
		int humidOutsideRaw = getUnsignedByte( buffer[33] );
		float humidOutside = humidOutsideRaw == 0xff ? Float.NaN : humidOutsideRaw;

		// Rain rate
		int rainRateRaw = getUnsignedByte( buffer[41] ) + ( getUnsignedByte( buffer[42] ) << 8 );
		float rainRate = rainRateRaw == 0xffff ? Float.NaN : rainRateRaw / 100.0f;

		Log.write();
		//Log.write( "Read: ", TextUtil.toPrintableString( buffer, 33, 1 ) );
		Log.write( "Bar: ", TextUtil.toPrintableString( buffer, 7, 2 ), " ", bar );
		Log.write( "Bar trend: ", TextUtil.toPrintableString( buffer, 3, 1 ), " ", barTrend.name() );
		Log.write( "Temp in: ", TextUtil.toPrintableString( buffer, 9, 2 ), " ", tempInside );
		Log.write( "Humid in: ", TextUtil.toPrintableString( buffer, 1, 1 ), " ", humidInside + "%" );
		Log.write( "Temp out: ", TextUtil.toPrintableString( buffer, 12, 2 ), " ", tempOutside );
		Log.write( "Wind speed: ", TextUtil.toPrintableString( buffer, 14, 1 ), " ", windSpeed );
		Log.write( "Wind speed 10 min. avg.: ", TextUtil.toPrintableString( buffer, 15, 1 ), " ", windSpeedTenMinAvg );
		Log.write( "Wind direction: ", TextUtil.toPrintableString( buffer, 16, 2 ), " ", windDirection );

		Log.write( "Humid out: ", TextUtil.toPrintableString( buffer, 33, 1 ), " ", humidOutside );
		Log.write( "Rain rate: ", TextUtil.toPrintableString( buffer, 41, 2 ), " ", rainRate );
	}

	private int getUnsignedByte( byte value ) {
		int result = (int)value;
		if( result < 0 ) result += 256;
		return result;
	}

	private BarometerTrend parseBarometerTrend( byte data ) {
		switch( data ) {
			case -60: {
				return BarometerTrend.FALLING_FAST;
			}
			case -20: {
				return BarometerTrend.FALLING_SLOW;
			}
			case 0: {
				return BarometerTrend.STEADY;
			}
			case 20: {
				return BarometerTrend.RISING_SLOW;
			}
			case 60: {
				return BarometerTrend.RISING_FAST;
			}
		}
		return BarometerTrend.UNKNOWN;
	}

	private class WatcherOutputStream extends OutputStream {

		private PrintStream output;

		public WatcherOutputStream( OutputStream output ) {
			this.output = new PrintStream( output );
		}

		@Override
		public void write( int b ) throws IOException {
			output.print( TextUtil.toPrintableString( b ) );
		}

	}

}
