package contact;

/*
 * Contact.java
 *
 * Author: Tim Lee
 *
 * This class represents a Contact object.
 * It enforces validation rules for contact
 * information such as ID, name, phone number,
 * and address.
 */

public class Contact {

	// Unique, immutable contact ID
	private final String contactId;

	// Contact information fields
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(
			String contactId,
			String firstName,
			String lastName,
			String phone,
			String address
	) {
		// Validate contact ID
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid contactId");
		}
		this.contactId = contactId;
		
		// Use setters to apply validation rules
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	
	// Getter methods to retrieve contact information
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	// Setter methods to update contact information with validation
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Illegal First Name");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Illegal Last Name");
		}
		this.lastName = lastName;
	}
	
	// Uses regular expressions to ensure phone number contains only digits
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Illegal Phone Number");
		}
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Illegal Address");
		}
		this.address = address;
	}

}

