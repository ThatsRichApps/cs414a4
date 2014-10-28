package cs414.a4.rjh2h;

import java.math.BigDecimal;
import java.util.Date;

public class Ticket {
	
	private Date timeIn;
	private Vehicle automobile;
	private int ticketNumber;
	private BigDecimal rate;
	
	public Ticket(int ticketNumber, BigDecimal rate) {
		
		// set unique ticket number
		this.ticketNumber = ticketNumber;
		
		// get the current time
		setTimeIn();
		
		// get the info for the current automobile
		automobile = new Vehicle();
		
		this.rate = rate;
		
	}
	
	public int getTicketNumber() {
		return this.ticketNumber;
	}
	
	public Date getTimeIn() {
		return timeIn;
	}

	public Vehicle getAutomobile() {
		return automobile;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setTimeIn () {
		this.timeIn = new Date();
	}
	
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

}
