package test;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedListApp<E> implements Iterable<E> {
	private int n;        // number of elements on list
	private Node pre;     // sentinel before first item
	private Node post;    // sentinel after last item

	public DoublyLinkedListApp() {
		pre  = new Node();
		post = new Node();
		pre.next = post;
		post.prev = pre;
	}

	// linked list node helper data type
	private class Node {
		private E item;
		private Node next;
		private Node prev;
	}

	public boolean isEmpty()    { return n == 0; }
	public int size()           { return n;      }

	// add the item to the list
	public void add(E item) {
		Node last = post.prev;
		Node x = new Node();
		x.item = item;
		x.next = post;
		x.prev = last;
		post.prev = x;
		last.next = x;
		n++;
	}

	public ListIterator<E> iterator()  { return new DoublyLinkedListIterator(); }

	// assumes no calls to DoublyLinkedList.add() during iteration
	private class DoublyLinkedListIterator implements ListIterator<E> {
		private Node current      = pre.next;  // the node that is returned by next()
		private Node lastAccessed = null;      // the last node to be returned by prev() or next()
		// reset to null upon intervening remove() or add()
		private int index = 0;

		public boolean hasNext()      { return index < n; }
		public boolean hasPrevious()  { return index > 0; }
		public int previousIndex()    { return index - 1; }
		public int nextIndex()        { return index;     }

		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			lastAccessed = current;
			E item = current.item;
			current = current.next; 
			index++;
			return item;
		}

		public E previous() {
			if (!hasPrevious()) throw new NoSuchElementException();
			current = current.prev;
			index--;
			lastAccessed = current;
			return current.item;
		}

		// replace the item of the element that was last accessed by next() or previous()
		// condition: no calls to remove() or add() after last call to next() or previous()
		public void set(E item) {
			if (lastAccessed == null) throw new IllegalStateException();
			lastAccessed.item = item;
		}

		// remove the element that was last accessed by next() or previous()
		// condition: no calls to remove() or add() after last call to next() or previous()
		public void remove() { 
			if (lastAccessed == null) throw new IllegalStateException();
			Node x = lastAccessed.prev;
			Node y = lastAccessed.next;
			x.next = y;
			y.prev = x;
			n--;
			if (current == lastAccessed)
				current = y;
			else
				index--;
			lastAccessed = null;
		}

		// add element to list 
		public void add(E item) {
			Node x = current.prev;
			Node y = new Node();
			Node z = current;
			y.item = item;
			x.next = y;
			y.next = z;
			z.prev = y;
			y.prev = x;
			n++;
			index++;
			lastAccessed = null;
		}

	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (E item : this)
			s.append(item + " ");
		return s.toString();
	}

	// a test client
	public static void main(String[] args) {
		int n  = 15;

		// add elements 1, ..., n
		System.out.println(n + " random integers between 0 and 99");
		DoublyLinkedListApp<Integer> list = new DoublyLinkedListApp<Integer>();
		for (int i = 0; i < n; i++)
			list.add(StdRandom.uniform(100));
		System.out.println(list);
		System.out.println();
		
		System.out.println("print_from_begining");
		ListIterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();
		
		System.out.println("print_from_end");
		while(iterator.hasPrevious()) {
			System.out.println(iterator.previous());
		}
	}
}