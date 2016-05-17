package com.store.domain.google;

public class Geometry {
	
	private Location location;

	@Override
	public String toString() {
		return "Geometry [location=" + location + "]";
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
