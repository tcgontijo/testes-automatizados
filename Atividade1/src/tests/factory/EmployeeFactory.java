package tests.factory;

import entities.Employee;

public class EmployeeFactory {

	public static Employee createEmployee(String name, int hours, double ValuePerHour) {
		return new Employee(name, hours, ValuePerHour);
	}

	public static Employee createEmptyEmployee() {
		return new Employee();
	}
	
	
	
	
	
}
