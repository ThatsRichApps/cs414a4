package cs414.a4.rjh2h.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.rjh2h.ALPR;

public class ALPRTest extends ALPR {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testALPR1() {

		ALPR testALPR = new ALPR();
		
		assertEquals("CO", testALPR.getStateCode());
		//assertEquals("AAA", testALPR.getLicenseNumber());
		
	}

}
