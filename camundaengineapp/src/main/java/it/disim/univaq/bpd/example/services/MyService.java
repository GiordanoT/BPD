package it.disim.univaq.bpd.example.services;

import java.io.FileWriter;
import org.springframework.stereotype.Service;
import it.disim.univaq.bpd.example.data.DecisionOutput;

@Service("myService")
public class MyService {
	
	public void print(String value) {
		System.out.println(value);
	}
	
	public void write(DecisionOutput response) {
        String filename = "confirmation.txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(response.toString());
            System.out.println("File created successfully!");
        } catch (Exception e) {
            System.err.println("Error writing the file!");
        }
	}
	
}
