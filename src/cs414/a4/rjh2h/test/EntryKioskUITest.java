package cs414.a4.rjh2h.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.rjh2h.EntryKioskUI;

public class EntryKioskUITest extends EntryKioskUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEntryKioskUI() {
		
		EntryKioskUI entryUI = new EntryKioskUI();
		assertEquals("EntryKioskUI [title=Entry Kiosk, message=Please Take Your Ticket]", entryUI.toString());
	
	}

}
