package cs414.a4.rjh2h;

public class Automobile {
	
	private String licensePlateNumber;
	private String licenseStateCode;
	
	public Automobile() {
		
		// if no license or plate is given, we use the ALPR System to determine it
		ALPR licenseSystem = new ALPR();
		String licensePlateNumber = licenseSystem.getLicenseNumber(); 
		String licenseStateCode = licenseSystem.getStateCode(); 

		this.licensePlateNumber = licensePlateNumber;
		this.licenseStateCode = licenseStateCode;

	}

	public Automobile(String licensePlateNumber, String licenseStateCode) {
		this.licensePlateNumber = licensePlateNumber;
		this.licenseStateCode = licenseStateCode;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public String getLicenseStateCode() {
		return licenseStateCode;
	}

	public void setLicenseStateCode(String licenseStateCode) {
		this.licenseStateCode = licenseStateCode;
	}

}
