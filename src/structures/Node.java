package structures;

public class Node<T> {
	private Node<T> next;
	private T data;
	public Node(){
		next = null;
		data = null;
	}
	public Node (T elem){
		next = null;
		data = elem;
	}
	public Node<T> getNext(){
		return next;
	}
	public void setNext (Node<T> node) {
		next = node; 
	}
	public T getData(){
		return data;
	}
	public void setElement (T elem){
		data = elem;
	}
}
