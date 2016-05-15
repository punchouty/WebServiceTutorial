package com.store.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.store.SampleWebServiceApplication;
import com.store.domain.Store;
import com.store.repository.StoreRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleWebServiceApplication.class)
@WebAppConfiguration
public class StoreControllerTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;
    private String name = "Mac1";
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
    private Store store;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
	private StoreRepository repository;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

	@Before
	public void setUp() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
		this.repository.deleteAll();
		//https://www.google.co.in/maps/search/mcdonald+near+Palam+Vihar,+Gurgaon,+Haryana/@28.5152508,76.9750811,11z/data=!3m1!4b1
		store = new Store();
		store.setName("Mac1");
		store.setBranchName("Macdonal, Palam Vihar, Gurgaon");
		store.setLongitiude(28.5152508);
		store.setLattitude(76.9750811);
		repository.save(store);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
    public void testFindStoreByNameFailiure() throws Exception {
		mockMvc.perform(get("/store/" + "wrongName"))
        .andExpect(status().isNotFound());
    }
	
	@Test
    public void testFindStoreByNameSuccess() throws Exception {
		mockMvc.perform(get("/store/" + name))
		.andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.id", is(this.store.getId().intValue())))
        .andExpect(jsonPath("$.name", is(this.store.getName())));
    }
	
	@Test
    public void testCreateStoreSuccess() throws Exception {
		//https://www.google.co.in/maps/place/McDonald's/@28.4839245,76.9135218,11z/
		store = new Store();
		store.setName("Mac3");
		store.setBranchName("Macdonal, Leisure Valley Road,");
		store.setLongitiude(28.4839245);
		store.setLattitude(76.9135218);
		String storeJson = json(store);
		this.mockMvc.perform(post("/store")
                .contentType(contentType)
                .content(storeJson))
                .andExpect(status().isCreated());
    }
	
	@Test
    public void testCreateStoreFailureNameNull() throws Exception {
		//https://www.google.co.in/maps/place/McDonald's/@28.4839245,76.9135218,11z/
		store = new Store();
		//store.setName("Mac3");
		store.setBranchName("Macdonal, Leisure Valley Road,");
		store.setLongitiude(28.4839245);
		store.setLattitude(76.9135218);
		String storeJson = json(store);
		this.mockMvc.perform(post("/store")
                .contentType(contentType)
                .content(storeJson))
                .andExpect(status().isBadRequest());
    }
	
	protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

}
