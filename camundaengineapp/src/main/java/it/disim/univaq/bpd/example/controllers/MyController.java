package it.disim.univaq.bpd.example.controllers;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationResultWithVariables;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import it.disim.univaq.bpd.example.data.BookingInfo;

@RestController
public class MyController {

	@Autowired
	private RuntimeService service;
	
	@PostMapping("book")
	public String getInfo(@RequestBody BookingInfo obj) {
		System.out.println("Booking Info received!");
		
		String username = obj.username;
		String[] cities = obj.cities;
		String posterFormat = obj.posterFormat;
		float price = obj.price;
		if(username == "" || cities.length <= 0 || posterFormat == "" || price <= 0) return "Invalid Data!";
		
		service
			.createMessageCorrelation("booking-info")
			.setVariable("username", username)
			.setVariable("cities", cities)
			.setVariable("posterFormat", posterFormat)
			.setVariable("price", price)
			.correlate();
		
		return "Info received!";
	}

	@GetMapping("message-1")
	public VariableMap getMessageOne() {
		System.out.println("Message 1 received!");

		MessageCorrelationResultWithVariables correlation = service
				.createMessageCorrelation("message-1")
				.correlateWithResultAndVariables(false);

		return correlation.getVariables();
	}
	
	@GetMapping("message-2/{businessKey}")
	public void getMessageTwo(@PathVariable String businessKey) {
		System.out.println("Message 2 received!");

		service
			.createMessageCorrelation("message-2")
			.processInstanceBusinessKey(businessKey)
			.setVariable("counter", 100)
			.correlate();
	}


	@GetMapping("message-3/{variableValue}")
	public Integer getMessageThree(@PathVariable String variableValue) {
		System.out.println("Message 3 received!");

		MessageCorrelationResultWithVariables correlation = service
				.createMessageCorrelation("message-3")
				.setVariable("counter", Integer.parseInt(variableValue))
				.correlateWithResultAndVariables(false);

		return correlation.getVariables().getValue("counter", Integer.class);
	}
	
}
