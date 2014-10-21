package cs414.a4.rjh2h;

import java.util.Observable;

public class ParkingGarage extends Observable {
	
	// initialize all the variables from the Glossary here
	private double gracePeriod = 60;
	private double hourlyFee = 2.00;
	private double maxFee = hourlyFee * 24;
	private boolean isOpen;

	public static void main(String[] args) {
		
		
		ParkingGarage garage = new ParkingGarage();
		
		GarageUI garageUI = new GarageUI();
		
		Sign entrySign = new Sign();
		garage.addObserver(entrySign);
		
		garage.isOpen = true;
		garage.notifyObservers(garage.isOpen);
		
	}
	
	
	
	
	
	
	
	
	
	

}
