package application;

public class OutPatient extends Patient {
	
	private String clinicName;
	private String nextAppointmentDate;
	
	public OutPatient()
	{
		this("","","",null,"","");
	}

	public OutPatient(String insuranceId, String firstName, String lastName, HealthProfile profile,String clinicName,String nextAppointmentDate) {
		super(insuranceId,firstName,lastName,profile);
		this.clinicName = clinicName;
		this.nextAppointmentDate = nextAppointmentDate;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getnextAppointmentDate() {
		return nextAppointmentDate;
	}

	public void setnextAppointmentDate(String nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
	}
	
	@Override
	public String getCareDetails()
	{
		return "Patient type: Outpatient\nClinic Name: " + clinicName + "\nNext Appointment: " + nextAppointmentDate;
	}

}
