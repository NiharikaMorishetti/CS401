package test;

import java.util.Iterator;
import java.util.ListIterator;

public class DoublyLinkedList<E> implements ListInterface<E>{
	protected DLLNode<E> front; // reference to the front of this list
	protected DLLNode<E> rear; // reference to the rear of this list
	protected int numElements = 0; // number of elements in this list

	// set by find method
	protected boolean found; // true if target found, else false
	protected int targetIndex; // list index of target, if found
	protected DLLNode<E> location; // node containing target, if found
	protected DLLNode<E> previous; // node preceding location
	private Where where;
	
	public ListIterator<E> iterator1()  { return new DoublyLinkedListIterator<E>(); }

	public Where getWhere() {
		return where;
	}

	public void setWhere(Where where) {
		this.where = where;
	}

	public DoublyLinkedList() {
		numElements = 0;
		front = null;
		rear = null;
	}

	public boolean add(E e)
	// Adds element to the end of this list.
	{
		DLLNode<E> newNode = new DLLNode<E>(e);
		if (rear == null)
			front = newNode;
		else {
			rear.setBack(newNode);
			newNode.setForward(rear);}
		rear = newNode;
		numElements++;
		return true;
	}

	public boolean add(Where where, E element)
	// Adds the value of element to the beginning of this list
	{
		switch (where) {
		case FRONT:
			DLLNode<E> newNode = new DLLNode<E>(element); // node being added
			newNode.setBack(front);
			newNode.setForward(null);
			if (front == null) // Adding into an empty list
			{
				front = newNode;
				rear = newNode;
			} else // Adding into a non-empty list
			{
				front.setBack(newNode);
				rear = newNode;
			}
			numElements++;
			break;

		case BACK:
			DLLNode<E> newNode1 = new DLLNode<E>(element); // node being added
			newNode1.setBack(null);
			newNode1.setForward(rear);
			if (front == null) // Adding into an empty list
			{
				front = newNode1;
				rear = newNode1;
			} else // Adding into a non-empty list
			{
				front.setForward(newNode1);
				rear = newNode1;
			}
			numElements++;

		case MIDDLE:
			break;

		default:
			break;

		}
		return true;
	}

	protected void find(E target)
	// Searches list for an occurence of an element e such that
	// e.equals(target). If successful, sets instance variables
	// found to true, location to node containing e, previous
	// to the node that links to location, and index to the index of
	// the location. If not successful, sets found to false.
	{
		location = front;
		found = false;
		targetIndex = -1;

		while (location != null) {
			targetIndex++;
			if (location.getInfo().equals(target)) // if they match
			{
				found = true;
				return;
			} else {
				previous = location;
				location = location.getBack();
			}
		}
	}

	public int size()
	// Returns the number of elements on this list.
	{
		return numElements;
	}

	public boolean contains(E e)
	// Returns true if this list contains an element e such that
	// e.equals(target); otherwise, returns false.
	{
		find(e);
		return found;
	}

	public boolean remove(E target)
	// Removes an element e from this list such that e.equals(target)
	// and returns true; if no such element exists, returns false.
	{
		find(target);
		if (found) {
			if (front == location)
				front = front.getBack(); // remove first node

			else
				previous.setBack(location.getBack()); // remove node at location

			if (front == null)
				rear = null; // removed only element

			numElements--;
		}
		return found;
	}

	public E get(E target)
	// Returns an element e from this list such that e.equals(target);
	// if no such element exists, returns null.
	{
		find(target);
		if (found)
			return location.getInfo();
		else
			return null;
	}

	public boolean isEmpty()
	// Returns true if this list is empty; otherwise, returns false.
	{
		return (numElements == 0);
	}

	public boolean isFull()
	// Returns false.
	{
		return false; // list is unbounded.
	}

	public boolean add(Where where, int i, E e) {
		switch (where) {
		case FRONT:
			if ((i < 0) || (i > size()))
				throw new IndexOutOfBoundsException("Illegal index of " + i + " passed to LBList add method.\n");

			DLLNode<E> newNode = new DLLNode<E>(e);

			if (front == null) // adding to empty list
			{
				front = newNode;
				rear = newNode;
			} else {
				newNode.setBack(front);
				front.setForward(newNode);
				front = newNode;
			}

			break;
		case BACK:
			if ((i < 0) || (i > size()))
				throw new IndexOutOfBoundsException("Illegal index of " + i + " passed to LBList add method.\n");

			DLLNode<E> newNode1 = new DLLNode<E>(e);

			if (i == size()) // add to rear
			{
				rear.setBack(newNode1);
				newNode1.setForward(rear);
				rear = newNode1;
			}
			break;

		case MIDDLE:
			if ((i < 0) || (i > size()))
				throw new IndexOutOfBoundsException("Illegal index of " + i + " passed to LBList add method.\n");

			DLLNode<E> newNode2 = new DLLNode<E>(e);

			DLLNode<E> node = front;
			for (int k = 0; k < (i - 1); k++)
				node = node.getBack();
			newNode2.setBack(node.getBack());
			node.setForward(newNode2.getForward());
			newNode2.setForward(node);
			node.setBack(newNode2);

			break;
		}
		numElements++;
		return true;
	}

	public E set(int index, E newElement)
	// Throws IndexOutOfBoundsException if passed an index argument
	// such that index < 0 or index >= size().
	// Otherwise, replaces element on this list at position index with
	// newElement and returns the replaced element.
	{
		if ((index < 0) || (index >= size()))
			throw new IndexOutOfBoundsException("Illegal index of " + index + " passed to LBList set method.\n");

		DLLNode<E> node = front;
		for (int i = 0; i < index; i++)
			node = node.getBack();
		E hold = node.getInfo();
		node.setInfo(newElement);
		return hold;
	}

	public E get(int index)
	// Throws IndexOutOfBoundsException if passed an index argument
	// such that index < 0 or index >= size().
	// Otherwise, returns the element on this list at position index.
	{
		if ((index < 0) || (index >= size()))
			throw new IndexOutOfBoundsException("Illegal index of " + index + " passed to LBList set method.\n");

		DLLNode<E> node = front;
		for (int i = 0; i < index; i++)
			node = node.getBack();
		return node.getInfo();
	}

	public int indexOf(E target)
	// If this list contains an element e such that e.equals(target),
	// then returns the index of the first such element.
	// Otherwise, returns -1.
	{
		find(target);
		if (found)
			return targetIndex;
		else
			return -1;
	}

	public E remove(int index)
	// Throws IndexOutOfBoundsException if passed an index argument
	// such that index < 0 or index >= size().
	// Otherwise, removes element on this list at position index and
	// returns the removed element; all current elements at positions
	// higher than that index have 1 subtracted from their position.
	{
		if ((index < 0) || (index >= size()))
			throw new IndexOutOfBoundsException("Illegal index of " + index + " passed to LBList remove method.\n");

		E hold; // holds info for return
		if (index == 0) // remove the front node
		{
			hold = front.getInfo();
			front = front.getBack();
			if (numElements == 1) // removing only node
				rear = null;
		} else {
			// locate previous node
			DLLNode<E> node = front;
			for (int i = 0; i < (index - 1); i++)
				node = node.getBack();
			hold = node.getBack().getInfo();
			if (node.getBack() == rear) // removing rear node
				rear = node;
			node.setBack(node.getBack().getBack());
		}

		numElements--;
		return hold;
	}

	public Iterator<E> iterator()
	// Returns an Iterator over this list.
	{
		return new Iterator<E>() {
			private DLLNode<E> prevPos = null; // node before node just returned
			private DLLNode<E> currPos = null; // node just returned
			private DLLNode<E> nextPos = front; // next node to return

			public boolean hasNext()
			// Returns true if the iteration has more elements; otherwise returns false.
			{
				return (nextPos != null);
			}

			public E next()
			// Returns the next element in the iteration.
			// Throws NoSuchElementException - if the iteration has no more elements
			{
				if (!hasNext())
					throw new IndexOutOfBoundsException("Illegal invocation of next " + " in LBList iterator.\n");

				E hold = nextPos.getInfo(); // holds info for return
				if (currPos != null)
					prevPos = currPos; // in case element was removed
				currPos = nextPos;
				nextPos = nextPos.getBack();
				return hold;
			}

			public void remove()
			// Removes from the underlying representation the last element returned
			// by this iterator. This method should be called only once per call to
			// next(). The behavior of an iterator is unspecified if the underlying
			// representation is modified while the iteration is in progress in any
			// way other than by calling this method.
			{
				if (currPos == null) // there is no last element returned by the iterator
					return;
				else {
					if (prevPos == null) // removing front element
					{
						front = nextPos;
						currPos = null;
						if (front == null) // removed only element
							rear = null;
					} else {
						prevPos.setBack(nextPos);
						currPos = null;
					}
					numElements--;
				}
			}
		};
		
	}

}
