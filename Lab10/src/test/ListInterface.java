package test;

public interface ListInterface<E>
{
  boolean add(E e);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index > size().
  // Otherwise, adds element to this list at position index; all current 
  // elements at that position or higher have 1 added to their index.
  // Optional. Throws UnsupportedOperationException if not supported.
  
  E set(int i, E newElement);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, replaces element on this list at position index with
  // newElement and returns the replaced element.
  // Optional. Throws UnsupportedOperationException if not supported.
    
  E get(int i);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, returns the element on this list at position index.
  
  int indexOf(E target);
  // If this list contains an element e such that e.equals(target), 
  // then returns the index of the first such element.
  // Otherwise, returns -1.
  
  E remove(int i);
  // Throws IndexOutOfBoundsException if passed an index argument
  // such that index < 0 or index >= size().
  // Otherwise, removes element on this list at position index and
  // returns the removed element; all current elements at positions
  // higher than index have 1 subtracted from their position.
  
  boolean contains(E e);
  
  boolean add(Where where, E e);
  
  boolean add(Where where, int i, E e);
}
