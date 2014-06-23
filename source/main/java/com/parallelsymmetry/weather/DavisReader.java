package com.parallelsymmetry.weather;

import gnu.io.CommPortIdentifier;

import com.parallelsymmetry.utility.EnumerationIterator;
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

	public static final void main( String[] commands ) {
		Log.write( "Starting reader..." );

		for( CommPortIdentifier identifier : new EnumerationIterator<CommPortIdentifier>( CommPortIdentifier.getPortIdentifiers() ) ) {
			Log.write( "Port: ", identifier.getName() );
		}

		Log.write( "Reader stopped!" );
	}
	
}
