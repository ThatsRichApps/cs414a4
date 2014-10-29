package cs414.a4.rjh2h;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import cs414.a4.rjh2h.ui.SysAdminUI;

public class SystemPreferences implements ActionListener {

	/*
	private double gracePeriod;
	private BigDecimal hourlyFee;
	private BigDecimal maxFee;
	private int maxOccupancy;
	*/
	private SysAdminUI sysAdminUI;
	
	private Map<String, Object> systemPrefs = new HashMap<String, Object>();
	private HashMap<String, SystemAccount> systemAccountList;
	
	public SystemPreferences() {
		
		systemPrefs.put("rate", new BigDecimal("3.00"));
		systemPrefs.put("maximum occupancy", 5);
		systemPrefs.put("max fee", new BigDecimal("48.00"));
			
	}
	
	public void showAdminUI() {
		sysAdminUI = new SysAdminUI(systemPrefs);
		sysAdminUI.addActionListeners(this);
	}
	
	public HashMap<String, SystemAccount> getSystemAccountList() {
		return systemAccountList;
	}

	public void setSystemAccountList(
		HashMap<String, SystemAccount> systemAccountList) {
		this.systemAccountList = systemAccountList;
	}

	public BigDecimal getHourlyFee() {
		return (BigDecimal) systemPrefs.get("rate");
	}

	public BigDecimal getMaxFee() {
		return (BigDecimal) systemPrefs.get("max fee");
	}

	public int getMaxOccupancy() {
		return (int) systemPrefs.get("maximum occupancy");
	}

	public void setRate(BigDecimal rate) {
		systemPrefs.put("rate", rate);
	}

	public void setMaxFee(BigDecimal maxFee) {
		systemPrefs.put("max fee", maxFee);
	}

	public void setMaxOccupancy(int maxOccupancy) {
		systemPrefs.put("maximum occupancy", maxOccupancy);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		String eventName = event.getActionCommand();
		
		System.out.println("event:" + eventName);
		
	}
	
	
	
	
	
	
	
	
}
