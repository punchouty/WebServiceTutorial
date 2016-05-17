package com.store.service;

import java.util.Set;

import com.store.domain.Store;

public interface StoreService {
	
	public Store findByName(String name);
	public Store save(Store input);
	public Set<Store> findWithinMilesOfZipcode(String zipcode, int miles);

}
