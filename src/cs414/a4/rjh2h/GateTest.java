package cs414.a4.rjh2h;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GateTest {
	
	private Gate entryGate;
	

	@Before
	public void setUp() throws Exception {
		
		entryGate = new Gate();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGate() {
		assertFalse(entryGate.isOpen());	
	}

	@Test
	public void testIsOpen() {
		assertFalse(false);
	}

	@Test
	public void testOpenGate() {
		fail("Not yet implemented");
	}

	@Test
	public void testCloseGate() {
		fail("Not yet implemented");
	}

	@Test
	public void testOpenGateForCar() {
		fail("Not yet implemented");
	}

}
