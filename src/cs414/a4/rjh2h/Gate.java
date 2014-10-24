package cs414.a4.rjh2h;

import java.util.Observable;

public class Gate extends Observable {
	
	private boolean isOpen;
	private boolean carSensor;
	
	public Gate() {
		super();
		closeGate();
	}
	
	public boolean isOpen() {
		return isOpen;
	}

	public void openGate() {
		this.isOpen = true;
	}
	
	public void closeGate() {
		waitForCar();
		this.isOpen = false;
	}
	
	public void openGateForCar () {
		// opens the gate, waits for the car, closes the gate
		this.isOpen = true;
		waitForCar();
		this.isOpen = false;
	}
	
	private void waitForCar() {
		// check the car sensor and wait while a car is there
		do {
			
			try {
				  Thread.sleep(1000);
			} catch (InterruptedException ie) {
				    //Handle exception
			}
			
			this.carSensor = false;
			
		} while (this.carSensor== true);
	}
	
	
	
	
	
	
	
	
	
	

}
