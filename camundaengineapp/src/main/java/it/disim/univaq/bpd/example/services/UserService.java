package it.disim.univaq.bpd.example.services;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.disim.univaq.bpd.example.data.BookingInput;
import it.disim.univaq.bpd.example.data.User;

@Service("userService")
public class UserService {
	
	public String endpoint(BookingInput input) {
		String url = "http://localhost:9080/user/" + input.username;
		System.out.println("Genereting url: " + url);
		return url;
	}
	
	public User output(String response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
    		JsonNode userJson = mapper.readTree(response);
    		String username = userJson.get("username").toString();
    		String name = userJson.get("name").toString();
    		String surname = userJson.get("surname").toString();
    		String taxCode = userJson.get("taxCode").toString();
    		String address = userJson.get("address").toString();
    		String city = userJson.get("city").toString();
    		String zipCode = userJson.get("zipCode").toString();
    		String phone = userJson.get("phone").toString();
    		String email = userJson.get("email").toString();
    		return new User(username, name, surname, taxCode, address, city, zipCode, phone, email);
        } catch (Exception e) {
			System.out.println(e);
			return new User();
		}
	}

}
