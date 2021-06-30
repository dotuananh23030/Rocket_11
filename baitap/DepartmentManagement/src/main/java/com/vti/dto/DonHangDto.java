package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DonHangDto {
	private short id;

	private String name;
	
	private int soLuong;

	private AccountDto author;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createDate;

	
	public DonHangDto(short id, String name, int soLuong, AccountDto author, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.soLuong = soLuong;
		this.author = author;
		this.createDate = createDate;
	}

	public short getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getSoLuong() {
		return soLuong;
	}

	public AccountDto getAuthor() {
		return author;
	}

	public Date getCreateDate() {
		return createDate;
	}

}
