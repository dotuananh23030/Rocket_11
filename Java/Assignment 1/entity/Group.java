package com.vti.academy.entity;

import java.time.LocalDate;
import java.util.Date;

public class Group {
	private int id;
	private String name;
	private Account creator;
	private Account[] accounts;
	private Date createDate;
	
	public Group() {
	}
	public Group(int id, String name, Account creator, Account[] accounts, Date createDate) {
		this.id = id;
		this.name = name;
		this.creator = creator;
		this.accounts = accounts;
		this.createDate = createDate;
	}
	public int getid() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate =createDate;
	}

}
