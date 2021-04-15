package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tests.factory.EmployeeFactory;
import tests.factory.OutsourceEmployeeFactory;

public class OutsourceEmployeeTests {
	
	@Test
	public void constructorShouldThrowExceptionWhenHoursGreaterThan42() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			OutsourceEmployee e = OutsourceEmployeeFactory.createOutsourceEmployee("José", 43, 50.00, 100.00);
		});

	}

	@Test
	public void constructorShouldSetHoursWhenHoursLessThan42() {

		Integer expectedValue = 41;
		OutsourceEmployee e = OutsourceEmployeeFactory.createOutsourceEmployee("José", expectedValue, 50.00, 100.00);

		Assertions.assertEquals(expectedValue, e.getHours());

	}

	@Test
	public void setHourShouldThrowExceptionWhenHoursGreaterThan42() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			OutsourceEmployee e = OutsourceEmployeeFactory.createEmptyOutsourceEmployee();
			e.setHour(43);
		});

	}

	@Test
	public void setHourShouldSetHoursWhenLessThan42() {

		Integer expectedValue = 40;
		OutsourceEmployee e = OutsourceEmployeeFactory.createEmptyOutsourceEmployee();
		e.setHour(expectedValue);

		Assertions.assertEquals(expectedValue, e.getHours());

	}

	@Test
	public void setValuePerHourShouldThrowExceptionWhenValueLessThanMinimumWagePerMaxHours() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Double minimumValuePerHour = Employee.MINIMUM_WAGE / 42;
			OutsourceEmployee e = OutsourceEmployeeFactory.createEmptyOutsourceEmployee();
			e.setValuePerHour(minimumValuePerHour - 1);
		});

	}

	@Test
	public void setValuePerHourShouldSetWhenValueGreaterThanOrEqualToMinimumWagePerMaxHours() {

		Double minimumValuePerHour = Employee.MINIMUM_WAGE / 42;
		Double expectedValue = minimumValuePerHour;
		OutsourceEmployee e = OutsourceEmployeeFactory.createEmptyOutsourceEmployee();
		e.setValuePerHour(expectedValue);

		Assertions.assertEquals(expectedValue, e.getValuePerHour());

	}

	@Test
	public void paymentShouldThrowExceptionWhenValueLessThanMinimumWage() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Double minimumValuePerHour = Employee.MINIMUM_WAGE / 42;
			OutsourceEmployee e = OutsourceEmployeeFactory.createOutsourceEmployee("José", 38,	minimumValuePerHour, 100.00);
			e.payment();
		});
	}

	@Test
	public void paymentShouldReturnPaymentValueWhenValueGreaterThanOrEqualToMinimumWage() {
		Double minimumValuePerHour = Employee.MINIMUM_WAGE / 40;
		Double expectedValue = minimumValuePerHour + 20.00;
		OutsourceEmployee e = OutsourceEmployeeFactory.createOutsourceEmployee("José", 40,	expectedValue, 100.00);
		
		Assertions.assertEquals(expectedValue, e.payment());

	}

}
