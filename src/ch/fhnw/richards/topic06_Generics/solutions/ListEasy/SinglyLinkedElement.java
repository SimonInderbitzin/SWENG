package ch.fhnw.richards.topic06_Generics.solutions.ListEasy;

public class SinglyLinkedElement<T> {
	private T data;
	protected SinglyLinkedElement<T> next = null;
	
	protected SinglyLinkedElement(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
}
