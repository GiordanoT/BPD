package it.disim.univaq.bpd.example.data;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	public String username;
	public String name;
	public String surname;
	public String taxCode;
	public String address;
	public String city;
	public String zipCode;
	public String phone;
	public String email;
	
	public User(String username, String name, String surname, String taxCode, String address, String city, String zipCode, String phone, String email) {
		this.username = username.replaceAll("\"", "");
		this.name = name.replaceAll("\"", "");
		this.surname = surname.replaceAll("\"", "");
		this.taxCode = taxCode.replaceAll("\"", "");
		this.address = address.replaceAll("\"", "");
		this.city = city.replaceAll("\"", "");
		this.zipCode = zipCode.replaceAll("\"", "");
		this.phone = phone.replaceAll("\"", "");
		this.email = email.replaceAll("\"", "");
	}
	
	public User() {}
}
