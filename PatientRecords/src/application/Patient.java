package application;

public abstract class Patient {
	
	private String insuranceId;
	private String firstName;
	private String lastName;
	private HealthProfile profile;
	
	public Patient()
	{
		this("","","",null);
	}
	
	
	public Patient(String insuranceId, String firstName, String lastName, HealthProfile profile) {
		this.insuranceId = insuranceId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profile = profile;
	}

	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	
	public String getInsuranceId() {
		return insuranceId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setProfile(HealthProfile profile) {
		this.profile = profile;
	}
	
	public HealthProfile getProfile() {
		return profile;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s - %s %s%n", getInsuranceId(),getFirstName(), getLastName() );
	}
	
	public abstract String getCareDetails();

}
