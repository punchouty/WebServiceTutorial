package com.store.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.store.domain.Store;
import com.store.service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Store get(@PathVariable String name) {
		System.out.println(name);
		return storeService.findByName(name);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
    public Store create(@Valid @RequestBody Store input) {
		return storeService.save(input);
    }

}
