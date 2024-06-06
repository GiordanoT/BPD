package it.disim.univaq.bpd.example.data;

import java.io.Serializable;

public class DecisionInput implements Serializable {
	private static final long serialVersionUID = 1L;
	public String requestId;
	public String decision;
	
	public DecisionInput(String requestId, String decision) {
		this.requestId = requestId;
		this.decision = decision;
	}
	
	public DecisionInput() {}
}
