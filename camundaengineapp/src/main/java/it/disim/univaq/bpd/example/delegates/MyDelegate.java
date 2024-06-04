package it.disim.univaq.bpd.example.delegates;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("myDelegate")
public class MyDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// int counter = (int) execution.getVariable("counter");
		// counter++;
		execution.setVariable("counter", 0);
	}

}
