package com.grandviewII.entities;

//import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(query="SELECT e FROM Customer e", name="getAllCustomers")

public class Customer {
	
	@Basic
	@Column
	int cid;
	
	@Basic
	@Column(name="cFname", nullable= false, length=20)
	String cFname;
	
	@Basic
	@Column(name="cLname", nullable= false, length=20)
	String cLname;
	
	// key
	@Id
	@Column(name="cEmail", nullable= false, length=50)
	String cEmail;	
	
	@Basic
	@Column(name="cPassword", nullable= false, length=50)
	String cPassword;
	
	@Basic
	@Column(name="cAddressLine1", nullable = false, length= 50)
	String cAddressLine1;
	
	@Basic
	@Column(name="cAddressLine2",  length= 50)
	String cAddressLine2;
	
	
	@Basic
	@Column(name="cCity", nullable = false, length= 50)
	String cCity;
	
	@Basic
	@Column(name="cState", nullable = false, length= 50)
	String cState;
	
	@Basic
	@Column(name="cZipCode", nullable = false, length= 50)
	String cZipCode;
	
	// Constructor
	public Customer(int cid, String cFname, String cLname, String cEmail, String cPassword, String cAddressLine1,
			String cAddressLine2, String cCity, String cState, String cZipCode) {
		super();
		this.cid = cid;
		this.cFname = cFname;
		this.cLname = cLname;
		this.cEmail = cEmail;
		this.cPassword = cPassword;
		this.cAddressLine1 = cAddressLine1;
		this.cAddressLine2 = cAddressLine2;
		this.cCity = cCity;
		this.cState = cState;
		this.cZipCode = cZipCode;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getcFname() {
		return cFname;
	}

	public void setcFname(String cFname) {
		this.cFname = cFname;
	}

	public String getcLname() {
		return cLname;
	}

	public void setcLname(String cLname) {
		this.cLname = cLname;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public String getcAddressLine1() {
		return cAddressLine1;
	}

	public void setcAddressLine1(String cAddressLine1) {
		this.cAddressLine1 = cAddressLine1;
	}

	public String getcAddressLine2() {
		return cAddressLine2;
	}

	public void setcAddressLine2(String cAddressLine2) {
		this.cAddressLine2 = cAddressLine2;
	}

	public String getcCity() {
		return cCity;
	}

	public void setcCity(String cCity) {
		this.cCity = cCity;
	}

	public String getcState() {
		return cState;
	}

	public void setcState(String cState) {
		this.cState = cState;
	}

	public String getcZipCode() {
		return cZipCode;
	}

	public void setcZipCode(String cZipCode) {
		this.cZipCode = cZipCode;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cFname=" + cFname + ", cLname=" + cLname + ", cEmail=" + cEmail
				+ ", cPassword=" + cPassword + ", cAddressLine1=" + cAddressLine1 + ", cAddressLine2=" + cAddressLine2
				+ ", cCity=" + cCity + ", cState=" + cState + ", cZipCode=" + cZipCode + "]";
	}


	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
