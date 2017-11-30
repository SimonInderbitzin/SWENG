package ch.fhnw.richards.lecture06_Generics.list_v0;

import ch.fhnw.richards.lecture06_Generics.list_v0.ListException.ListErrorCode;

public class SinglyLinkedList<T> {
	private SinglyLinkedElement<T> head = null;

	public boolean isEmpty() {
		return (head == null);
	}

	public void add(int position, T o) throws ListException {
	}

	public T get(int position) throws ListException {
		if (position < 0) throw new ListException(ListErrorCode.PositionTooSmall);
		SinglyLinkedElement<T> cursor = head;
		for (int pos = 0; pos < position; pos++) {
			if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
			cursor = cursor.next;
		}
		if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
		return cursor.getData();
	}

	public T remove(int position) throws ListException {
		return null;
	}
	
	public int size() {
		return 0;
	}
	
	public boolean contains(T elt) {
		return false;
	}
}
