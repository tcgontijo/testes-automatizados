package entities;

public class Employee {
	public static Double MINIMUM_WAGE = 1100.00;

	protected String name;
	protected Integer hours;
	protected Double valuePerHour;

	public Employee() {
	}

	
	public Employee(String name) {
		this.name = name;
	}

	public Employee(String name, Integer hours, Double valuePerHour) {
		this.name = name;
		if (hours <= 40)
			this.hours = hours;
		else
			throw new IllegalArgumentException("O máximo de horas permitido é 40!");

		if (valuePerHour < (MINIMUM_WAGE / 40))
			throw new IllegalArgumentException(
					"O valor por hora deve ser maior do que a relação SalárioMínimo/HorasMáximas!");
		else
			this.valuePerHour = valuePerHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		if (hours <= 40)
			this.hours = hours;
		else
			throw new IllegalArgumentException("O máximo de horas permitido é 40!");
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		if (valuePerHour < (MINIMUM_WAGE / 40))
			throw new IllegalArgumentException(
					"O valor por hora deve ser maior do que a relação SalárioMínimo/HorasMáximas!");
		else
			this.valuePerHour = valuePerHour;
	}

	public Double payment() {
		double value = hours * valuePerHour;
		if (value < MINIMUM_WAGE)
			throw new IllegalArgumentException(
					"O Pagamento não pode ser menor do que o valor do salário mínimo(" + MINIMUM_WAGE + ").");
		else
			return value;
	}

}
