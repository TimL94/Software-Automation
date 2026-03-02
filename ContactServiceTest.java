package test;

import contact.Contact;
import contact.ContactService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

/*
 * ContactServiceTest.java
 *
 * Author: Tim Lee
 *
 * This test class verifies the behavior of the
 * ContactService class, including adding, deleting,
 * updating contacts, and handling invalid input.
 */

public class ContactServiceTest {

	// Tests adding a valid contact and retrieving it
	@Test
	@DisplayName("Test Add Contact")
	void testAddContact() {
		
		ContactService service = new ContactService();
		Contact contact = new Contact(
				"1234567890",
				"Timothy",
				"Lee",
				"6038675309",
				"121 Real Street"
		);
		service.addContact(contact);
		
		Contact retrieveContact = service.getContact("1234567890");
		Assertions.assertNotNull(retrieveContact);
		Assertions.assertEquals("Timothy", retrieveContact.getFirstName());
		Assertions.assertEquals("Lee", retrieveContact.getLastName());
		Assertions.assertEquals("6038675309", retrieveContact.getPhone());
		Assertions.assertEquals("121 Real Street", retrieveContact.getAddress());
	}

	// Tests deleting an existing contact
	@Test
	@DisplayName("Test Delete Contact")
	void testDeleteContact() {
		
		ContactService service = new ContactService();
		Contact contact = new Contact(
				"1234567890",
				"Timothy",
				"Lee",
				"6038675309",
				"121 Real Street"
		);
		service.addContact(contact);
		service.deleteContact(contact.getContactId());
		
		Assertions.assertNull(service.getContact("1234567890"));
	}

	// Tests updating an existing contact
	@Test
	@DisplayName("Test Update Contact")
	void testUpdateContact() {
		
		ContactService service = new ContactService();
		Contact contact = new Contact(
				"1234567890",
				"Timothy",
				"Lee",
				"6038675309",
				"121 Real Street"
		);
		service.addContact(contact);
		
		service.updateContact(
				"1234567890", 
				"Joseph", 
				"Adams", 
				"6038675305", 
				"121 Other Street"
		);
		
		Assertions.assertEquals("Joseph", contact.getFirstName());
		Assertions.assertEquals("Adams", contact.getLastName());
		Assertions.assertEquals("6038675305", contact.getPhone());
		Assertions.assertEquals("121 Other Street", contact.getAddress());
	}
	
	// Tests that adding a null contact throws an exception
	@Test
	@DisplayName("Test null Contact Throws")
	void testNullContactThrow() {
		ContactService service = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(null);
		});
	}
	
	// Tests that deleting with a null ID throws an exception
	@Test
	@DisplayName("Test null ID in Delete")
	void testNullIdInDelete() {
		ContactService service = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact(null);
		});
	}
	
	// Tests that updating with a null contact ID throws an exception
	@Test
	@DisplayName("Test null Update Contact Throws")
	void testNullUpdateContactThrow() {
		ContactService service = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateContact(null, null, null, null, null);
		});
	}

}
