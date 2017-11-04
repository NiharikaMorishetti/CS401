package test;

import support.LLNode;

public class LinkedStack<T> implements StackInterface<T>
{
  protected LLNode<T> peek;   // reference to the peek of this stack

  public LinkedStack()
  {
    peek = null;
  }

  public void push(T element)
  // Places element at the peek of this stack.
  { 
    LLNode<T> newNode = new LLNode<T>(element);
    newNode.setLink(peek);
    peek = newNode;
  }     

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes peek element from this stack.
  {                  
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else
      peek = peek.getLink();
  }

  public T peek()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns peek element of this stack.
  {                 
    if (isEmpty())
      throw new StackUnderflowException("peek attempted on an empty stack.");
    else
      return peek.getInfo();
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {              
    return (peek == null); 
  }

  public boolean isFull()
  // Returns false - a linked stack is never full
  {              
      return false;
  }

}

