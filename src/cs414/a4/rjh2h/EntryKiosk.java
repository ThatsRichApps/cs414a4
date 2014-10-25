package cs414.a4.rjh2h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.text.DateFormatter;

import cs414.a4.rjh2h.ui.EntryKioskUI;
import cs414.a4.rjh2h.ui.PhysicalTicketUI;

public class EntryKiosk extends Observable implements Observer, ActionListener {

	private EntryKioskUI entryUI;
	private ParkingGarage garage;
	private boolean isGarageOpen;
	private Gate entryGate;
	private Ticket currentTicket;
	private int ticketNumber = 0; 
	
	
	public EntryKiosk() {
	
	}
	
	public EntryKiosk(ParkingGarage garage) {
	
		// set the garage as observer, notify as cars enter
		this.garage = garage;
		this.addObserver(garage);
		
		// create the entry ui and listen for it's button
		entryUI = new EntryKioskUI();
		entryUI.addButtonActionListener(this);
		
		// create the entry Gate and make sure it starts closed
		entryGate = new Gate();
		entryGate.closeGate();
		
		entryUI.setGateStatus(true);
		
		entryGate.addObserver(this);
		
	}

	@Override
	public String toString() {
		return "EntryKiosk";
	}

	public void update(Observable o, Object arg) {
		// Entry observes the ParkingGarage.  If garage is closed, entry is not allowed.
		
		System.out.println("Update called:" + o + ":" + arg);
		
		if (arg == "GateOpen") {
			entryUI.setGateStatus(true);
			System.out.println("set gate status open");
			
		} else if (arg == "GateClosed") {
			entryUI.setGateStatus(false);
		} else {
		    isGarageOpen = (boolean) arg;
		    if (isGarageOpen == true) {
		    	entryUI.setMessage1("Press Top Button to Enter");
		    	entryUI.setMessage2("");
		    } else {
		    	entryUI.setMessage1("Garage is Full");
		    	entryUI.setMessage2("");
		    }
	
		    entryUI.enableEnterButton(isGarageOpen);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
    
		String cmd = e.getActionCommand();
	    
		switch (cmd) {
		
		case "EnterButton": 
			
			// first the driver presses the enter button, this creates a ticket
			ticketNumber++;
			
			// if the rate changes, this driver only has to pay the rate at the time
			// that the ticket is tendered, therefore, we store this on / with the ticket
			BigDecimal currentRate = garage.getSystemPreferences().getHourlyFee();
			
			currentTicket = new Ticket(ticketNumber, currentRate);
			
			Date timeIn = currentTicket.getTimeIn();
			SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM yyyy HH:mm z");

			String dateOut = dateFormatter.format(timeIn);

			String entryMessage = "Time is " + dateOut;
			
			
			String entryMessage2 = " License: " + 
					currentTicket.getAutomobile().getLicensePlateNumber() + " State: " + 
					currentTicket.getAutomobile().getLicenseStateCode();
			
			entryUI.setMessage1(entryMessage);
			entryUI.setMessage2(entryMessage2);
			
			entryUI.enableTicketButtons(true);
			entryUI.enableEnterButton(false);
			
			break;
			
		case "DispenseTicketButton":

			entryUI.enableTicketButtons(false);
			entryUI.enableEnterButton(true);

			PhysicalTicketUI printedTicket = new PhysicalTicketUI(currentTicket);	
			
			garage.addPhysicalTicket(currentTicket);
			
			entryUI.setMessage1("Press Top Button to Enter");
	    	entryUI.setMessage2("");
	    	
			setChanged();
			notifyObservers("entry");
			
			entryGate.openGateForCar();

			break;
			
		case "VirtualTicketButton":

			entryUI.enableTicketButtons(false);
			entryUI.enableEnterButton(true);

			garage.addVirtualTicket(currentTicket);
		
			entryUI.setMessage1("Press Top Button to Enter");
	    	entryUI.setMessage2("");
	    	
			setChanged();
			notifyObservers("entry");

			entryGate.openGateForCar();

			break;
			
		
		}
			
		
	}
	
	
	
	
}