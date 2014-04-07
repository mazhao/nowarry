package com.mochou123.app.nowarry.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

/**
 * !!! 这个类的功能应该放在服务器端 !!! 通过YahooWeather活的天气信息 1. 获得手机所在地的经纬度 2. 通过经纬度找到城市 3.
 * 通过城市活的WOEID http://query.yahooapis.com/v1/public/yql?q=select * from
 * geo.places where text="杭州市"&format=json 4. 通过WOEID
 * 
 * Ref. API地址： http://developer.yahoo.com/weather/
 * 
 * 获得天气的API： http://weather.yahooapis.com/forecastrss?w=12577992&u=c 参数 说明 示例 w
 * WOEID w=12577992 u Units for temperature (case sensitive) u=c f: Fahrenheit
 * c: Celsius
 * 
 * 活的WOEID的API
 * 
 * @author mazhao http://query.yahooapis.com/v1/public/yql?q=select * from
 *         geo.places where text="杭州市"&format=json
 * 
 */
public class WeatherUtil {

	public static String getWoeid(String cityName) {
		// 1st append to get full url.
		StringBuilder sb = new StringBuilder("http://query.yahooapis.com/v1/public/yql?");
		try {
			sb.append("q=").append(
					URLEncoder.encode("select * from geo.places where text=\"" + cityName + "\"", "utf-8"));
		} catch (UnsupportedEncodingException e) {
			Log.d(WeatherUtil.class.getName(), "url encode error:", e);
		}
		sb.append("&format=json");

		// 2nd request & response
		String responseJson = doSimpleGet(sb.toString());

		// for json string to get woeid
		JSONObject jsonObj = new JSONObject(responseJson);
		JSONArray placeArray = jsonObj.getJSONObject("query").getJSONObject("results").getJSONArray("place");
		JSONObject placeObject = (JSONObject) placeArray.get(placeArray.length() - 1);
		String woeid = (String) placeObject.get("woeid");

		Log.d(WeatherUtil.class.getName(), "woeid:" + woeid);

		return woeid;

	}

	public static String getWeatherByWoeid(String woeid) {

		String responseJson = WeatherUtil.doSimpleGet("http://weather.yahooapis.com/forecastrss?w=" + woeid.trim()
				+ "&u=c");
		Log.d(WeatherUtil.class.getName(), "weather:" + responseJson);
		return "";
	}

	public static String getWeatherByCityName(String cityName) {
		String woeid = WeatherUtil.getWoeid(cityName);
		return WeatherUtil.getWeatherByWoeid(woeid);
	}

	/**
	 * do simple get
	 * 
	 * @param urlStr
	 *            request url
	 * @return json string
	 */
	private static String doSimpleGet(String urlStr) {
		HttpURLConnection conn = null;
		BufferedReader reader = null;
		StringBuilder responseJson = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.connect();

			reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));// 设置编码,否则中文乱码
			String lines;
			while ((lines = reader.readLine()) != null) {
				Log.d(WeatherUtil.class.getName(), lines);
				responseJson.append(lines);
			}
			reader.close();
			// 断开连接
			conn.disconnect();

		} catch (MalformedURLException e) {
			Log.d(WeatherUtil.class.getName(), " url form error:", e);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.d(WeatherUtil.class.getName(), " url connection error:", e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				conn.disconnect();
			}

		}
		return responseJson.toString();
	}

}
