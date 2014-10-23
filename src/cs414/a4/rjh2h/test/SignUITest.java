package cs414.a4.rjh2h.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.rjh2h.SignUI;

public class SignUITest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSign1() {

		SignUI entrySign = new SignUI();
		entrySign.setMessage("test message");	
		assertEquals("test message",entrySign.getMessage());
	
	}

	@Test
	public void testSign2() {

		SignUI entrySign = new SignUI();
		assertEquals("Welcome to the Garage",entrySign.getMessage());
	
	}
	
	@Test
	public void testSign3() {

		SignUI entrySign = new SignUI();
		entrySign.setMessage(null);	
		assertEquals(null,entrySign.getMessage());
	
	}

	
	
}
