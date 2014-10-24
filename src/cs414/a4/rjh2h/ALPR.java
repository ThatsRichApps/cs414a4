package cs414.a4.rjh2h;

import java.util.Random;

public class ALPR {
	
	
	public ALPR () {
		
		// when instantiated, this would query the camera to get the
		// license plate of the car near the camera denoted by 
		// the location
		
		//initSamplePlates();
		
	}
	
	public String getLicenseNumber() {
		
		Random r;
		
		// generate a random plate number?
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
		
		return alphaPlate;
	}

	public String getStateCode() {
		return ("CO");
	}
	
	
}
