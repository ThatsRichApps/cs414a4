package cs414.a4.rjh2h;

import java.util.Observable;
import java.util.Observer;

public class EntryKiosk implements Observer {

	private EntryUI entryUI = new EntryUI();
	
	
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
	
}