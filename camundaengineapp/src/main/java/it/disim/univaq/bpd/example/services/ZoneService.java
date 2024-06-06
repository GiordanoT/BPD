package it.disim.univaq.bpd.example.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.disim.univaq.bpd.example.data.BookingInput;
import it.disim.univaq.bpd.example.data.Zone;


@Service("zoneService")
public class ZoneService {
	
	public String endpoint(BookingInput input) {
		String url = "http://localhost:9090/zones/" + input.posterFormat;
		System.out.println("Genereting url: " + url);
		return url;
	}
	
	public List<Zone> output(String response, BookingInput input) {
        ObjectMapper mapper = new ObjectMapper();
        List<Zone> _zones = new ArrayList<Zone>();
        try {
    		JsonNode zonesJson = mapper.readTree(response);
    		for (JsonNode zoneJson: zonesJson) {
        		String id = zoneJson.get("id").toString();
        		String name = zoneJson.get("name").toString();
        		String city = zoneJson.get("city").toString();
        		float price = Float.parseFloat(zoneJson.get("price").toString());
            	for(String chosenCity: input.cities) {
            		if(chosenCity.equals(city.replaceAll("\"", ""))) {
            			_zones.add(new Zone(id, name, city, price));
            		}
            	}
    		}
        } catch (Exception e) {
			System.out.println(e);
		}
        _zones.sort((a, b) -> Float.compare(b.price, a.price));
        List<Zone> zones = new ArrayList<Zone>();
        float price = 0;
        for(Zone zone: _zones) {
        	if(price + zone.price > input.price) {
        		continue;
        	}
        	else {
        		zones.add(zone);
        		price += zone.price;
        	}
        }
        return zones;
	}

}
