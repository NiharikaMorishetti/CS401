package test;

public class DLLNode<E> 
{
  public E info;
  public DLLNode<E> forward, back;
  
  public DLLNode(E info)
  {
    this.info = info; forward = null; back = null;
  }
 
  public void setInfo(E info){this.info = info;}
  public E getInfo(){return info;}
  
  public void setForward(DLLNode<E> forward){this.forward = forward;}
  public void setBack(DLLNode<E> back){this.back = back;}
  
  public DLLNode<E> getForward(){return forward;}
  public DLLNode<E> getBack(){return back;}
}
