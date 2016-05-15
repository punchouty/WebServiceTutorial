package com.store.service;

import com.store.domain.Store;

public interface StoreService {
	
	public Store findByName(String name);
	public Store save(Store input);

}
