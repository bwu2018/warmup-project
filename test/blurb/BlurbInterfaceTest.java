package blurb;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import blurb.BlurbInterface;
import config.Configuration;

public class BlurbInterfaceTest {
	
	private BlurbInterface blurb;
	
	@Before
	public void setup(){
		blurb = Configuration.getBlurbInterface();
		BlurbInterface b2 = Configuration.getBlurbInterface();
		if(blurb == null)
			fail("You didn't set your blurb in the Configuration file.");
		if(blurb == b2)
			fail("You should return a new instance of list with each call to Configuration.getListInterface()");
	}
	
	@Test
	public void testSimpleIsBlurb() {
		assertTrue(blurb.isBlurb("xqzx"));
		assertTrue(blurb.isBlurb("xqdx"));
	}
	
	@Test
	public void testMissingLeadingX() {
		assertFalse(blurb.isBlurb("qdx"));
		assertFalse(blurb.isBlurb("qdz"));
	}
	
	@Test
	public void testTrailingX() {
		assertFalse(blurb.isBlurb("xqd"));
		assertFalse(blurb.isBlurb("xqz"));
	}
	
	@Test
	public void testAtLeastOneQBetweenTwoXs() {
		assertFalse(blurb.isBlurb("xx"));
		assertFalse(blurb.isBlurb("xdx"));
		assertFalse(blurb.isBlurb("xzx"));
	}
	
	@Test
	public void testOneWhoozitOneWhatzit() {
		assertTrue(blurb.isBlurb("xyyyyqdxyy"));
		assertTrue(blurb.isBlurb("xyqzxyyyyyyy"));
		assertTrue(blurb.isBlurb("xqdxyyyyyyyyyyyyyyy"));
	}
	
	@Test
	public void testOneWhoozitMultipleWhatzits() {
		assertTrue(blurb.isBlurb("xqzxqdx"));
		assertTrue(blurb.isBlurb("xyqdxyqdxy"));
		assertTrue(blurb.isBlurb("xyyyyyyqzxqzxyyyyyqdxyyyyqzx"));
		
	}
	
	@Test
	public void testTwoWhozitsInARow() {
		assertFalse(blurb.isBlurb("xyxyqdx"));
		assertFalse(blurb.isBlurb("xyqdxyxy"));
		assertFalse(blurb.isBlurb("xyqdxyqzxxy"));
		assertFalse(blurb.isBlurb("xyyyyyyqzxqzxyyyyyqdxyyyxyqzx"));	
	}
	
	@Test
	public void testBlurbGenerator() {
		Set<String> blurbLengths = new HashSet<String>();
		for(int i =0; i < 1000000; i++) {
			String testBlurb = blurb.generateBlurb();
			assertTrue("Generated " + testBlurb + " which is not a valid blurb", blurb.isBlurb(testBlurb));
			blurbLengths.add(testBlurb);
		}
		assertTrue("Not enough variation in your string lengths", blurbLengths.size() > 200000);
	}

}
