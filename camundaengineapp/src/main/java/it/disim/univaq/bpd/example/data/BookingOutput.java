package it.disim.univaq.bpd.example.data;

import java.io.Serializable;
import java.util.List;

/* REST API */
public class BookingOutput implements Serializable {
	private static final long serialVersionUID = 1L;
	public String requestId;
	public boolean available;
	public List<Zone> zones;
	public float price;
	
	public BookingOutput(String requestId, boolean available, List<Zone> zones, float price) {
		this.requestId = requestId;
		this.available = available;
		this.zones = zones;
		this.price = price;
	}
	
	public BookingOutput() {}
}
