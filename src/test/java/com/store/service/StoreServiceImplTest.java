package com.store.service;

import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.store.SampleWebServiceApplication;
import com.store.domain.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleWebServiceApplication.class)
public class StoreServiceImplTest {
	
	@Autowired
	private StoreService storeService;


	@Test
	public void testOneStoreNearBy() {
		Set<Store> stores = storeService.findWithinMilesOfZipcode("10036", 3);
		Assert.assertTrue(stores.size() == 1);
	}

	@Test
	public void testTwoNearBy() {
		Set<Store> stores = storeService.findWithinMilesOfZipcode("10036", 5);
		Assert.assertTrue(stores.size() == 2);
	}

	@Test
	public void testThreeNearBy() {
		Set<Store> stores = storeService.findWithinMilesOfZipcode("10036", 10);
		Assert.assertTrue(stores.size() == 3);
	}

}
