package com.vti.form;

public class DonHangFormForCreating {

	private String name;

	private short authorId;
	
	private int soLuong;

	public DonHangFormForCreating() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthorId(short authorId) {
		this.authorId = authorId;
	}
	
	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getName() {
		return name;
	}

	public short getAuthorId() {
		return authorId;
	}

}
