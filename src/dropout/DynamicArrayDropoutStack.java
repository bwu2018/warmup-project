package dropout;

import structures.StackUnderflowException;

public class DynamicArrayDropoutStack<T> extends ArrayDropoutStack<T> {
	
	private final int DEFAULT_CAPACITY = 3;
	private int front, count, windowSize;
	private T[] stack;
	
	public DynamicArrayDropoutStack() { 
		front = count = 0;
		stack = (T[])(new Object[DEFAULT_CAPACITY]);
		windowSize = stack.length;
	}
	
	public DynamicArrayDropoutStack(int initialCapacity) { 
		front = count = 0;
		stack = (T[])(new Object[initialCapacity]);
		windowSize = stack.length;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException(); 
		}
		if (count == 0) { 
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
		if (count == windowSize) { 
			resize(windowSize * 2);
		} 
		front = ((front-1) + windowSize) % windowSize;
		stack[front] = elem; 
		count ++; 
	}
	
	@Override
	public boolean isEmpty() {
		return count == 0; 
	}

	@Override
	public int size() {
		return count;
	}
	
	public int getLength() { 
		return stack.length;
	}
	
	public int getWindow() { 
		return windowSize;
	}
	
	public int getStackElem() { 
		int hold = 0; 
		for (int i = 0; i < stack.length; i++) {
			if(stack[i] != null)
				hold ++; 
		}
		return hold; 
	}

	@Override
	public void resize(int newCapacity) {
		T[] newStack = (T[]) (new Object[newCapacity]); 
		if (windowSize < newStack.length) { 
			windowSize = newCapacity;
			count = getStackElem();
			for (int i = 0; i < newStack.length && i < stack.length; i++) { 
				newStack[i] = stack[i];
			}
			stack = newStack;
		} else { 
			windowSize = newCapacity;
			if (newStack.length <= count) { 
				count = newStack.length;
			} else {  
				count = newStack.length;
			}
		}
	}
}
