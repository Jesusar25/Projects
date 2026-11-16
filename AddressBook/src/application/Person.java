package application;

public class Person extends Contact {
	private String firstname;
	private String lastname;
	private String email;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Person(String address, String phoneNumber, String firstname, String lastname, String email) {
		super(address, phoneNumber);
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
    public Person()
	{
		this("","","","","");
	}

	@Override
	public String toString()
	{
		return String.format("%s %s", getFirstname(),getLastname());
	}
	@Override
	public String getContactString()
	{
		return String.format("Name: %s %s%n%sEmail:%s%n", getFirstname(),getLastname(), super.getContactString(),
				getEmail());
	}

	
	

}
