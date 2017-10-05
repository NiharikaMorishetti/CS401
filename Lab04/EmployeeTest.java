package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeTest {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("emp.txt"));
		ArrayList<String> list = new ArrayList<String>();
		Employee[] emp = new Employee[30];
		while (sc.hasNextLine()) {

			for (int i = 0; i < 30; i++) {
				String name = null;
				int id = 0;
				emp[i] = new Employee(name, id);

				String a = sc.nextLine();
				emp[i].setId(Integer.parseInt(a.split(" ")[1]));
				emp[i].setName(a.split(" ")[0]);
			}

		}
//		for (int i = 0; i < 30; i++) {
//			System.out.println(emp[i].getName() + " " + emp[i].getId());
//		}
		
//*********************************************************************	
		System.out.println("Sorted");
		
		double start, end;
		start = System.nanoTime();
		
		for (int i=0; i<emp.length; i++) {
			for (int j=1; j<emp.length-i; j++) {
				if(emp[j-1].getId()>emp[j].getId()) {
					Employee temp = emp[j-1];
					emp[j-1] = emp[j];
					emp[j] = temp;
					
				}
			}
		}
		sc.close();
		end = System.nanoTime() - start;

		for (int i = 0; i <30 ; i++) {
			System.out.println(emp[i].getName() + " " + emp[i].getId());
		}
		System.out.println("Time = " + end + " ns;");
	}

}
