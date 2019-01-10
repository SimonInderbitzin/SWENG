package ch.fhnw.richards.lecture07_Generics.solutions.ListIntermediate;

import java.util.Iterator;

import ch.fhnw.richards.lecture07_Generics.solutions.ListIntermediate.ListException.ListErrorCode;

public class SinglyLinkedList<T> implements Iterable<T> {
	private SinglyLinkedElement<T> head = null;

	public boolean isEmpty() {
		return (head == null);
	}

	public void add(int position, T o) throws ListException {
		SinglyLinkedElement<T> e = new SinglyLinkedElement<T>(o);
		if (position == 0) { // special handling for first position
			e.next = head;
			head = e;
		} else if (position > 0) {
			SinglyLinkedElement<T> cursor = head;			
			for (int pos = 1; pos < position; pos++) {
				if (cursor == null) throw new ListException(ListErrorCode.PositionTooSmall);
				cursor = cursor.next;
			}
			// insert *after* element pointed to by cursor
			if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
			e.next = cursor.next;
			cursor.next = e;
		} else {
			throw new ListException(ListErrorCode.PositionTooSmall);
		}
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
		T o;
		SinglyLinkedElement<T> cursor = head;
		if (position == 0) { // special handling for first position
			if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
			o = cursor.getData();
			head = cursor.next;
		} else if (position > 0) {
			for (int pos = 1; pos < position; pos++) {
				if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
				cursor = cursor.next;
			}
			if (cursor == null) throw new ListException(ListErrorCode.PositionTooLarge);
			// retain data to return
			o = cursor.next.getData();
			// delete element *after* cursor
			cursor.next = cursor.next.next;
		} else {
			throw new ListException(ListErrorCode.PositionTooSmall);
		}
		return o;
	}
	
	public int size() {
		int count = 0;
		SinglyLinkedElement<T> cursor = head;
		while (cursor != null) {
			count++;
			cursor = cursor.next;
		}
		return count;
	}
	
	public boolean contains(T elt) {
		boolean found = false;
		SinglyLinkedElement<T> cursor = head;
		while (!found && cursor != null) {
			if (elt == null) {
				found = (cursor.getData() == null);
			} else {
				found = (cursor.getData().equals(elt));
			}
			cursor = cursor.next;
		}
		return found;
	}
	
	public Iterator<T> iterator() {
		return new SinglyLinkedListIterator<T>(this);
	}
	
	// Static methods declare their own generic variables directly
	// following the "static" keyword
	
	public static <E> SinglyLinkedList<E> toList(E[] array) {
		SinglyLinkedList<E> list = new SinglyLinkedList<>();
		for (E element : array) {
			try {
				list.add(0, element);
			} catch (ListException e) {
				//can not happen, adding at pos 0 is always save
			}
		}
		return list;
	}

	public static <E> void toArray(SinglyLinkedList<E> list, E[] array) {
		if (list.size() != array.length) {
			throw new IllegalArgumentException("not of same length");
		}
		for (int i = 0; i < list.size(); i++) {
			try {
				array[i] = list.get(i);
			} catch (ListException e) {
				//can not happen, array and list are of same size
			}
		}
	}	
}
