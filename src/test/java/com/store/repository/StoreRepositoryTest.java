package com.store.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.store.SampleWebServiceApplication;
import com.store.domain.Store;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleWebServiceApplication.class)
public class StoreRepositoryTest {
	
	@Autowired
	private StoreRepository repository;

	@Test
	public void testFindByName() {
		List<Store> stores = repository.findByName("Mac1");
		assertTrue(stores.size() == 1);
	}

}
