package it.disim.univaq.bpd.example.services;

import java.util.ArrayList;
import org.camunda.spin.impl.xml.dom.DomXmlElement;
import org.camunda.spin.xml.SpinXmlElement;
import org.springframework.stereotype.Service;
import it.disim.univaq.bpd.example.common.U;
import it.disim.univaq.bpd.example.data.Availability;
import it.disim.univaq.bpd.example.data.User;
import it.disim.univaq.bpd.example.data.Zone;


@Service("postingService")
public class PostingService {
	
	public String endpoint() {
		String url = "http://localhost:8888/postingservice";
		System.out.println("Genereting url: " + url);
		return url;
	}
	
	public Availability availabilityOutput(DomXmlElement response) {
		SpinXmlElement body = response.childElement("Body");
		SpinXmlElement availabilityResponse = body.childElement("http://disim.univaq.it/services/postingservice", "availabilityResponse");
		String requestId = availabilityResponse.childElement("requestId").textContent();
		String available = availabilityResponse.childElement("available").textContent();
		return new Availability(requestId, available);
	}
	
	public String availabilityInput(User user, String posterFormat, ArrayList<Zone> zones) {
   		String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pos=\"http://disim.univaq.it/services/postingservice\">\r\n"
			+ "   <soapenv:Header/>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <pos:availabilityRequest>\r\n"
			+ "         <pos:applicant>\r\n"
			+ "            <pos:name>" + user.name + "</pos:name>\r\n"
			+ "            <pos:surname>" + user.surname + "</pos:surname>\r\n"
			+ "            <pos:taxCode>" + user.taxCode + "</pos:taxCode>\r\n"
			+ "            <pos:address>" + user.address + "</pos:address>\r\n"
			+ "            <pos:city>" + user.city + "</pos:city>\r\n"
			+ "            <pos:zip>" + user.zipCode + "</pos:zip>\r\n"
			+ "            <pos:email>" + user.email + "</pos:email>\r\n"
			+ "         </pos:applicant>\r\n"
			+ "         <pos:posting>\r\n"
			+ "            <pos:posterFormat>" + posterFormat + "</pos:posterFormat>\r\n"
			+ U.formatZones(zones)
			+ "         </pos:posting>\r\n"
			+ "      </pos:availabilityRequest>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
   		return payload;
	}

}
