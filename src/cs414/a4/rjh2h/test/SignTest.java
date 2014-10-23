package cs414.a4.rjh2h.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.rjh2h.Sign;

public class SignTest extends Sign {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSign() {

		Sign testSign = new Sign();
		assertEquals("Entry Sign Controller", testSign.toString());
		
	}

}
