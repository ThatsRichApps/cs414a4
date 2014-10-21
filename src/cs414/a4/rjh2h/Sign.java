package cs414.a4.rjh2h;

import java.util.Observable;
import java.util.Observer;

public class Sign implements Observer {

	public void update(Observable o, Object arg) {
	    System.out.println("Garage Changed: " + arg);
	}
	
}
