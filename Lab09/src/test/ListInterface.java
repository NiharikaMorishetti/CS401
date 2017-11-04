package test;

public interface ListInterface<E> {
	public boolean isEmpty();
	public int getSize();
	public void add(String Name, int ID);
	public void remove(int pos);
	public boolean isFull();
	public void display();
	public void add(E item);
}
