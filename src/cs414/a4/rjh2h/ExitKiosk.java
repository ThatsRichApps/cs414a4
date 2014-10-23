package cs414.a4.rjh2h;

import java.util.Observable;

public class ExitKiosk extends Observable {

	// Parking Garage observes ExitKiosk to know when cars leave
	
	private ExitKioskUI exitUI;
	private ParkingGarage garage;
	
	public ExitKiosk(ParkingGarage garage) {
	
		this.garage = garage;
		exitUI = new ExitKioskUI();
		//exitUI.addButtonActionListener(this);
		
		this.addObserver(garage);
		
	}
	
}
