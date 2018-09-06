package dropout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import structures.DropoutStackInterface;
import structures.StackUnderflowException;

public class DynamicDropoutStackInterfaceTest {

	private DropoutStackInterface<Integer> stack;
	
	@Before
	public void setup(){
		stack = new DynamicArrayDropoutStack<Integer>();
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
		assertEquals("The stack should contain four elements.", 4, stack.size());
		assertEquals("Length of stack should be 6.", 6, ((DynamicArrayDropoutStack<Integer>) stack).getLength());
		
		stack.resize(3);
		assertEquals("The stack should contain three elements.", 3, stack.size());
		assertEquals("Length of stack should remain at 6.", 6, ((DynamicArrayDropoutStack<Integer>) stack).getLength());
		assertEquals("Window size should be 3.", 3, ((DynamicArrayDropoutStack<Integer>) stack).getWindow());
		
		stack.push(1);
		assertEquals("Length of stack should remain at 6.", 6, ((DynamicArrayDropoutStack<Integer>) stack).getLength());
		assertEquals("The top element should be 1", new Integer(1), stack.top());
		//Pushing beyond capacity resizes and brings back old nodes
		assertEquals("The stack should contain five elements.", 5, stack.size());
		
		Integer t = stack.pop();
		assertEquals("The popped element should be 1", new Integer(1), t);
		assertEquals("The top element should be 2", new Integer(2), stack.top());
		assertEquals("The stack should contain four elements.", 4, stack.size());
		assertFalse("The stack should not be empty.", stack.isEmpty());
		
		t = stack.pop();
		assertEquals("The popped element should be 2", new Integer(2), t);
		assertEquals("The top element should be 3", new Integer(3), stack.top());
		assertEquals("The stack should contain three elements.", 3, stack.size());
		assertFalse("The stack should not be empty.", stack.isEmpty());
		
		t = stack.pop();
		assertEquals("The popped element should be 3", new Integer(3), t);
		assertEquals("The top element should be 4", new Integer(4), stack.top());
		assertEquals("The stack should contain two elements.", 2, stack.size());
		assertFalse("The stack should not be empty.", stack.isEmpty());
		
		t = stack.pop();
		assertEquals("The popped element should be 4", new Integer(4), t);
		assertEquals("The top element should be 5", new Integer(5), stack.top());
		assertEquals("The stack should contain one element.", 1, stack.size());
		assertFalse("The stack should not be empty.", stack.isEmpty());
		
		t = stack.pop();
		assertEquals("The popped element should be five", new Integer(5), t);
		assertTrue("The stack should be empty.", stack.isEmpty());
		
	}
	
	@Test (timeout = 5000, expected = StackUnderflowException.class)
	public void testStackUnderflowPop(){
		stack.pop();
	}

}
