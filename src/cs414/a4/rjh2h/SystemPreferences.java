package cs414.a4.rjh2h;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import cs414.a4.rjh2h.ui.SysAdminUI;

public class SystemPreferences {

	// initialize the system variables here
	private double gracePeriod;
	private BigDecimal hourlyFee;
	private BigDecimal maxFee;
	private int maxOccupancy;
	private SysAdminUI sysAdminUI;

	private Map<String, Object> systemPrefs = new HashMap<String, Object>();;
	
	public SystemPreferences() {
		
		gracePeriod = 60;
		hourlyFee = new BigDecimal("2.00");
		maxFee = hourlyFee.multiply(new BigDecimal("24"));
		maxOccupancy = 5;
		
		systemPrefs.put("rate", new BigDecimal("3.00"));
		systemPrefs.put("maximum occupancy", 5);
		
	}
	
	public void showAdminUI() {
		
		sysAdminUI = new SysAdminUI(systemPrefs);
		
	}

	public double getGracePeriod() {
		return gracePeriod;
	}

	public BigDecimal getHourlyFee() {
		return (BigDecimal) systemPrefs.get("rate");
	}

	public BigDecimal getMaxFee() {
		return maxFee;
	}

	public int getMaxOccupancy() {
		return (int) systemPrefs.get("maximum occupancy");
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
