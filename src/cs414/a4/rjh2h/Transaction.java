package cs414.a4.rjh2h;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	
	private Date timeOut;
	private BigDecimal amount;
	private Ticket ticket;
	
	public Transaction () {
	}
	
	public Transaction(Ticket ticket) {
		
		this.ticket = ticket;
		
		// set timeOut to creation time
		setTimeOut();
	
		// determine fees based upon ticket
		this.amount = calculateFees();
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public Date getTimeOut() {
		return this.timeOut;
	}
	
	public void setTimeOut() {
		this.timeOut = new Date();
	}

	public BigDecimal calculateFees (){
	
		BigDecimal rate = ticket.getRate();
		
		Date timeIn = ticket.getTimeIn();
		
		// determine the number of hours in the garage
		double timeDifference = timeOut.getTime() - timeIn.getTime(); 
		double diffHours = timeDifference / (60 * 60 * 1000) % 24;
		
		// now round up to the next hour
		diffHours = Math.ceil(diffHours);
		
		BigDecimal amountOwed = rate.multiply(new BigDecimal(diffHours));
		
		return (amountOwed);
	
	}
	
	
	
}
