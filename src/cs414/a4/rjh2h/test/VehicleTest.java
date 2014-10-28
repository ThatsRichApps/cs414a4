package cs414.a4.rjh2h.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.rjh2h.Vehicle;

public class VehicleTest extends Vehicle {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAutomobile() {

		Vehicle autoTest = new Vehicle();
		
		assertTrue(autoTest.getLicensePlate().length() == 7);
	
	}

}
