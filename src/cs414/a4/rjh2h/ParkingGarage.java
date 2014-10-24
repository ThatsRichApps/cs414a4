package cs414.a4.rjh2h;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import cs414.a4.rjh2h.ui.GarageUI;

public class ParkingGarage extends Observable implements Observer {
	
	// Parking Garage occupancy is observable.  Also, the garage observes the entryKiosk
	// in order to know when cars are entering
	
	// initialize all the variables from the Glossary here
	private double gracePeriod = 60;
	private double hourlyFee = 2.00;
	private double maxFee = hourlyFee * 24;
	private boolean isOpen;
	private int currentOccupancy;
	private int maxOccupancy = 25;
	private static GarageUI garageUI;
	
	private HashMap<String, Ticket> virtualTicketMap = new HashMap<String, Ticket>();
	private HashMap<Integer, Ticket> physicalTicketMap = new HashMap<Integer, Ticket>();
	
	public static void main(String[] args) {
		
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
	    
				ParkingGarage garage = new ParkingGarage();
				
				// create the gui here
				garageUI = new GarageUI();

				Sign entrySign = new Sign();
				garage.addObserver(entrySign);
				
				EntryKiosk entryKiosk = new EntryKiosk(garage);
				garage.addObserver(entryKiosk);
				
				ExitKiosk exitKiosk = new ExitKiosk(garage);

				garage.isOpen = true;
				garage.setChanged();
				garage.notifyObservers(garage.isOpen);
				
			}
		});
		
	}
	

	public void update(Observable o, Object arg) {
	    // update garage.occupancy and the garage.isOpen status as needed 
		System.out.println("Update Garage:" + o + arg);
		
		if ((String)arg == "entry") {
			currentOccupancy++;
		} else if ((String)arg == "exit") {
			currentOccupancy--;
			if (currentOccupancy < 0 ) {currentOccupancy = 0;};
		}
		
		garageUI.setMessage("Current Occupancy:" + currentOccupancy);
		
		if (currentOccupancy >= maxOccupancy) {
			this.isOpen = false;		
			this.setChanged();
			this.notifyObservers(this.isOpen);
		} else if (this.isOpen == false) {
			this.isOpen = true;		
			this.setChanged();
			this.notifyObservers(this.isOpen);
		}
		
	}

	public void addVirtualTicket(Ticket ticket) {
		
		String key = ticket.getAutomobile().getLicenseStateCode() + " - " +
				ticket.getAutomobile().getLicensePlateNumber();
		
		virtualTicketMap.put(key, ticket);
		
	}
	
	public void addPhysicalTicket(Ticket ticket) {
		
		int key = ticket.getTicketNumber();
		
		physicalTicketMap.put(key, ticket);
		
	}

	
	
	
	
	
	
}
