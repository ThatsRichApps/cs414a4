package cs414.a4.rjh2h;

import java.math.BigDecimal;

public abstract class Payment {
	
	protected BigDecimal amountDue;
	
	public abstract boolean initiatePayment();

	public Payment(BigDecimal amountDue) {
		super();
		this.amountDue = amountDue;
	}

	public BigDecimal getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}
	
}
