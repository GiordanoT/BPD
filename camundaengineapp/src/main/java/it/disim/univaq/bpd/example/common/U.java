package it.disim.univaq.bpd.example.common;

import java.util.ArrayList;

import it.disim.univaq.bpd.example.data.Zone;

public class U {
	public static String formatZones(ArrayList<Zone> zones) {
		String zonesString = "";
        for (Zone zone: zones) {
        	zonesString += "\n"
        			+ "            <pos:zone>\r\n"
        			+ "               <pos:id>" + zone.id + "</pos:id>\r\n"
        			+ "               <pos:city>" + zone.city + "</pos:city>\r\n"
        			+ "            </pos:zone>\r\n";
        }
        return zonesString;
	}
}
