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
			//https://www.google.co.in/maps/search/mcdonald+near+Palam+Vihar,+Gurgaon,+Haryana/@28.5152508,76.9750811,11z/data=!3m1!4b1
			Store store = new Store();
			store.setName("Mac1");
			store.setBranchName("Macdonal, Palam Vihar, Gurgaon");
			store.setLongitiude(28.5152508);
			store.setLattitude(76.9750811);
			repository.save(store);
			//https://www.google.co.in/maps/place/McDonald's/@28.5152508,76.9750811,11z/data=!4m8!1m2!2m1!1smcdonald+near+Palam+Vihar,+Gurgaon,+Haryana!3m4!1s0x390d18fdcd66b62d:0x8e64797444c735cd!8m2!3d28.468187!4d77.063049
			store = new Store();
			store.setName("Mac2");
			store.setBranchName("Macdonal, Leisure Valley Road,, Gurgaon");
			store.setLongitiude(28.5152508);
			store.setLattitude(76.9750811);
			repository.save(store);
		};
	}
}
