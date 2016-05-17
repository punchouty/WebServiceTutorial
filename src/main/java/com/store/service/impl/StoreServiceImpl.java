package com.store.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.store.domain.Store;
import com.store.domain.google.GoogleMapResults;
import com.store.domain.google.Location;
import com.store.repository.StoreRepository;
import com.store.service.StoreService;
import com.store.util.DistanceCalculator;
import com.store.util.StoreNotFoundException;

@Service
public class StoreServiceImpl implements StoreService {
	
	public static final String GOOGLE_BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
	//sample url of time square = https://maps.googleapis.com/maps/api/geocode/json?address=10036
	
	@Autowired
	private StoreRepository repository;
	private RestTemplate restTemplate = new RestTemplate();
	
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

	@Override
	public Set<Store> findWithinMilesOfZipcode(String zipcode, int miles) {
		GoogleMapResults results = restTemplate.getForObject(GOOGLE_BASE_URL + zipcode, GoogleMapResults.class);
		Set<Store> stores = new HashSet<>();
		Location zipLocation = null;
		if(results.getResults() != null && !results.getResults().isEmpty()) {
			zipLocation = results.getResults().get(0).getGeometry().getLocation();
			System.out.println("ziplocation : " + zipLocation);
			List<Store> allStores = repository.findAll();
			System.out.println("all stores : " + allStores);
			for (Store store : allStores) {
				double distance = DistanceCalculator.distance(zipLocation.getLat(), zipLocation.getLng(), store.getLattitude(), store.getLongitiude(), "M");
				if(distance < miles) {
					stores.add(store);
				}
			}
		}
		System.out.println(stores);
		return stores;
	}

}
