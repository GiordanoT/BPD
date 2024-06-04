package it.disim.univaq.bpd.example.services;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

@Service("myService")
public class MyService {
	
	public int initialize() {
		int counter = 0;
		System.out.println(counter);
		return counter;
	}

	public void increment(DelegateExecution execution) {
		int counter = (int) execution.getVariable("counter");
		counter = counter + 1;
		execution.setVariable("counter", counter);
		System.out.println(counter);
	}
	
	public void decrement(DelegateExecution execution) {
		int counter = (int) execution.getVariable("counter");
		execution.setVariable("counter", counter);
		counter = counter - 1;
		System.out.println(counter);
	}
	
	public void print(DelegateExecution execution, String variableName) {
		System.out.println(execution.getVariable(variableName).toString());
	}
	
	public void debugger(DelegateExecution execution) {
		System.out.println(execution.getVariables());
	}

}
