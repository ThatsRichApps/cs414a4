package cs414.a4.rjh2h;

import java.math.BigDecimal;
import java.util.Date;

public class Ticket {
	
	private Date timeIn;
	private Automobile automobile;
	private int ticketNumber;
	private BigDecimal rate;
	
	public Ticket(int ticketNumber, BigDecimal rate) {
		
		// set unique ticket number
		this.ticketNumber = ticketNumber;
		
		// get the current time
		timeIn = new Date();
		
		// get the info for the current automobile
		automobile = new Automobile();
		
		this.rate = rate;
		
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

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

}
