package it.disim.univaq.bpd.example.services;

import java.io.FileWriter;
import org.springframework.stereotype.Service;

import it.disim.univaq.bpd.example.data.DecisionInput;
import it.disim.univaq.bpd.example.data.DecisionOutput;
import it.disim.univaq.bpd.example.data.User;

@Service("myService")
public class MyService {
	
	public void print(String value) {
		System.out.println(value);
	}
	
	public void write(User user, DecisionInput input, DecisionOutput response) {
        String filename = "posting-requests.txt";
        String data = user.username + ", " + input.requestId + ", " + response.invoiceNumber + ", " + response.amountDue + ";";
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(data + "\n");
            System.out.println("File wrote successfully!");
        } catch (Exception e) {
            System.err.println("Error writing the file!");
        }
	}
	
}
