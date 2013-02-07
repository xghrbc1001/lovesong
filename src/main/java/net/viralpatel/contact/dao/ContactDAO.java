package net.viralpatel.contact.dao;

import java.util.List;

import net.viralpatel.contact.form.Contact;

public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
	public void ediContact(Contact contact);
	public Contact findContactById(Integer id);
	
}
