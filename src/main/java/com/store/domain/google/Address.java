package com.store.domain.google;

public class Address {
	
	private Geometry geometry;

	@Override
	public String toString() {
		return "Address [geometry=" + geometry + "]";
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

}
