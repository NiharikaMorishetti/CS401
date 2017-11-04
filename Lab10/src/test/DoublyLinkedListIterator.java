package test;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedListIterator<E> implements ListIterator<E>, Iterable1<E> {
	
	protected DLLNode<E> front; // reference to the front of this list
	protected DLLNode<E> rear; // reference to the rear of this list
	protected int numElements = 0; // number of elements in this list

	// set by find method
	protected boolean found; // true if target found, else false
	protected int targetIndex; // list index of target, if found
	protected DLLNode<E> location; // node containing target, if found
	protected DLLNode<E> previous; // node preceding location
	
	protected DLLNode<E> current = front.back;
	protected DLLNode<E> lastAccessed = null;
	
	private int index = 0;


	public boolean hasNext() {
		return index < numElements;
	}


	public E next() {
		if (!hasNext()) throw new NoSuchElementException();
		lastAccessed = current;
		E info = current.info;
		current = current.back;
		index ++;
		return info;
	}

	public boolean hasPrevious() {
		return index > 0;
	}


	public E previous() {
		if (!hasPrevious()) throw new NoSuchElementException();
		current = current.forward;
		index--;
		lastAccessed = current;
		return current.info;
	}


	public int nextIndex() {
		return index;
	}


	public int previousIndex() {
		return index - 1;
	}


	public void remove() {
		if (lastAccessed == null) throw new IllegalStateException();
		DLLNode<E> x = lastAccessed.back;
		DLLNode<E> y = lastAccessed.forward;
		x.back = y;
		y.forward = x;
		numElements--;
		if(current == lastAccessed)
			current = y;
		else
			index--;
		lastAccessed = null;
		
	}


	public void set(E e) {
		if (lastAccessed == null) throw new IllegalStateException();
		lastAccessed.info = e;
	}


	public void add(E e) {
		DLLNode<E> x = current.back;
		DLLNode<E> y = new DLLNode<E>(e);
		DLLNode<E> z = current;
		y.info = e;
		x.back = y;
		y.back = z;
		z.forward = y;
		y.forward = x;
		numElements++;
		index++;
		lastAccessed = null;
	}


	@Override
	public void print_from_beginning() {
		while(hasNext()) {
			E m = next();
			add(m);
		}
		return;
		
	}


	@Override
	public void print_from_end() {
		while(hasPrevious()) {
			E m = previous();
			add(m);
		}
		return;
	}

}
