package cs414.a4.rjh2h;

import java.util.Random;

public class ALPR {
	
	private String licensePlate;
	private String stateCode;
	
	public ALPR () {
		
		// when instantiated, this would query the camera to get the
		// license plate of the car near the camera denoted by 
		// the location
		
	}
	
	public ALPR(String licensePlate, String stateCode) {
		super();
		this.licensePlate = licensePlate;
		this.stateCode = stateCode;
	}

	public String getLicenseNumber() {

		if (licensePlate != null) {		
			return this.licensePlate;
			
		} else {
			Random r;
			
			// generate a random plate number
			r = new Random();
			char c1 = (char)(r.nextInt(26) + 'A');
			r = new Random();
			char c2 = (char)(r.nextInt(26) + 'A');
			r = new Random();
			char c3 = (char)(r.nextInt(26) + 'A');
			r = new Random();
			char c4 = (char)(r.nextInt(10) + '0');
			r = new Random();
			char c5 = (char)(r.nextInt(10) + '0');
			r = new Random();
			char c6 = (char)(r.nextInt(10) + '0');
			
			String alphaPlate = new String(new char[]{ c1, c2, c3, '-', c4, c5, c6});
			this.licensePlate = alphaPlate;
			
			return alphaPlate;
		}
	}

	public String getStateCode() {
		if (stateCode != null) {
			return this.stateCode;
		} else {
			this.stateCode = "CO";
			return ("CO");
		}
	}
	
}
