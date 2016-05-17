package com.store;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.store.domain.Store;
import com.store.repository.StoreRepository;

@SpringBootApplication
public class SampleWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleWebServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StoreRepository repository) {
		return (evt) -> {
			//https://www.google.co.in/maps/place/McDonald's/@40.7098322,-74.0816773,17z/data=!4m13!1m7!3m6!1s0x0:0x0!2zNDDCsDQyJzMzLjgiTiA3NMKwMDQnNDkuNyJX!3b1!8m2!3d40.709389!4d-74.0804703!3m4!1s0x0000000000000000:0x8848ab2179206f53!8m2!3d40.7114744!4d-74.0781109
			Store store = new Store();
			store.setName("Mac1");
			store.setBranchName("1560 Broadway");
			store.setLattitude(40.7098322);
			store.setLongitiude(-74.0816773);
			repository.save(store);
			//https://www.google.co.in/maps/place/McDonald's/@40.7094525,-74.0122809,17z/data=!3m1!4b1!4m5!3m4!1s0x89c25a177d4bf5db:0x84e51f23e8c0a75c!8m2!3d40.7094525!4d-74.0100869?hl=en
			store = new Store();
			store.setName("Mac2");
			store.setBranchName("160 Broadway");
			store.setLattitude(40.7094525);
			store.setLongitiude(-74.0122809);
			repository.save(store);
			//https://www.google.co.in/maps/place/McDonald's/@40.7094525,-74.0122809,17z/data=!3m1!4b1!4m5!3m4!1s0x89c25a177d4bf5db:0x84e51f23e8c0a75c!8m2!3d40.7094525!4d-74.0100869?hl=en
			store = new Store();
			store.setName("Mac3");
			store.setBranchName("1286 1st Avenue");
			store.setLattitude(40.765882);
			store.setLongitiude(-73.9745725);
			repository.save(store);
		};
	}
}
