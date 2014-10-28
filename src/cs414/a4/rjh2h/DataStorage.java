package cs414.a4.rjh2h;

import java.util.Date;
import java.util.HashMap;

import cs414.a4.rjh2h.ui.SysAdminUI;

public class DataStorage {
	
	private HashMap<String, Ticket> virtualTicketMap = new HashMap<String, Ticket>();
	private HashMap<Integer, Ticket> physicalTicketMap = new HashMap<Integer, Ticket>();
	private HashMap<Date, Integer> occupancyData = new HashMap<Date, Integer>();
	
	public DataStorage() {
		
		// initialize any test data here
		
	}
	
	public HashMap<String, Ticket> getVirtualTicketMap() {
		return virtualTicketMap;
	}

	public HashMap<Integer, Ticket> getPhysicalTicketMap() {
		return physicalTicketMap;
	}

	public void setVirtualTicketMap(HashMap<String, Ticket> virtualTicketMap) {
		this.virtualTicketMap = virtualTicketMap;
	}

	public void setPhysicalTicketMap(HashMap<Integer, Ticket> physicalTicketMap) {
		this.physicalTicketMap = physicalTicketMap;
	}
	
	public void addVirtualTicket(Ticket ticket) {
		
		String key = ticket.getAutomobile().getLicensePlate();
		
		System.out.println("license: " + key);
		
		virtualTicketMap.put(key, ticket);
		
	}
	
	
	public void addPhysicalTicket(Ticket ticket) {
		
		int key = ticket.getTicketNumber();
		
		physicalTicketMap.put(key, ticket);
		
	}

	public Ticket getTicketNumber (int ticketNumber) {
		
		return physicalTicketMap.get(ticketNumber);
		
	}

	public Ticket getTicketForLicensePlate (String licensePlate) {
		
		return virtualTicketMap.get(licensePlate);
		
	}
	
	public void updateOccupancyData (Date timestamp, int occupancy) {
		
		occupancyData.put(timestamp,  occupancy);
		
	}

	

}
