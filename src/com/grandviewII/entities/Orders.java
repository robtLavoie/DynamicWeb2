package com.grandviewII.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table@NamedQuery(query="SELECT e FROM Orders e", name="getAllOrders")
public class Orders {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int oid;
	
	//	@Basic
	//	@Column(name="oDate")
	//	Date odate;

	@Basic
	@Column(name="custId")
	String custID;

	@Basic
	@Column(name="oSandH")
	double oSandH;

	@Basic
	@Column(name="oTotal", nullable=false)	
	double oTotal ;


	@OneToMany
	private List<Item> listItems = new ArrayList<>();


	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	//	public Date getOdate() {
	//		return odate;
	//	}
	//
	//
	//	public void setOdate(Date odate) {
	//		this.odate = odate;
	//	}


	public String getCustID() {
		return custID;
	}


	public void setCustID(String custID) {
		this.custID = custID;
	}


	public double getoSandH() {
		return oSandH;
	}


	public void setoSandH(double oSandH) {
		this.oSandH = oSandH;
	}


	public double getoTotal() {
		return oTotal;
	}


	public void setoTotal(double oTotal) {
		this.oTotal = oTotal;
	}


	public List<Item> getListItems() {
		return listItems;
	}


	public void setListItems(List<Item> listItems) {
		this.listItems = listItems;
	}


	public Orders(int oid, String custID, double oSandH, double oTotal, List<Item> listItems) {

		super();
		this.oid = oid;
		this.custID = custID;
		this.oSandH = oSandH;
		this.oTotal = oTotal;
		this.listItems = listItems;
	}


	@Override
	public String toString() {
		return "Orders [oid=" + oid + ",  custID=" + custID + ", oSandH=" + oSandH + ", oTotal="
				+ oTotal + ", listItems=" + listItems + "]";
	}


	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}






































}
