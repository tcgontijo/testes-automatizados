package entities;

public class OutsourceEmployee extends Employee {

	private Double additionalCharge;

	public OutsourceEmployee() {
		super();
	}

	public OutsourceEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
		super(name);
		if (hours <= 42)
			this.hours = hours;
		else
			throw new IllegalArgumentException("O máximo de horas permitido é 40!");
		if (valuePerHour < (MINIMUM_WAGE / 42))
			throw new IllegalArgumentException(
					"O valor por hora deve ser maior do que a relação SalárioMínimo/HorasMáximas!");
		else
			this.valuePerHour = valuePerHour;
		this.additionalCharge = additionalCharge;
	}

	public Double getAdditionalCharge() {
		return additionalCharge;
	}

	public void setAdditionalCharge(Double additionalCharge) {
		this.additionalCharge = additionalCharge;
	}
	
	@Override
	public void setHours(Integer hours) {
		if (hours <= 42)
			this.hours = hours;
		else
			throw new IllegalArgumentException("O máximo de horas permitido é 40!");
	}
	
	@Override
	public void setValuePerHour(Double valuePerHour) {
		if (valuePerHour < (MINIMUM_WAGE / 42))
			throw new IllegalArgumentException(
					"O valor por hora deve ser maior do que a relação SalárioMínimo/HorasMáximas!");
		else
			this.valuePerHour = valuePerHour;
	}
	
	@Override
	public Double payment() {
		double value = ((double) (hours * valuePerHour)) + (additionalCharge * 1.1);
		if (value < MINIMUM_WAGE)
			throw new IllegalArgumentException(
					"O Pagamento não pode ser menor do que o valor do salário mínimo(" + MINIMUM_WAGE + ").");
		else
			return value;
	}

}
