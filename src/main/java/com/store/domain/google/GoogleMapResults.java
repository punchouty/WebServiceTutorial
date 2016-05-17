package com.store.domain.google;

import java.util.List;

public class GoogleMapResults {
	
	private String status;
	private List<Address> results;
	
	@Override
	public String toString() {
		return "GoogleMapResults [status=" + status + ", results=" + results + "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Address> getResults() {
		return results;
	}
	public void setResults(List<Address> results) {
		this.results = results;
	}

}
