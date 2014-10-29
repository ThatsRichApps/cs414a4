package cs414.a4.rjh2h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import cs414.a4.rjh2h.ui.RegisterUI;

public class Register implements ActionListener {
	
	private RegisterUI registerUI;
	private ExitKiosk exitKiosk;
	private Transaction currentTransaction;
	
	public Register() {
		registerUI = new RegisterUI();
		registerUI.addAllActionListeners(this);
	}

	public void setExitKiosk(ExitKiosk exitKiosk) {
		this.exitKiosk = exitKiosk;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public boolean validatePayment(Transaction transaction) {
		String paymentType = transaction.getPayment().toString();
		return (true);
	}
	
	public void setAmountDue(BigDecimal amount) {
		registerUI.setAmountDue(amount);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
	
		String eventName = event.getActionCommand();
		
		switch (eventName) {

		case "OpenGate":
			this.exitKiosk.openGate();	
			break;
		case "CashField":
			// get cash tendered and set changeDue amount
			break;
		case "Paid":
			break;
			
		}
		
	}
	
	public void resetUI() {
		// reset the ui after payment or no charge
		
	}
	
	
	
	
	
	

}
