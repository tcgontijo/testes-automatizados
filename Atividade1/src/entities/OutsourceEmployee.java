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
			throw new IllegalArgumentException("O m�ximo de horas permitido � 40!");
		if (valuePerHour < (MINIMUM_WAGE / 42))
			throw new IllegalArgumentException(
					"O valor por hora deve ser maior do que a rela��o Sal�rioM�nimo/HorasM�ximas!");
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
			throw new IllegalArgumentException("O m�ximo de horas permitido � 40!");
	}
	
	@Override
	public void setValuePerHour(Double valuePerHour) {
		if (valuePerHour < (MINIMUM_WAGE / 42))
			throw new IllegalArgumentException(
					"O valor por hora deve ser maior do que a rela��o Sal�rioM�nimo/HorasM�ximas!");
		else
			this.valuePerHour = valuePerHour;
	}
	
	@Override
	public Double payment() {
		double value = ((double) (hours * valuePerHour)) + (additionalCharge * 1.1);
		if (value < MINIMUM_WAGE)
			throw new IllegalArgumentException(
					"O Pagamento n�o pode ser menor do que o valor do sal�rio m�nimo(" + MINIMUM_WAGE + ").");
		else
			return value;
	}

}
