package cs414.a4.rjh2h;

import java.math.BigDecimal;

import cs414.a4.rjh2h.ui.RegisterUI;

public class Register {
	
	
	private RegisterUI registerUI;
	
	public Register() {
		
		registerUI = new RegisterUI();
		
		
	}
	
	public void setAmountDue(BigDecimal amount) {
		
		registerUI.setAmountDue(amount);
	
	}
	

}
