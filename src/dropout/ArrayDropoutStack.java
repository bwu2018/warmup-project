package dropout;

import structures.DropoutStackInterface;
import structures.Node;
import structures.StackUnderflowException;

public class ArrayDropoutStack<T> implements DropoutStackInterface<T> {
	
	private final int DEFAULT_CAPACITY = 3;
	private int front, count;
	private T[] stack;
	
	public ArrayDropoutStack() { 
		front = count = 0;
		stack = (T[])(new Object[DEFAULT_CAPACITY]);
	}
	
	public ArrayDropoutStack(int initialCapacity) { 
		front = count = 0;
		stack = (T[])(new Object[initialCapacity]);
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException(); 
		}
		T result = stack[front];
	    stack[front] = null;
	    front = (front+1) % stack.length;
	    count--;
	    return result;
	}

	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty()) { 
			throw new StackUnderflowException(); 
		}
		return stack[front];
	}

	@Override
	public void push(T elem) {
		if (size() == stack.length) { 
			front = ((front-1) + stack.length) % stack.length;
			stack[front] = elem; 
		} else { 
			front = ((front-1) + stack.length) % stack.length;
			stack[front] = elem; 
			count ++; 
		}
	}
	
	@Override
	public boolean isEmpty() {
		return count == 0; 
	}

	@Override
	public int size() {
		return count;
	}
	
	@Override
	public void resize(int newCapacity) {
		T[] newStack = (T[]) (new Object[newCapacity]); 
		if (newStack.length < count) { 
			count = newStack.length;
		}
		for (int i = 0; i < newStack.length && i < stack.length; i++) { 
			newStack[i] = stack[i];
		}
		stack = newStack;
	}
	
}
