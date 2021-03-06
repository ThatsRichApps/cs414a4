package cs414.a4.rjh2h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import cs414.a4.rjh2h.ui.ExitKioskUI;

public class ExitKiosk extends Observable implements Observer,ActionListener {

	// Parking Garage observes ExitKiosk to know when cars leave
	
	private ExitKioskUI exitUI;
	private ParkingGarage garage;
	private Register register;
	private Gate exitGate;
	private Ticket currentTicket;
	private Transaction currentTransaction;
	
	public ExitKiosk() {
		
	}
	
	public ExitKiosk(ParkingGarage garage) {
		// set the garage as the observer to track car exit
		this.garage = garage;
		this.addObserver(garage);
		
		// create the exit kiosk UI and listen for actions
		exitUI = new ExitKioskUI();
		
		// Add the ExitKiosk (this) as the Action Listener for UI Actions
		exitUI.addTicketFieldActionListener(this);
		exitUI.addLicenseFieldActionListener(this);
		exitUI.addLostTicketButtonActionListener(this);
		
		exitUI.addPayCashButtonActionListener(this);
		exitUI.addPayOnAccountButtonActionListener(this);
		exitUI.addCreditCardFieldActionListener(this);
		
		// create a gate and observe it's status
		exitGate = new Gate();	
		exitGate.addObserver(this);
		exitGate.closeGate();
		
		// create a cash register for taking payments
		register = new Register();
		// pass the exitGate so that the cashier can open it too
		register.setExitKiosk(this);
		
		currentTicket = null;
		currentTransaction = null;
				
	}

	@Override
	public String toString() {
		return "ExitKiosk";
	}

	public void actionPerformed(ActionEvent event) {
		
		String eventName = event.getActionCommand();
		
		switch (eventName) {

		case "TicketField":
			lookupTicket();
			break;
		case "LicenseField":
			lookupLicense();
			break;
		case "LostTicket":
			lostTicket();
			break;
		case "PayCash":
			exitUI.enableFindTicketButtons(false);
			exitUI.enablePaymentFields(false);
			currentTransaction.createCashPayment();
			register.validatePayment(currentTransaction);
			break;
		case "PayOnAccount":
			exitUI.enableFindTicketButtons(false);
			exitUI.enablePaymentFields(false);
			currentTransaction.createAccountPayment();
			register.validatePayment(currentTransaction);
			break;
		case "PayCreditCard":
			exitUI.enableFindTicketButtons(false);
			exitUI.enablePaymentFields(false);
			String creditCardNumber = exitUI.getCreditCardNumber();
			currentTransaction.createCreditPayment(creditCardNumber);
			register.validatePayment(currentTransaction);
			break;
		}
				
	}

	private void lookupTicket() {
		
		int ticketNumber = exitUI.getTicketNumber();
		currentTicket = garage.getTicketNumber(ticketNumber);
		
		if (currentTicket == null) {
			// handle ticket not found
			exitUI.setMessage("Ticket Not Found");
			exitUI.setPaymentMessage("");
		} else {
			currentTransaction = new Transaction(currentTicket);
			String message = "Fee by Ticket: " + ticketNumber;
			exitUI.setMessage(message);
			exitUI.setPaymentMessage("You owe: $" + currentTransaction.getAmount());
			register.setCurrentTransaction(currentTransaction);
		
			// now enable the payment buttons and disable find ticket buttons
			exitUI.enableFindTicketButtons(false);
			exitUI.enablePaymentFields(true);
		}
		
	}
	
	private void lookupLicense() {
		String licensePlate = exitUI.getLicensePlate();
		currentTicket = garage.getTicketForLicensePlate(licensePlate);
		if (currentTicket == null) {
			// handle ticket not found
			exitUI.setMessage("Ticket Not Found");
			exitUI.setPaymentMessage("");
		} else {
			currentTransaction = new Transaction(currentTicket);
			String message = "Fee by License: " + licensePlate;
			exitUI.setMessage(message);
			exitUI.setPaymentMessage("You owe: $" + currentTransaction.getAmount());
			register.setCurrentTransaction(currentTransaction);

			// now enable the payment buttons and disable find ticket buttons
			exitUI.enableFindTicketButtons(false);
			exitUI.enablePaymentFields(true);
		}
	}
	
	private void lostTicket() {
		currentTicket = new Ticket();  // create a dummy ticket
		currentTransaction = new Transaction(garage.getSystemPreferences().getMaxFee());
		String message = "Lost Ticket, Max Fee ";
		exitUI.setMessage(message);
		exitUI.setPaymentMessage("You owe: $" + currentTransaction.getAmount());
		register.setCurrentTransaction(currentTransaction);

		// now enable the payment buttons and disable find ticket buttons
		exitUI.enableFindTicketButtons(false);
		exitUI.enablePaymentFields(true);
	}
	
	public void openGate() {
		setChanged();
		notifyObservers("exit");
		//register.resetUI();
		garage.saveTransaction(currentTransaction);
		
		currentTicket = null;
		currentTransaction = null;
		exitUI.setMessage("");
		exitUI.setPaymentMessage("");
		exitUI.enableFindTicketButtons(true);
		exitUI.enablePaymentFields(false);
		exitGate.openGateForCar();
	}
	
	public void update(Observable o, Object arg) {

		// Exit observes the exit gate, waits for cars to exit
		if (arg == "GateOpen") {
			exitUI.setGateStatus(true);
		} else if (arg == "GateClosed") {
			exitUI.setGateStatus(false);
		}
	
	}
	
}
