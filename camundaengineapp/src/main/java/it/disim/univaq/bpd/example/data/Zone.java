package it.disim.univaq.bpd.example.data;

import java.io.Serializable;

public class Zone implements Serializable {
	private static final long serialVersionUID = 1L;
	public String id;
	public String name;
	public String city;
	public float price;
	
	public Zone(String id, String name, String city, float price) {
		this.id = id.replaceAll("\"", "");
		this.name = name.replaceAll("\"", "");
		this.city = city.replaceAll("\"", "");
		this.price = price;
	}
	
	public Zone() {}
}
