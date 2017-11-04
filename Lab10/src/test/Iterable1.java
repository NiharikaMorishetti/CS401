package test;

public interface Iterable1<E>
{
	boolean hasNext();
	
	boolean hasPrevious();
	
	E next();
	
	E previous();

	void remove();
	
	void print_from_beginning();
	
	void print_from_end();
}
