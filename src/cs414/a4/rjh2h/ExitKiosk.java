package cs414.a4.rjh2h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import cs414.a4.rjh2h.ui.ExitKioskUI;
import cs414.a4.rjh2h.ui.RegisterUI;

public class ExitKiosk extends Observable implements ActionListener {

	// Parking Garage observes ExitKiosk to know when cars leave
	
	private ExitKioskUI exitUI;
	private ParkingGarage garage;
	private RegisterUI registerUI;
	
	public ExitKiosk() {
		
	}
	
	public ExitKiosk(ParkingGarage garage) {
		// set the garage as the observer to track car exit
		this.garage = garage;
		this.addObserver(garage);
		
		// create the exit kiosk UI and listen for button press
		exitUI = new ExitKioskUI();
		exitUI.addButtonActionListener(this);
		
		// create a registerUI to go with this too
		
		
		registerUI = new RegisterUI();
			
	}
	

	@Override
	public String toString() {
		return "ExitKiosk";
	}

	public void actionPerformed(ActionEvent event) {
		
		String eventName = event.getActionCommand();
		
		//System.out.println("Event triggered:" + eventName);
		//System.out.println("Ticket Number:" + ticketNumber);
		
		int ticketNumber = exitUI.getTicketNumber();
		
		exitUI.setMessage("Pressed Exit Button");
		
		Ticket thisTicket = garage.getTicketNumber(ticketNumber);
		
		if (thisTicket == null) {
			// handle ticket not found
			exitUI.setMessage("Ticket Not Found");
			
		} else {
		
			//System.out.println("TimeIn for:" + ticketNumber + ":" + thisTicket.getTimeIn());
			
			Transaction transaction = new Transaction(thisTicket);
			
			//System.out.println("TimeOut:" + transaction.getTimeOut());
			//System.out.println("You owe:" + transaction.getAmount());
			
			exitUI.setBottomMessage("You owe: $" + transaction.getAmount());
			
			setChanged();
			notifyObservers("exit");
		}
		
	}
	
	
	
	
	
	
	
	
}
