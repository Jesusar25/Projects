package application;

public class HealthProfile {
	
	private int age;
	private double weightInPounds;
	private double heightInInches;
	
	public HealthProfile()
	{
		this(0,0.0,0.0);
	}
	
	public HealthProfile(int age, double weightInPounds, double heightInInches) {
		super();
		this.age = age;
		this.weightInPounds = weightInPounds;
		this.heightInInches = heightInInches;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setWeightInPounds(double weightInPounds) {
		this.weightInPounds = weightInPounds;
	}
	
	public double getWeightInPounds() {
		return weightInPounds;
	}
	
	public void setHeightInInches(double heightInInches) {
		this.heightInInches = heightInInches;
	}
	
	public double getHeightInInches() {
		return heightInInches;
	}
	
	public double BMIIndex()
	{
		return (weightInPounds * 703) / (heightInInches * heightInInches);
	}
	
	public String getBMICategory()
	{
		double BMI = BMIIndex();
		
		if( BMI < 18.5)
			return "Underweight";
		else if (BMI < 25)
			return "Normal";
		else if(BMI < 30)
			return "Overweight";
		else
			return "Obese";
	}
	
	public String calcTargetHeartRateRange()
	{
		double maximumHeartRate = 220 - age;
		
		return String.format("&.1f - %.1f", maximumHeartRate * 0.5, maximumHeartRate * 0.85);
	}

}
