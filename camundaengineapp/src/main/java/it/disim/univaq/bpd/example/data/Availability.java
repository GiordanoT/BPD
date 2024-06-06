package it.disim.univaq.bpd.example.data;

import java.io.Serializable;

public class Availability implements Serializable {
	private static final long serialVersionUID = 1L;
	public String requestId;
	public boolean available;
	
	public Availability(String requestId, String available) {
		this.requestId = requestId.replaceAll("\"", "");
		this.available = Boolean.parseBoolean(available.replaceAll("\"", ""));
	}
	
	public Availability() {}
}
