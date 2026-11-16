package application;

public class Contact {
	private String address;
	private String phoneNumber;
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Contact(String address, String phoneNumber) {
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public Contact()
	{
		this("","");
	}
	public String getContactString()
	{
	    return String.format("Address: %s%nPhone Number: %s%n", getAddress(),getPhoneNumber());
	}

}
