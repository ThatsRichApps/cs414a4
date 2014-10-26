package cs414.a4.rjh2h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import cs414.a4.rjh2h.ui.ExitKioskUI;
import cs414.a4.rjh2h.ui.RegisterUI;

public class ExitKiosk extends Observable implements Observer,ActionListener {

	// Parking Garage observes ExitKiosk to know when cars leave
	
	private ExitKioskUI exitUI;
	private ParkingGarage garage;
	private RegisterUI registerUI;
	private Gate exitGate;
	
	public ExitKiosk() {
		
	}
	
	public ExitKiosk(ParkingGarage garage) {
		// set the garage as the observer to track car exit
		this.garage = garage;
		this.addObserver(garage);
		
		// create the exit kiosk UI and listen for actions
		exitUI = new ExitKioskUI();
		exitUI.addButtonActionListener(this);
		exitUI.addTicketFieldActionListener(this);
		exitUI.addLicenseFieldActionListener(this);
		
		// create a gate and observe it's status
		// create the entry Gate and make sure it starts closed
		exitGate = new Gate();	
		exitGate.addObserver(this);
		exitGate.closeGate();
		
		// create a cash register ui for taking payments
		registerUI = new RegisterUI();
			
	}
	

	@Override
	public String toString() {
		return "ExitKiosk";
	}

	public void actionPerformed(ActionEvent event) {
		
		String eventName = event.getActionCommand();
		
		System.out.println("event:" + eventName);
		
		Ticket thisTicket = null;
		
		switch (eventName) {
		
		case "DetermineFees":
			exitUI.setMessage("Determine Fees");

			break;
		case "LicenseField":
			exitUI.setMessage("License field");

			String licensePlate = exitUI.getLicensePlate();
			thisTicket = garage.getTicketForLicensePlate(licensePlate);
			
			break;
		case "TicketField":
			exitUI.setMessage("Ticket Num");
			int ticketNumber = exitUI.getTicketNumber();
			thisTicket = garage.getTicketNumber(ticketNumber);

			break;
		}
		
		if (thisTicket == null) {
			// handle ticket not found
			exitUI.setMessage("Ticket Not Found");
			exitUI.setBottomMessage("");
		} else {
		
			Transaction transaction = new Transaction(thisTicket);
			exitUI.setBottomMessage("You owe: $" + transaction.getAmount());
			setChanged();
			notifyObservers("exit");

		}
		
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
