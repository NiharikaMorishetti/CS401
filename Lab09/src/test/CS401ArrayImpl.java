package test;

import java.util.Arrays;

public class CS401ArrayImpl<E> implements CS401CollectionInterface<E>{
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];

	//set by find method
	protected boolean found;
	protected int location;

	public CS401ArrayImpl() {
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	@Override
	public boolean add(Where where, int index, E e) {
		if (is_full()) {
			grow();
		}
		else {
			elements[index] = e;
			for(int i = index+1; i<size; i++) {
				elements[i+1] = elements[i];
			}
			size++;
		}
		return true;
		
	}

	@Override
	public void add(Where where, E e) {
		if (is_full()) {
			grow();
		}
		
		if (where == Where.BACK) {
			System.out.println("Inserting element at index " + size);
			elements[size] = e;
			size ++;
		}else if (where == Where.FRONT) {
			System.out.println("Inserting element at index 0");
			System.out.println("Compacting styorage");
			for(int i = 1; i<size; i++) {
				elements[i+1] = elements[i];
			}
			size++;
		}
		elements[size++] = e;

	}


	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (i>= size || i <0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
		}
		return (E) elements[i];
	}

	public int size() {
		// TODO Auto-generated method stub
		return elements.length;
	}

	public boolean is_full() {
		return false;
	}

	public boolean is_empty() {
		return (size == 0);
	}

	protected void find(int target){
		location = 0;
		found = false;

		while(location < size) {
			if (elements[location].equals(target)) {
				found = true;
				return;
			}else
				location ++;
		}
	}

	public boolean remove(int i) {
		find(i);
		if(found)
			elements[location] = elements[size - 1];
		elements[size - 1] = null;
		size--;
		return found;
	}


	public boolean contains(int e) {
		find(e);
		return found;
	}

	/**
	 * ----------- Private methods
	 */
	/*
	 * Grows elements array to hold more elements.  Copies old (existing)
	 * elements in the new array.
	 * 
	 * Postcondition: (a) elements must contain the contents of the old array
	 *                (b) elements must now have twice as much capacity as
	 *                    before
	 */
	@SuppressWarnings("unchecked")
	private boolean grow()  {

		/* 
		 * Add code here 
		 * Expand capacity (double it) and copy old array contents to the
		 * new one. 
		 */
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
		

		System.out.println("Capacity reached.  Increasing storage...");
		System.out.println("New capacity is " + newSize + " elements");

		return true;
	}


	public void add(E e) {
		if (size == elements.length) {
			grow();
		}
		elements[size++] = e;
	}
}