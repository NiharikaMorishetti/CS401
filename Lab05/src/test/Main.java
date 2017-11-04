package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("emp.txt");
		Scanner scan = new Scanner(file);
		StackInterface<String>stringStack;
		
		stringStack= new ArrayListStack<String>();
		//ArrayList<String> list = new ArrayList<String>();
		
		String line;
		Employee[] emp = new Employee[30];
		while (scan.hasNextLine()) {

			for (int i = 0; i < 30; i++) {
				String name = null;
				int id = 0;
				emp[i] = new Employee(name, id);

				line = scan.nextLine();
				
				emp[i].setId(Integer.parseInt(line.split(" ")[1]));
				emp[i].setName(line.split(" ")[0]);
				stringStack.push(line);
			}
			
		}
		
		
		System.out.println("The top element before poped");
		line = stringStack.peek();
		System.out.println(line);
		System.out.println();
		
		System.out.println("The poped items:");
		System.out.println(stringStack.peek());
		stringStack.pop();
		System.out.println(stringStack.peek());
		stringStack.pop();
		System.out.println();
		
		System.out.println("The top element after poped");
		line = stringStack.peek();
		System.out.println(line);
		System.out.println();
		System.out.println("**********************************************");
		System.out.println();
		

		Scanner scan2 = new Scanner(file);
		StackInterface<String>myStack;
		myStack= new LinkedStack<String>();
		String line2;
		while (scan2.hasNextLine()) {
				line2 = scan2.nextLine();
				myStack.push(line2);	
		}

		System.out.println("Stack implementation with LinkedList:");
		System.out.println();
		System.out.println("The top element before poped");
		line2 = stringStack.peek();
		System.out.println(line2);
		System.out.println();
		
		System.out.println("The poped items:");
		System.out.println(stringStack.peek());
		stringStack.pop();
		System.out.println(stringStack.peek());
		stringStack.pop();
		System.out.println();
		
		System.out.println("The top element after poped");
		line2 = stringStack.peek();
		System.out.println(line2);
		scan2.close();
		scan.close();
	}
}
