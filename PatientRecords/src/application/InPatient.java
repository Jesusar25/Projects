package application;

public class InPatient extends Patient{
	
	private String roomNumber;
	private int daysAdmitted;
	
	public InPatient()
	{
		this("","","",null,"",0);
	}

	public InPatient(String insuranceId, String firstName, String lastName, HealthProfile profile, String roomNumber, int daysAdmitted) {
		super(insuranceId,firstName,lastName,profile);
		this.roomNumber = roomNumber;
		this.daysAdmitted = daysAdmitted;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setDaysAdmitted(int daysAdmitted) {
		this.daysAdmitted = daysAdmitted;
	}
	
	public int getDaysAdmitted() {
		return daysAdmitted;
	}

	@Override
	public String getCareDetails()
	{
		return "Patient type: Inpatient\nRoom Number: " + roomNumber + "\nDays Admitted: " + daysAdmitted;
	}
}
