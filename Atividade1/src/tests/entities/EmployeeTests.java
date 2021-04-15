package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.factory.EmployeeFactory;

public class EmployeeTests {

	@Test
	public void constructorShouldThrowExceptionWhenHoursGreaterThan40() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Employee e = EmployeeFactory.createEmployee("José", 41, 50.00);
		});

	}

	@Test
	public void constructorShouldSetHoursWhenHoursLessThan40() {

		Integer expectedValue = 38;
		Employee e = EmployeeFactory.createEmployee("José", expectedValue, 50.00);

		Assertions.assertEquals(expectedValue, e.getHours());

	}

	@Test
	public void setHourShouldThrowExceptionWhenHoursGreaterThan40() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Employee e = EmployeeFactory.createEmptyEmployee();
			e.setHour(41);
		});

	}

	@Test
	public void setHourShouldSetHoursWhenLessThan40() {

		Integer expectedValue = 38;
		Employee e = EmployeeFactory.createEmptyEmployee();
		e.setHour(expectedValue);

		Assertions.assertEquals(expectedValue, e.getHours());

	}

	@Test
	public void setValuePerHourShouldThrowExceptionWhenValueLessThanMinimumWagePerMaxHours() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Double minimumValuePerHour = Employee.MINIMUM_WAGE / 40;
			Employee e = EmployeeFactory.createEmptyEmployee();
			e.setValuePerHour(minimumValuePerHour - 1);
		});

	}

	@Test
	public void setValuePerHourShouldSetWhenValueGreaterThanOrEqualToMinimumWagePerMaxHours() {

		Double minimumValuePerHour = Employee.MINIMUM_WAGE / 40;
		Double expectedValue = minimumValuePerHour;
		Employee e = EmployeeFactory.createEmptyEmployee();
		e.setValuePerHour(expectedValue);

		Assertions.assertEquals(expectedValue, e.getValuePerHour());

	}

	@Test
	public void paymentShouldThrowExceptionWhenValueLessThanMinimumWage() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Double minimumValuePerHour = Employee.MINIMUM_WAGE / 40;
			Employee e = EmployeeFactory.createEmployee("José", 35,	minimumValuePerHour);
			e.payment();
		});
	}

	@Test
	public void paymentShouldReturnPaymentValueWhenValueGreaterThanOrEqualToMinimumWage() {
		Double minimumValuePerHour = Employee.MINIMUM_WAGE / 40;
		Double expectedValue = minimumValuePerHour + 20.00;
		Employee e = EmployeeFactory.createEmployee("José", 40,	expectedValue);
		
		Assertions.assertEquals(expectedValue, e.payment());

	}
}
