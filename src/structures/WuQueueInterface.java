package structures;

public class WuQueueInterface<T> implements QueueInterface<T> {

	private static class Node<T> {
		private T elem;
		private Node<T> next;
		private Node(T elem){
			this.elem = elem;
			this.next = null;
		}
	}
	
	private Node<T> front;
	private Node<T> back;
	private int size;
	
	@Override
	public T dequeue() {
		if(front == null)
			throw new IllegalStateException("Could not dequeue empty Queue.");
		
		size--;
		T elem = front.elem;
		if(front == back){
			front = null;
			back = null;
			return elem;
		}
		
		front = front.next;		
		return elem;
	}

	@Override
	public QueueInterface<T> enqueue(T elem) {
		if(elem == null)
			throw new NullPointerException("Cannot insert null element.");
		size++;
		Node<T> newBack = new Node<T>(elem);
		
		if(front == null){
			front = newBack;
			back = newBack;
			return this;
		}
		
		back.next = newBack;
		back = newBack;
		return this;
	}

	@Override
	public boolean isEmpty() {
		return front == null;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append('[');
		Node<T> n = front;
		while(n != null){
			String maybeComma = n.next == null ? "" : ", ";
			b.append(n.elem + maybeComma);
			n = n.next;
		}
		b.append(']');
		return b.toString();
	}

	@Override
	public T peek() {
		if(front == null)
			throw new IllegalStateException();
		return front.elem;
	}

}
