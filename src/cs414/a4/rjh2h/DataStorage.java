package cs414.a4.rjh2h;

import java.util.Date;
import java.util.HashMap;

public class DataStorage {
	
	private HashMap<String, Ticket> virtualTicketMap = new HashMap<String, Ticket>();
	private HashMap<Integer, Ticket> physicalTicketMap = new HashMap<Integer, Ticket>();
	private HashMap<Date, Integer> occupancyData = new HashMap<Date, Integer>();
	private HashMap<Integer, Transaction> transactionRecords = new HashMap<Integer, Transaction>();
	private int transactionID = 0;
	
	public DataStorage() {
		
		// initialize any pre startup test data here
		
	}
	
	@Override
	public String toString() {
		return "DataStorage";
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
		String key = ticket.getVehicle().getLicensePlate();
		virtualTicketMap.put(key, ticket);
	}
	
	public void addPhysicalTicket(Ticket ticket) {
		int key = ticket.getTicketNumber();
		physicalTicketMap.put(key, ticket);
	}

	public Ticket getTicketByNumber (int ticketNumber) {
		// lookup the ticket by number 
		Ticket ticket = physicalTicketMap.get(ticketNumber);
		// ticket can only be used once, so remove it
		physicalTicketMap.remove(ticketNumber);
		return ticket;
	}

	public Ticket getTicketForLicensePlate (String licensePlate) {
		Ticket ticket = virtualTicketMap.get(licensePlate);
		// ticket can only be used once, so remove it
		virtualTicketMap.remove(licensePlate);
		return ticket;
	}
	
	public void saveTransaction (Transaction transaction) {
		// increment the transaction id and use it as a key
		transactionID++;
		transactionRecords.put(transactionID, transaction);
	}
	
	
	public void updateOccupancyData (Date timestamp, int occupancy) {
		
		occupancyData.put(timestamp,  occupancy);
		
	}

	

}
