package cs414.a4.rjh2h.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.rjh2h.ui.SignUI;

public class SignUITest {
	
	private SignUI entrySign; 
	
	@Before
	public void setUp() throws Exception {
		entrySign = new SignUI();
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testSign1() {

		assertEquals("Welcome to the Garage",entrySign.getMessage());
	
	}

	@Test
	public void testSign2() {

		entrySign.setMessage("test message");	
		assertEquals("test message",entrySign.getMessage());
	
	}
	
	@Test
	public void testSign3() {

		entrySign.setMessage(null);	
		assertEquals(null,entrySign.getMessage());
	
	}
	
}
