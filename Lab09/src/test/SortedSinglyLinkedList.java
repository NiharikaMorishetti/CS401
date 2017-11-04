package test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SortedSinglyLinkedList
{
    public static void main(String[] args)
    {   
    		linkedList ll = new linkedList();
    		Node N = new Node();
    		Scanner sc = null;
    		try {
    			sc = new Scanner(new File("emp.txt"));
    		}catch(FileNotFoundException e) {
    			e.printStackTrace();
    		}
    		while(sc.hasNextLine()) {
    			for(int i = 0; i < 30; i ++) {
    				String a = sc.nextLine();
    				N.setID(Integer.parseInt(a.split(" ")[1]));
    				N.setName(a.split(" ")[0]);
    				ll.add(N.getName(), N.getID());
    			}
    			ll.display();
    		}
    }
}