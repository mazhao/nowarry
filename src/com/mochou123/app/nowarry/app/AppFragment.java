package com.mochou123.app.nowarry.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.mochou123.app.nowarry.R;
import com.mochou123.app.nowarry.base.BaseFragment;
import com.mochou123.app.nowarry.base.BaseLocationListener;
import com.mochou123.app.nowarry.util.WeatherUtil;

public class AppFragment extends BaseFragment implements OnGeocodeSearchListener {

	private TextView addressTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		// init root layout
		View rootView = inflater.inflate(R.layout.fragment_app, container, false);
		initLayout(inflater, rootView);

		// init location
		initLocationAndWeather();

		return rootView;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		lm.removeUpdates(bll);

	}

	private void initLayout(LayoutInflater inflater, View rootView) {
		ListView listView = (ListView) rootView.findViewById(R.id.appListView);

		LinearLayout headerView = (LinearLayout) inflater.inflate(R.layout.fragment_app_header, null);
		listView.addHeaderView(headerView);

		// fnflater for row layout; this for launching app
		listView.setAdapter(new AppAdapter(inflater, this));

		addressTextView = (TextView) headerView.findViewById(R.id.appHeaderTextView);

	}

	@Override
	public String getTitle() {
		return super.getResources().getString(R.string.actionBar_tab_app_name);
	}

	// ----------
	// get location begin
	// ----------

	// The minimum distance to change Updates in meters
	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1; // 10 meters

	// The minimum time between updates in milliseconds
	private static final long MIN_TIME_BW_UPDATES = 1; // 1 minute

	private static final float RADIUS_PROPER = 200.0f;
	private LocationManager lm;
	private BaseLocationListener bll = new BaseLocationListener();;

	private void initLocationAndWeather() {

		lm = (LocationManager) super.getActivity().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);

		// not good structure but better performance begin

		// 1st get provider
		String provider = null;
		boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
		if (isGPSEnabled) {
			provider = LocationManager.GPS_PROVIDER;
		} else {
			boolean isNetworkEnabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

			if (isNetworkEnabled) {
				provider = LocationManager.NETWORK_PROVIDER;

			} else {
				// neighter gps nor network is enables
				Log.e(AppFragment.this.getClass().getName(), "GPS 和 Network 定位都不能使用");

			}
		}

		Location location = null;

		// 2nd get location
		if (provider != null) {
			lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES,
					MIN_DISTANCE_CHANGE_FOR_UPDATES, bll);

			if (lm != null) {
				location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			}

		}

		RegeocodeAddress address = null;
		// 3rd get city
		if (location != null) {
			Log.d(AppFragment.this.getClass().getName(), "get location: " + location);

			LatLonPoint point = new LatLonPoint(location.getLatitude(), location.getLongitude());
			RegeocodeQuery query = new RegeocodeQuery(point, RADIUS_PROPER, GeocodeSearch.AMAP);

			GeocodeSearch search = new GeocodeSearch(super.getActivity().getApplicationContext());
			search.setOnGeocodeSearchListener(AppFragment.this);
			search.getFromLocationAsyn(query);

		} else {
			Log.d(AppFragment.this.getClass().getName(), "can not get location.");

		}

		// not good structure but better performance end

	}

	@Override
	public void onGeocodeSearched(GeocodeResult arg0, int arg1) {
		// no use at here
	}

	@Override
	public void onRegeocodeSearched(RegeocodeResult result, int returnCode) {

		// get the data
		if (returnCode == 0) {
			final RegeocodeAddress address = result.getRegeocodeAddress();
			Log.d(AppFragment.this.getClass().getName(), "current city of location " + address.getCity());

			// do in main thread
			Log.d(AppFragment.this.getClass().getName(), "enter main thread to update city");
			if (addressTextView != null) {
				addressTextView.setText(address.getCity());
			}
			
			// start new thread to get weather
			new Thread(new Runnable() {
				@Override
				public void run() {
					WeatherUtil.getWoeid(address.getCity());
				}
			}).start();

		} else {
			Log.d(AppFragment.this.getClass().getName(), "failed to get current location with error code:" + returnCode);
		}

		// them stop gps
		lm.removeUpdates(bll);

	}

}
