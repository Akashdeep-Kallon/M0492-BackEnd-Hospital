package com.hospital.hospital;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nurse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String user;
	private String pw;
	private String name;

	public Nurse() {
		super();
	}

	public Nurse(String name, String user, String pw) {
		this.name = name;
		this.user = user;
		this.pw = pw;
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
