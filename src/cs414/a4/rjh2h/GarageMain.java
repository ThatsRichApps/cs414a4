package cs414.a4.rjh2h;

import cs414.a4.rjh2h.ui.GarageUI;

public class GarageMain {
	
	private static ParkingGarage garage;

	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
	    
				garage = new ParkingGarage();
				garage.setOpen(true);
				
			}
		});

	}

}
