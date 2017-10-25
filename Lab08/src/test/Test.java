package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Test {


	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner sc = new Scanner(new File("emp.txt"));
		LinkedQueue<String> queue = new LinkedQueue<String>();	
		ArrayBoundedQueue<String> bqueue = new ArrayBoundedQueue<String>();
		ArrayUnboundedQueue<String> ubqueue = new ArrayUnboundedQueue<String>();
		String line;
		Employee[] emp = new Employee[30];
		while (sc.hasNextLine()) {

			for (int i = 0; i < 30; i++) {
				String name = null;
				int id = 0;
				emp[i] = new Employee(name, id);

				line = sc.nextLine();
				
				emp[i].setId(Integer.parseInt(line.split(" ")[1]));
				emp[i].setName(line.split(" ")[0]);
				
				queue.enqueue(line);
			}
		}
		
		System.out.println("\nPart1 \nQueue: \n");
		while(!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
		
		System.out.println("\n****************************************\n");
		System.out.println("Part2 \nFixed Front Array: \n");
		Scanner sc1 = new Scanner(new File("emp.txt"));
		while(sc1.hasNextLine()) {
			bqueue.enqueue(sc1.nextLine());
		}
		while(!bqueue.isEmpty()) {
			System.out.println(bqueue.dequeue());
		}
		
		System.out.println("\n****************************************\n");
		System.out.println("Part2 \nFloating Front Array: \n");
		Scanner sc2 = new Scanner(new File("emp.txt"));
		while(sc2.hasNextLine()) {
			ubqueue.enqueue(sc2.nextLine());
		}
		while(!ubqueue.isEmpty()) {
			System.out.println(ubqueue.dequeue());
		}
		
		System.out.println("\n****************************************\n");
		System.out.println("Check Palindrome\n");
		System.out.println("Enter a String please:");
		Scanner sc3 = new Scanner(System.in);
		String word = sc3.next();
		System.out.println(Palindrome.test(word));
		
		
		sc.close();
		sc1.close();
		sc2.close();
		sc3.close();
	}
	
	

}
