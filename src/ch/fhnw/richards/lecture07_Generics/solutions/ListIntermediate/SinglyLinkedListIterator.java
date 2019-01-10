package ch.fhnw.richards.lecture07_Generics.solutions.ListIntermediate;

import java.util.Iterator;

public class SinglyLinkedListIterator<E> implements Iterator<E> {
	private SinglyLinkedList<E> singlyLinkedList;
	private int cursor = 0;
	private int lastReturned = -1;

	public SinglyLinkedListIterator(SinglyLinkedList<E> singlyLinkedList) {
		this.singlyLinkedList = singlyLinkedList;
	}

	@Override
	public boolean hasNext() {
		return cursor < singlyLinkedList.size();
	}

	@Override
	public E next() {
		E data = null;
		try {
			data = singlyLinkedList.get(cursor);
		} catch (ListException e) {
			throw new IllegalStateException("Can't access element at index " + cursor);
		}
		lastReturned = cursor;
		cursor++;

		return data;
	}

	@Override
	public void remove() {
		if (lastReturned == -1) {
			throw new IllegalStateException("remove failed");
		}
		try {
			singlyLinkedList.remove(lastReturned);
			cursor--;
			lastReturned = -1;
		} catch (ListException e) {
			//cannot happen
		}
	}
}
