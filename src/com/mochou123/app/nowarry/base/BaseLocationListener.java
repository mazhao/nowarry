package com.mochou123.app.nowarry.base;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

public class BaseLocationListener implements LocationListener {

	@Override
	public void onLocationChanged(Location location) {
		Log.d(this.getClass().getName(), "on location changed - location: " + location);
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		Log.d(this.getClass().getName(), "on status changed - provider:" + provider + " status:" + status + " bundle:"
				+ extras);
	}

	@Override
	public void onProviderEnabled(String provider) {
		Log.d(this.getClass().getName(), "on provider enabled - provider: " + provider);

	}

	@Override
	public void onProviderDisabled(String provider) {
		Log.d(this.getClass().getName(), "on provider disabled - provider: " + provider);

	}

}
