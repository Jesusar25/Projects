package application;

public class Company extends Contact {
	
	private String companyName;
	private Person contactPerson;
	
	public Company()
	{
		this("","","",null);
	}
	
	public Company(String address, String phoneNumber, String companyName, Person contactPerson) {
		super(address, phoneNumber);
		this.companyName = companyName;
		this.contactPerson = contactPerson;
	}

	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public Person getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(Person contactPerson) {
		this.contactPerson = contactPerson;
	}


	@Override
	public String toString()
	{
		return getCompanyName();
	}
	
	@Override
	public String getContactString()
	{
		String info = "";
		info += "Company name: " + getCompanyName();
		info += "\n" + super.getContactString();
		info += "Contact Person";
		info += "\n" + contactPerson.getContactString();
		
		return info;
	}
	

}
