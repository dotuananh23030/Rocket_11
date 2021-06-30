package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "DonHang")
public class DonHang implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DonHangID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "DonHangName", length = 30, nullable = false, unique = true)
	private String name;
	
	@Column(name = "Soluong",  nullable = false)
	private int soLuong;

	@OneToMany(mappedBy = "DonHang")
	private List<Account> accounts;
	
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false, updatable = false)
	private Account author;

	@Column(name = "ModifiedDate", updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date modifiedDate;
	
	@Column(name = "CreateDate", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public DonHang() {
	}

	public DonHang(String name, int soLuong) {
		this.name = name;
		this.soLuong = soLuong;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAuthor() {
		return author;
	}

	public void setAuthor(Account author) {
		this.author = author;
	}
	
	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
}
