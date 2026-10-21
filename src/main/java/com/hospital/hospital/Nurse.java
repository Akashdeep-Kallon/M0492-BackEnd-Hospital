package com.hospital.hospital;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nurse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String user;
	private String pw;
	private String name;

	public Nurse() {
		super();
	}

	public Nurse(Integer id, String name, String user, String pw) {
		this.id = id;
		this.name = name;
		this.user = user;
		this.pw = pw;
	}
	
	public Integer getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}
}
