package com.assignment.springjwt.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "manager", 

uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") 
	})
public class Manager {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank
@Size(max = 20)
private String username;



@NotBlank
@Size(max = 120)
private String firstname;

@NotBlank
@Size(max = 200)
private String lastname;


@NotBlank
@Size(max = 50)
@Email
private String email;

@NotBlank
@Size(max = 120)
private String password;

@NotBlank
private String dob;

@NotBlank
private String company;


public Manager() {
}

public Manager(String username, String firstname,String lastname,String email,String dob,String company,String password) {
	this.username = username;
	this.firstname=firstname;
	this.lastname=lastname;
	this.email = email;
	this.dob=dob;
	this.company=company;
	this.password = password;

	
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}






}
