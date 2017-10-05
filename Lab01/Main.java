package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Employee employee1 = new Employee();
		System.out.println("Enter employee1 Name");
		Scanner sc = new Scanner(System.in);
		employee1.setName(sc.nextLine());
		System.out.println("Enter employee1 ID");
		employee1.setId(sc.nextInt());
		System.out.println(employee1.toString());
		
		Employee employee2 = new Employee();
		System.out.println("Enter employee2 Name");
		Scanner sc2 = new Scanner(System.in);
		employee2.setName(sc2.nextLine());
		System.out.println("Enter employee2 ID");
		employee2.setId(sc2.nextInt());
		System.out.println(employee2.toString());
		sc.close();
		sc2.close();
		
		System.out.println(employee1.compareTo(employee2));
		System.out.println(employee1.compare(employee1,employee2));
		System.out.println(employee1.getName().equals(employee2.getName()));
		System.out.println(employee1.getId()>employee2.getId());
	}

}
