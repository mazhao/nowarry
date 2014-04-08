package com.mochou123.app.nowarry.util;

import java.io.Serializable;

public class Weather implements Serializable {
	private String title;
	private String link;
	private String description;
	private String language;
	private String lastBuildDate;
	private long ttl; // time to live
	
	private Location location;
	private Units units;
	private Wind wind;
	private Atmosphere atmosphere;
	private Astronomy astronomy;
	
	static class Location {
		private String city;
		private String country;
		private String region;
	}
	
	static class Units {
		private String distnace;
		private String pressure;
		private String speed;
		private String temperature;
	}
	
	static class Wind {
		private int chill;
		private int direction;
		private double speed;
	}
	
	static class Atmosphere {
		private int humidity;
		private double pressure;
		private int risiong;
		private int visibility;
		
	}
	
	static class Astronomy {
		private String sunrise;
		private String sunset;
	}
	
}
