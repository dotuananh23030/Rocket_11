package com.vti.academy.entity;

public abstract class Phone {
	private String[] contacts;
	private String number;
	private String name;
	
	public abstract void  insertContact(String name,String phone);
	public abstract void  removeContact(String name);
	public abstract void  updateContact(String name,String newPhone);
	public abstract void  searchContact(String name);
	public String[] getContacts() {
		return contacts;
	}
	
	public void setContacts(String[] contacts) {
		this.contacts = contacts;
	}
}
