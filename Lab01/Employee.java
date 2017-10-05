package test;

import java.util.Comparator;

public class Employee implements Comparable<Employee>, Comparator<Employee>{
	private int id;
	private String name;
	
	public Employee() {
		super();
		this.id = 0;
		this.name = "null";
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[id=" + this.id + ", name=" + this.name + "]";
	}

    @Override
	public int compareTo(Employee employee1) {
		if(this.getId()==employee1.getId()) {
			return 0;
		}
		else if(this.getId()>employee1.getId()) {
			return 1;
		}
		return -1;
	}
	

	@Override
	public int compare(Employee employee1, Employee employee2) {
		if (employee1.getName().equals(employee2.getName())){
			if(employee1.getId()==employee2.getId()) {
				return 0;
			}else if(employee1.getId()>employee2.getId()) {
				return 1;
			}
			return -1;
		}
		return -2;
	}
	@Override
	public boolean equals(Employee employee1) {
		if(employee1.getName().equals(this.getName())){
			if(employee1.getId()==this.getId()) {
				return true;
			}
		}
		return false;
	}
}
