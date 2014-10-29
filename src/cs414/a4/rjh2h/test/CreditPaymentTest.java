package cs414.a4.rjh2h.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.rjh2h.CreditPayment;

public class CreditPaymentTest extends CreditPayment {

	public CreditPaymentTest(BigDecimal amountDue) {
		super(amountDue, null);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
