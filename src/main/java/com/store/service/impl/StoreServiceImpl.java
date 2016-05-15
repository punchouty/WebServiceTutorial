package com.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.domain.Store;
import com.store.repository.StoreRepository;
import com.store.service.StoreService;
import com.store.util.StoreNotFoundException;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreRepository repository;
	
	public Store findByName(String name) {
		List<Store> stores = repository.findByName(name);
		Store store = null;
		if(stores.isEmpty()) {
			throw new StoreNotFoundException(name);
		}
		else {
			store = stores.get(0);
		}
		return store;
	}

	public Store save(Store input) {
		return repository.save(input);
	}

}
