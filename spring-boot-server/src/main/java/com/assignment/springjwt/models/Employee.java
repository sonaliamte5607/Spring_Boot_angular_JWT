package com.assignment.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {

	private long id;
	
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String emailId;
	@NotBlank
	private String company;
	@NotBlank
	private String dob;
	@NotBlank
	private String mobile;	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String emailId,String company,String dob,String mobile) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.company=company;
		this.dob=dob;
		this.mobile=mobile;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	
}
