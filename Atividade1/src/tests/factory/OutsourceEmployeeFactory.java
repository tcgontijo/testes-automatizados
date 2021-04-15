package tests.factory;

import entities.OutsourceEmployee;

public class OutsourceEmployeeFactory {

	public static OutsourceEmployee createOutsourceEmployee(String name, Integer hours, Double ValuePerHour,
			double additionalCharge) {
		return new OutsourceEmployee(name, hours, ValuePerHour, additionalCharge);
	}

	public static OutsourceEmployee createEmptyOutsourceEmployee() {
		return new OutsourceEmployee();
	}

}
