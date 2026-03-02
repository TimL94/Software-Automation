package contact;

import java.util.ArrayList;
import java.util.List;

/*
 * ContactService.java
 *
 * Author: Tim Lee
 *
 * This service class manages Contact objects.
 * It provides functionality to add, delete,
 * update, and retrieve contacts using an
 * in-memory list.
 */

public class ContactService {

    // In-memory list to store contacts
    private final List<Contact> contacts = new ArrayList<>();

    // Adds a new contact with a unique ID
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        if (findById(contact.getContactId()) != null) {
            throw new IllegalArgumentException("Duplicate contact ID");
        }

        contacts.add(contact);
    }

    // Deletes a contact using the contact ID
    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }

        Contact existing = findById(contactId);
        if (existing == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contacts.remove(existing);
    }

    // Updates contact fields except for the immutable contact ID
    public void updateContact(
            String contactId,
            String firstName,
            String lastName,
            String phone,
            String address) {

        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }

        Contact existing = findById(contactId);
        if (existing == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        existing.setFirstName(firstName);
        existing.setLastName(lastName);
        existing.setPhone(phone);
        existing.setAddress(address);
    }

    // Retrieves a contact by ID
    public Contact getContact(String contactId) {
        return findById(contactId);
    }

    // Helper method to locate a contact by ID
    private Contact findById(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }

}
