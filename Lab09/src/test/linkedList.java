package test;
class linkedList<E> implements ListInterface<E>
{
    protected Node start;
    public int size;
    public linkedList()
    {
        start=null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  Function to check size of list  */
    public int getSize()
    {
        return size;
    }    
    /*  Function to insert an element  */
    public void add(E item) {
		Node newNode = new Node();
		newNode.Name = (String) item;
		newNode.link = start;
		start = newNode;
		size++;
	}
    @Override
    public void add(String Name, int ID)
    {
        Node nptr, ptr, tmp = null;
        nptr = new Node(Name, ID , null);
        boolean ins = false;
        if (start == null)
           start = nptr;
        else if (ID <= start.getID())
        {
            nptr.setLink(start);
            start = nptr;
        }
        else
        {
            tmp = start;
            ptr = start.getLink();
            while(ptr != null)
            {
                if (ID >= tmp.getID() && ID <= ptr.getID())
                {
                    tmp.setLink(nptr);
                    nptr.setLink(ptr);
                    ins = true;
                    break;
                }
                else
                {
                    tmp = ptr;
                    ptr = ptr.getLink();
                }
            }
            if (ins == false)
            {
                tmp.setLink(nptr);
            }
        }
        size++;
    }
    /*  Function to delete an element at position  */
    public void remove(int pos)
    {        
        if (pos == 1) 
        {
            start = start.getLink();
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node ptr = start;
 
            for (int i = 1; i < size - 1; i++)
                ptr = ptr.getLink();
            ptr.setLink(null);            
            size --;
            return;
        }
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
    }    
    /*  Function to display elements  */
    public boolean isFull() {
    		return false;
    }
    public void display()
    {
        System.out.println("Sorted Singly Linked List = ");
        if (size == 0) 
        {
            System.out.println("empty\n");
            return;
        }
        if (start.getLink() == null) 
        {
            System.out.println(start.getID() );
            System.out.println(start.getName() );
            return;
        }
        Node ptr = start;
        System.out.println(start.getID()+ "(" + start.getName() +")");
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            System.out.println(ptr.getID()+ "(" + ptr.getName() +")");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getID()+ "(" + ptr.getName() +")\n");
    }
}