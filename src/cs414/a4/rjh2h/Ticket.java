package cs414.a4.rjh2h;

import java.util.Date;

public class Ticket {
	
	private Date timeIn;
	private Automobile automobile;
	private int ticketNumber;
	
	public Ticket(int ticketNumber) {
		
		// set unique ticket number
		this.ticketNumber = ticketNumber;
		
		// get the current time
		timeIn = new Date();
		
		// get the info for the current automobile
		automobile = new Automobile();
		
	}
	
	public int getTicketNumber() {
		return this.ticketNumber;
	}
	
	public Date getTimeIn() {
		return timeIn;
	}

	public Automobile getAutomobile() {
		return automobile;
	}

}
