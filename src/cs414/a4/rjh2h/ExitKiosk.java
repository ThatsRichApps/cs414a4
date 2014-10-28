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
		exitUI.addPayCashButtonActionListener(this);
		exitUI.addPayOnAccountButtonActionListener(this);
		exitUI.addCreditCardFieldActionListener(this);
		
		// create a gate and observe it's status
		exitGate = new Gate();	
		exitGate.addObserver(this);
		exitGate.closeGate();
		
		// create a cash register for taking payments
		register = new Register();
		
		currentTicket = null;
		currentTransaction = null;
				
	}

	@Override
	public String toString() {
		return "ExitKiosk";
	}

	public void actionPerformed(ActionEvent event) {
		
		String eventName = event.getActionCommand();
		
		System.out.println("event:" + eventName);
		
		String message = "";
		
		switch (eventName) {
		
		case "LicenseField":
			String licensePlate = exitUI.getLicensePlate();
			currentTicket = garage.getTicketForLicensePlate(licensePlate);
			message = "Fee by License: " + licensePlate;
			break;
		case "TicketField":
			int ticketNumber = exitUI.getTicketNumber();
			currentTicket = garage.getTicketNumber(ticketNumber);
			message = "Fee by Ticket: " + ticketNumber;
			break;
		case "LostTicket":
			break;
		case "PayCash":
			exitUI.enableFindTicketButtons(true);
			exitUI.enablePaymentTickets(false);
			break;
		case "PayOnAccount":
			exitUI.enableFindTicketButtons(true);
			exitUI.enablePaymentTickets(false);
			break;
		case "PayCreditCard":
			exitUI.enableFindTicketButtons(true);
			exitUI.enablePaymentTickets(false);
			break;
		}
		
		if (currentTicket == null) {
			// handle ticket not found
			exitUI.setMessage("Ticket Not Found");
			exitUI.setPaymentMessage("");
		} else {

			exitUI.setMessage(message);
			currentTransaction = new Transaction(currentTicket);
			exitUI.setPaymentMessage("You owe: $" + currentTransaction.getAmount());
			
			// now enable the payment buttons and disable find ticket buttons
			exitUI.enableFindTicketButtons(false);
			exitUI.enablePaymentTickets(true);
			
			register.setAmountDue(currentTransaction.getAmount());
			
			setChanged();
			notifyObservers("exit");
			
		}
		
	}

	public void openGate() {
		
		exitGate.openGateForCar();
		
	}
	
	
	public void update(Observable o, Object arg) {

		// Exit observes the exit gate, waits for cars to exit
		//System.out.println("Update called:" + o + ":" + arg);
		
		if (arg == "GateOpen") {
			exitUI.setGateStatus(true);
		} else if (arg == "GateClosed") {
			exitUI.setGateStatus(false);
		}
	
	}
	
}
