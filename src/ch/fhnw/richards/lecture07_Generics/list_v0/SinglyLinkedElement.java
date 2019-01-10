package ch.fhnw.richards.lecture07_Generics.list_v0;

public class SinglyLinkedElement<T> {
	private final T data; // in our current implementation, this is unchangeable
	SinglyLinkedElement<T> next = null; // package-private - used directly by the main list class
	
	/**
	 * Constructor protected; could be needed by a subclass
	 */
	protected SinglyLinkedElement(T data) {
		this.data = data;
	}
	
	/**
	 * Protected; could be needed by a subclass
	 */
	protected T getData() {
		return data;
	}
}
