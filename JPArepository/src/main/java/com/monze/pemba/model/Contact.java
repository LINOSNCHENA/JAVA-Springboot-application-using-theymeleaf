package com.monze.pemba.model;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CONTACTSLIST")
public class Contact {
	private Long id;
	private String name;
	private BigInteger mobile;
	private BigInteger office;
	private int stars;
	@DateTimeFormat(pattern = "yyyy/MM/dd | - |  HH:mm:ss")
	@Column(name = "created_at", columnDefinition = "CURRENT_TIMESTAMP" )
	private Date created_at;

	public Contact() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toUpperCase();
	}

	public BigInteger getMobile() {
		return mobile;
	}

	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}

	public BigInteger getOffice() {
		return office;
	}

	public void setOffice(BigInteger office) {
		this.office = office;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = new Date();
	}

	public Date getCreated_at() {
		return new Date();
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", mobile=" + mobile + ", office=" + office + ", stars=" + stars
				+ ", created_at=" + created_at + "]";
	}
}
