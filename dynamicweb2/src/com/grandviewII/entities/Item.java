package com.grandviewII.entities;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table
@NamedQuery(query="SELECT e FROM Item e", name="getAllItems")

public class Item {

	@Id
	int id;
	
	@Basic
	@Column(name="iName", nullable= false, length=50)
	String iName;
	
	@Basic
	@Column(name="iDescription", nullable= false, length=100)
	String iDescription;
	
	@Basic
	@Column(name="iPrice", nullable=false)	
	double iPrice ;
	
	@Basic
	@Column(name=" iSalePrice") 	
	double iSalePrice ;	

	@Basic
	@Column(name="iPicture", nullable= false, length=50)
	String iPicture;

// constructors
	public Item(int id, String iName, String iDescription, double iPrice, double iSalePrice, String iPicture) {
		super();
		this.id = id;
		this.iName = iName;
		this.iDescription = iDescription;
		this.iPrice = iPrice;
		this.iSalePrice = iSalePrice;
		this.iPicture = iPicture;
	}
	public Item() {};

	
	// getter and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public String getiDescription() {
		return iDescription;
	}

	public void setiDescription(String iDescription) {
		this.iDescription = iDescription;
	}

	public double getiPrice() {
		return iPrice;
	}

	public void setiPrice(double iPrice) {
		this.iPrice = iPrice;
	}

	public double getiSalePrice() {
		return iSalePrice;
	}

	public void setiSalePrice(double iSalePrice) {
		this.iSalePrice = iSalePrice;
	}

	public String getiPicture() {
		return iPicture;
	}

	public void setiPicture(String iPicture) {
		this.iPicture = iPicture;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", iName=" + iName + ", iDescription=" + iDescription + ", iPrice=" + iPrice
				+ ", iSalePrice=" + iSalePrice + ", iPicture=" + iPicture + "]";
	}
	
	
}
