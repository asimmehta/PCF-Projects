package com.asim.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asim.config.Customer;
import com.asim.config.CustomerRepository;

@RestController
public class readDBController {
	
	@Autowired
	private CustomerRepository repository;
	
	String retStr;

	@RequestMapping(value = "/getMessages", method = RequestMethod.GET)
	public String getMessages() {
		for(Customer customer : repository.findAll()) {
			System.out.println(customer);
			retStr += customer.message + "\n";
		}
		return retStr;
	}
	
	@RequestMapping(value = "/vcap, method = RequestMethod.GET")
	public String vCap( ) {
		return System.getenv("VCAP_SERVICES");
	}
	
}