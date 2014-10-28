package cs414.a4.rjh2h;

public class Vehicle {
	
	private String licensePlate;
	
	public Vehicle() {
		
		// if no license or plate is given, we use the ALPR System to determine it
		ALPR licenseSystem = new ALPR();
	
		this.licensePlate = licenseSystem.getLicensePlate(); ;

	}

	public Vehicle(String licensePlateNumber, String licenseStateCode) {
		this.licensePlate = licensePlateNumber;
	}

	public String getLicensePlate() {
		return licensePlate;
	}
	
}
