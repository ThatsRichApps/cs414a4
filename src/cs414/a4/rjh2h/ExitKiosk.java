package cs414.a4.rjh2h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class ExitKiosk extends Observable implements ActionListener {

	// Parking Garage observes ExitKiosk to know when cars leave
	
	private ExitKioskUI exitUI;
	private ParkingGarage garage;
	
	public ExitKiosk() {
		
	}
	
	public ExitKiosk(ParkingGarage garage) {
		// set the garage as the observer to track car exit
		this.garage = garage;
		this.addObserver(garage);
		
		// create the exit kiosk UI and listen for button press
		exitUI = new ExitKioskUI();
		exitUI.addButtonActionListener(this);
		
	}
	

	@Override
	public String toString() {
		return "ExitKiosk";
	}

	public void actionPerformed(ActionEvent e) {
    
		exitUI.setMessage("Pressed Exit Button");
		setChanged();
		notifyObservers("exit");
		
	}
	
	
	
	
	
	
	
	
}
