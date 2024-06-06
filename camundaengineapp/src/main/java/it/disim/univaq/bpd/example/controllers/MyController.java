package it.disim.univaq.bpd.example.controllers;

import java.util.List;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationResultWithVariables;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.disim.univaq.bpd.example.data.Availability;
import it.disim.univaq.bpd.example.data.BookingInput;
import it.disim.univaq.bpd.example.data.BookingOutput;
import it.disim.univaq.bpd.example.data.DecisionOutput;
import it.disim.univaq.bpd.example.data.DecisionInput;
import it.disim.univaq.bpd.example.data.DecisionOutput;
import it.disim.univaq.bpd.example.data.Zone;

@RestController
public class MyController {

	@Autowired
	private RuntimeService service;
	
	@PostMapping("book")
	public BookingOutput getInfo(@RequestBody BookingInput request) {
		System.out.println("Booking Info received!");
		BookingInput input = new BookingInput(request.username, request.cities, request.posterFormat, request.price);
		
		MessageCorrelationResultWithVariables correlation = service
			.createMessageCorrelation("booking-info")
			.setVariable("bookingInput", input)
			.correlateWithResultAndVariables(false);
		
		VariableMap variables = correlation.getVariables();
		Availability availibility = (Availability) variables.get("availability");
		List<Zone> zones = (List<Zone>) variables.get("zones");
		float price = 0;
		for(Zone zone: zones) {
			price = price + zone.price;
		}
		return new BookingOutput(availibility.requestId, availibility.available, zones, price);
	}

	@PostMapping("decision")
	public DecisionOutput getDecision(@RequestBody DecisionInput request) {
		System.out.println("Decision received!");
		DecisionInput input = new DecisionInput(request.requestId, request.decision);
		
		MessageCorrelationResultWithVariables correlation = service
				.createMessageCorrelation("decision")
				.setVariable("decisionInput", input)
				.correlateWithResultAndVariables(false);

		VariableMap variables = correlation.getVariables();
		DecisionOutput confirmation = (DecisionOutput) variables.get("response");
		return confirmation;
	}
	
}
