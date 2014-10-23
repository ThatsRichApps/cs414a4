package cs414.a4.rjh2h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class EntryKiosk extends Observable implements Observer, ActionListener {

	private EntryKioskUI entryUI;
	private ParkingGarage garage;
	private boolean isGarageOpen;
	private Gate entryGate;
	
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
		
		
	}

	@Override
	public String toString() {
		return "EntryKiosk";
	}

	public void update(Observable o, Object arg) {
		// Entry observes the ParkingGarage.  If garage is closed, entry is not allowed.
		
	    isGarageOpen = (boolean) arg;
	    if (isGarageOpen == true) {
	    	entryUI.setMessage("Please Take Your Ticket");
	    } else {
	    	entryUI.setMessage("Garage is Full");
	    }

	    entryUI.setButtonEnabled(isGarageOpen);
	    
	}
	
	public void actionPerformed(ActionEvent e) {
    
		// first the driver presses the enter button, this creates a ticket
		entryUI.setMessage("Thank You");
		setChanged();
		notifyObservers("entry");
		
		
		
		
		
		
		
	}
	
	
	
	
}