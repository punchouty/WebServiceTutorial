package com.store.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StoreNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5448778790476271393L;

	public StoreNotFoundException(String name) {
		super("could not find store '" + name + "'.");
	}
}