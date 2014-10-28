package cs414.a4.rjh2h;

import java.math.BigDecimal;

public class CreditCard {

	private String cardNumber;
	@SuppressWarnings("unused")
	private int expMonth;
	@SuppressWarnings("unused")
	private int expYear;
	@SuppressWarnings("unused")
	private int cvv;
	private BigDecimal totalCharged;
	
	public CreditCard() {
		
	}
	
	public CreditCard (String cardNumber) {
		this.cardNumber = cardNumber;
		this.totalCharged = new BigDecimal(0);
		this.expMonth = 10;
		this.expYear = 2015;
		this.cvv = 888;
	}
	
	public boolean chargeCard(BigDecimal amount) {
		// assume that this method connects to
		// verification system and charges the card
		
		// set bogus card number for false tests
		if (this.cardNumber == "1111 1111 1111 1111") {
			return (false);
		}
		
		// track the total amount charged on this card
		this.totalCharged = this.totalCharged.add(amount);
		
		return (true);
	}
	
	
	
}
