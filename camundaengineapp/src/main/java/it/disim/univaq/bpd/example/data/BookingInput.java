package it.disim.univaq.bpd.example.data;

import java.io.Serializable;

/* REST API */
public class BookingInput implements Serializable {
	private static final long serialVersionUID = 1L;
	public String username;
	public String[] cities;
	public String posterFormat;
	public float price;
	
	public BookingInput(String username, String[] cities, String posterFormat, float price) {
		this.username = username;
		this.cities = cities;
		this.posterFormat = posterFormat;
		this.price = price;
	}
	
	public BookingInput() {}
}
