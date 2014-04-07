package com.mochou123.app.nowarry.util;


/**
 * 通过YahooWeather活的天气信息
 * 1. 获得手机所在地的经纬度
 * 2. 通过经纬度找到城市
 * 3. 通过城市活的WOEID
 *    http://query.yahooapis.com/v1/public/yql?q=select * from geo.places where text="杭州市"&format=json
 * 4. 通过WOEID
 *    
 * Ref. 
 * API地址：
 * http://developer.yahoo.com/weather/
 * 
 * 获得天气的API：
 * http://weather.yahooapis.com/forecastrss?w=2442047&u=c
 *  参数	说明											示例
 *  w	WOEID										w=2502265
 *  u	Units for temperature (case sensitive)  	u=c
 *		f: Fahrenheit
 *		c: Celsius						   
 *
 * 活的WOEID的API
 * @author mazhao
 *    http://query.yahooapis.com/v1/public/yql?q=select * from geo.places where text="杭州市"&format=json
 *    
 */
public class WeatherUtil {

}
