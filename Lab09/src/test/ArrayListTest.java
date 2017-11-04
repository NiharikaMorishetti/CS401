package test;
import java.util.Scanner;

public class ArrayListTest {

	public static void main(String[] args) {
		CS401ArrayImpl<Integer> n = new CS401ArrayImpl<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of elements in arraylist");
		int size = sc.nextInt();
		if(size<10)
		{
			for(int i=0;i<size;i++)
			{
				n.add(i);
				System.out.println(n.get(i));

			}
			System.out.println("Size of Arraylist" + " " + n.size());
		}
		else
		{
			for(int i=0;i<size;i++)
			{
				n.add(i);
				System.out.println(n.get(i));
			}
			
			System.out.println("Size of Arraylist" + " " + n.size());
		}
		sc.close();
	}   

}


