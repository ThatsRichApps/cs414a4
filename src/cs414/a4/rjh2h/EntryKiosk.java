package cs414.a4.rjh2h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class EntryKiosk extends Observable implements Observer, ActionListener {

	//private EntryKioskUI entryUI = new EntryKioskUI();
	private EntryKioskUI entryUI;
	private ParkingGarage garage;
	
	public EntryKiosk(ParkingGarage garage) {
	
		this.garage = garage;
		entryUI = new EntryKioskUI();
		entryUI.addButtonActionListener(this);
		
		this.addObserver(garage);
		
	}

	public void update(Observable o, Object arg) {
	    System.out.println("Garage Changed: " + arg);
	    
	    String garageState;
	    boolean isOpen = (boolean) arg;
	    
	    if (isOpen == true) {
	    	garageState = "Open";
	    } else {
	    	garageState = "Closed";
	    }
	    	
	    
	}
	
	public void actionPerformed(ActionEvent e) {
    
		entryUI.setMessage("Pressed Enter Button");
	
		setChanged();
		notifyObservers();
		
	}
	
	
	
	
}