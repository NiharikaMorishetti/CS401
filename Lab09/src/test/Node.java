package test;
class Node
{
    protected String Name;
    protected int ID;
    protected Node link;
 
    /*  Constructor  */
    public Node()
    {
        link = null;
        Name = null;
        ID = 0;
    }    
    /*  Constructor  */
    public Node(String d,int i, Node n)
    {
        Name = d;
        ID = i;
        link = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }    
    /*  Function to set Name to current Node  */
    public void setName(String d)
    {
        Name = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get Name from current Node  */
    public String getName()
    {
        return Name;
    }
    public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}