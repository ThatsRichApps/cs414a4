package cs414.a4.rjh2h;

import java.util.Observable;
import java.util.Observer;

public class Sign implements Observer {

	private SignUI entrySignUI = new SignUI();
	
	@Override
	public String toString() {
		return "Entry Sign Controller";
	}

	public void update(Observable o, Object arg) {
	    // this updates the sign when the garage state changes
		
	    String garageState;
	    boolean isOpen = (boolean) arg;
	    
	    if (isOpen == true) {
	    	garageState = "Open";
	    } else {
	    	garageState = "Full";
	    }
	    	
	    entrySignUI.setMessage("Garage is " + garageState);
	    
	}
	
}
