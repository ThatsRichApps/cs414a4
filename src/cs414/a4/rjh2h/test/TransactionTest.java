package cs414.a4.rjh2h.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.rjh2h.Transaction;

public class TransactionTest extends Transaction {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTransaction() {
		Transaction transactionTest = new TransactionTest();
		assertEquals("Transaction", transactionTest.toString());
	}

}
