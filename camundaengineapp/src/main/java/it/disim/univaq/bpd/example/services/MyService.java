package it.disim.univaq.bpd.example.services;

import org.springframework.stereotype.Service;

@Service("myService")
public class MyService {
	
	public void print(String value) {
		System.out.println(value);
	}
	
	public void write() {}
	
}
