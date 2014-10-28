package cs414.a4.rjh2h;

import java.math.BigDecimal;

import cs414.a4.rjh2h.ui.SysAdminUI;

public class SystemPreferences {

	// initialize the system variables here
	private double gracePeriod;
	private BigDecimal hourlyFee;
	private BigDecimal maxFee;
	private int maxOccupancy;
	private SysAdminUI sysAdminUI;

	public SystemPreferences() {
		
		gracePeriod = 60;
		hourlyFee = new BigDecimal("2.00");
		maxFee = hourlyFee.multiply(new BigDecimal("24"));
		maxOccupancy = 5;
		
	}
	
	public void showAdminUI() {
		
		sysAdminUI = new SysAdminUI();
		
	}

	public double getGracePeriod() {
		return gracePeriod;
	}

	public BigDecimal getHourlyFee() {
		return hourlyFee;
	}

	public BigDecimal getMaxFee() {
		return maxFee;
	}

	public int getMaxOccupancy() {
		return maxOccupancy;
	}

	public void setGracePeriod(double gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public void setHourlyFee(BigDecimal hourlyFee) {
		this.hourlyFee = hourlyFee;
	}

	public void setMaxFee(BigDecimal maxFee) {
		this.maxFee = maxFee;
	}

	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}
	
	
	
	
	
	
	
	
}
