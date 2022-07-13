package com.qa.dfespringbootproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private int age;
	
	@Column(unique = true)
	private String email;
	
//	Default constructor
	public Patient() {}

//	without ID
	public Patient(String firstName, String lastName, int age, long telephoneNumber) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.email = telephoneNumber;
}
	
//	With ID Constructor
	public Patient(long id, String firstName, String lastName, int age, long telephoneNumber) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.email = telephoneNumber;
}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getTelephoneNumber() {
		return email;
	}

	public void setTelephoneNumber(long telephoneNumber) {
		this.email = telephoneNumber;
	}

	
	
	
	

}
