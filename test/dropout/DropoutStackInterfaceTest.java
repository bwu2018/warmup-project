package dropout;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import structures.DropoutStackInterface;
import structures.StackUnderflowException;

public class DropoutStackInterfaceTest {

	private DropoutStackInterface<Integer> stack;
	
	@Before
	public void setup(){
		stack = new ArrayDropoutStack<Integer>();
	}

	@Test (timeout = 5000)
	public void testStack() {
		assertTrue("Stack should be empty after being constructed.", stack.isEmpty());
		assertEquals("Stack should contain zero elements after being constructed.", 0, stack.size());
		
		stack.push(5);
		assertFalse("Stack should not be empty.", stack.isEmpty());
		assertEquals("The top element should be 5", new Integer(5), stack.top());
		assertEquals("The stack should contain one element.", 1, stack.size());
		
		stack.push(4);
		assertEquals("The top element should be 4", new Integer(4), stack.top());
		assertEquals("The stack should contain two elements.", 2, stack.size());
		
		stack.push(3);
		assertEquals("The top element should be 3", new Integer(3), stack.top());
		assertEquals("The stack should contain three elements.", 3, stack.size());
		
		stack.push(2);
		assertEquals("The top element should be 2", new Integer(2), stack.top());
		assertEquals("The stack should contain three elements.", 3, stack.size());
		
		stack.resize(4);
		
		stack.push(1);
		assertEquals("The top element should be 1", new Integer(1), stack.top());
		assertEquals("The stack should contain four elements.", 4, stack.size());
		
		stack.resize(3);
		assertEquals("The stack should contain three elements.", 3, stack.size());
		
		Integer t = stack.pop();
		assertEquals("The popped element should be 1", new Integer(1), t);
		assertEquals("The top element should be 2", new Integer(2), stack.top());
		assertEquals("The stack should contain two elements.", 2, stack.size());
		assertFalse("The stack should not be empty.", stack.isEmpty());
		
		t = stack.pop();
		assertEquals("The popped element should be 2", new Integer(2), t);
		assertEquals("The top element should be 3", new Integer(3), stack.top());
		assertEquals("The stack should contain one element.", 1, stack.size());
		assertFalse("The stack should not be empty.", stack.isEmpty());
		
		t = stack.pop();
		assertEquals("The popped element should be 3", new Integer(3), t);
		assertTrue("The stack should be empty.", stack.isEmpty());
		
	}
	
	@Test (timeout = 5000, expected = StackUnderflowException.class)
	public void testStackUnderflowPop(){
		stack.pop();
	}
	
}
