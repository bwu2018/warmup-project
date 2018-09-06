package capitalgains;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import captialgains.CapitalGainsInterface;
import captialgains.NotEnoughStockException;
import config.Configuration;

public class CapitalGainsInterfaceTest {
	
	private CapitalGainsInterface capitalGains;
	
	@Before
	public void setup(){
		capitalGains = Configuration.getCapitalGainsInterface();
		CapitalGainsInterface c2 = Configuration.getCapitalGainsInterface();
		if(capitalGains == null)
			fail("You didn't set your capitalGains in the Configuration file.");
		if(capitalGains == c2)
			fail("You should return a new instance of list with each call to Configuration.getListInterface()");
	}
	
	@Test
	public void testSimpleBuySell() {
		assertEquals("Newly constructed capital gains object should start at day 0", 0, capitalGains.getDay());
		capitalGains.buy(100, 20.00);
		assertEquals("Days should now be 1 after a buy", 1, capitalGains.getDay());
		assertEquals(100, capitalGains.sell(100, 21.00), 0.0001);
	}
	
	@Test
	public void testNegativeCapitalGains() {
		assertEquals("Newly constructed capital gains object should start at day 0", 0, capitalGains.getDay());
		capitalGains.buy(100, 5);
		assertEquals(-499, capitalGains.sell(100, 0.01), 0.001);
	}
	
	@Test (timeout = 500, expected = NotEnoughStockException.class)
	public void testExceptionOnEmptyCapitalGains() {
		capitalGains.sell(100, 25.00);
	}
	
	@Test (timeout = 500, expected = NotEnoughStockException.class)
	public void testExceptionOnNotEnoughStock() {
		capitalGains.buy(100, 50.00);
		capitalGains.sell(150, 50.00);
	}
	
	@Test (timeout = 500, expected = NotEnoughStockException.class)
	public void testExceptionOnNotEnoughStock2() {
		capitalGains.buy(100, 50.00);
		capitalGains.buy(50, 20.00);
		capitalGains.buy(200, 10);
		capitalGains.sell(500, 75.00);
	}
	
	@Test
	public void testTwoBuysOneSell() {
		assertEquals("Newly constructed capital gains object should start at day 0", 0, capitalGains.getDay());
		capitalGains.buy(100, 50.00);
		capitalGains.buy(100, 55.00);
		assertEquals(1250, capitalGains.sell(150, 60.00), 0.0001);
	}
	
	@Test
	public void testMulitpleBuysOneSell() {
		assertEquals("Newly constructed capital gains object should start at day 0", 0, capitalGains.getDay());
		capitalGains.buy(100, 20.00);
		capitalGains.buy(20, 24);
		capitalGains.buy(200, 36);
		assertEquals(940, capitalGains.sell(150, 30), 0.001);
	}
	
	@Test
	public void testMultipleBuysMultipleSells() {
		assertEquals("Newly constructed capital gains object should start at day 0", 0, capitalGains.getDay());
		capitalGains.buy(100, 20.00);
		capitalGains.buy(20, 24);
		capitalGains.buy(200, 36);
		assertEquals(940, capitalGains.sell(150, 30), 0.001);
		assertEquals(280, capitalGains.sell(70, 40), 0.001);
		capitalGains.buy(200, 20);
		capitalGains.buy(500, 25);
		assertEquals(9900, capitalGains.sell(400, 50), 0.0001);
	}


}
