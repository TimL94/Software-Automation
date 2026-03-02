package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import contact.Contact;

/*
 * ContactTest.java
 *
 * Author: Tim Lee
 *
 * This test class validates the Contact object
 * by ensuring all field constraints are enforced
 * during object creation.
 */

public class ContactTest {

	// Tests successful contact creation
	@Test
	@DisplayName("Test Valid Contact Creation")
	void testValidContactCreation() {
		Contact contact = new Contact(
				"1234567890",
				"Timothy",
				"Lee",
				"6038675309",
				"121 Real Street"
		);
		
		Assertions.assertEquals("1234567890", contact.getContactId());
		Assertions.assertEquals("Timothy", contact.getFirstName());
		Assertions.assertEquals("Lee", contact.getLastName());
		Assertions.assertEquals("6038675309", contact.getPhone());
		Assertions.assertEquals("121 Real Street", contact.getAddress());
	}
	
	// Tests for contact ID validation
	@Test
	@DisplayName("Test Contact ID too long")
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"12345678901",
					"Timothy",
					"Lee",
					"6038675309",
					"121 Real Street"
			);
		});
	}
	
	@Test
	@DisplayName("Test Contact ID null")
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					null,
					"Timothy",
					"Lee",
					"6038675309",
					"121 Real Street"
			);
		});
	}

	// Tests for first name validation
	@Test
	@DisplayName("Test First Name too long")
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890",
					"Timothy failure",
					"Lee",
					"6038675309",
					"121 Real Street"
			);
		});
	}
	
	@Test
	@DisplayName("Test First Name null")
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890",
					null,
					"Lee",
					"6038675309",
					"121 Real Street"
			);
		});
	}

	// Tests for last name validation
	@Test
	@DisplayName("Test Last Name too long")
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890",
					"Timothy",
					"Lee failed test",
					"6038675309",
					"121 Real Street"
			);
		});
	}
	
	@Test
	@DisplayName("Test Last Name null")
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890",
					"Timothy",
					null,
					"6038675309",
					"121 Real Street"
			);
		});
	}
	
	// Tests for phone number validation
	@Test
	@DisplayName("Test Phone too long")
	void testPhoneLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890",
					"Timothy",
					"Lee",
					"60386753091",
					"121 Real Street"
			);
		});
	}
	
	@Test
	@DisplayName("Test Phone null")
	void testPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890",
					"Timothy",
					"Lee",
					null,
					"121 Real Street"
			);
		});
	}
	
	@Test
	@DisplayName("Test Phone not digits")
	void testPhoneNotDigits() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890",
					"Timothy",
					"Lee",
					"603867530A",
					"121 Real Street"
			);
		});
	}
	
	// Tests for address validation
	@Test
	@DisplayName("Test Address too long")
	void testAddressLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890",
					"Timothy",
					"Lee",
					"6038675309",
					"121 Real Street 121 FAIL Street"
			);
		});
	}
	
	@Test
	@DisplayName("Test Address null")
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(
					"1234567890",
					"Timothy",
					"Lee",
					"6038675309",
					null
			);
		});
	}

}

