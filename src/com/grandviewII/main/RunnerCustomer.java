package com.grandviewII.main;

import com.grandviewII.services.CustomerServices;
import com.grandviewII.entities.Customer;


public class RunnerCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer cust1 = new Customer
			( 1,"Nancy",  "Boyd","nancy@gmail.comm", "psw"," 3 Willis ST.","Apt 5", "Saugus", "LA", "01906");
		Customer cust2 = new Customer
			( 2,"Mick",  "Jagger","mick@gmail.com", "mick"," address line 1","address line 2", "city", "State", "01906");

		createNewCustomer(cust1);
		createNewCustomer(cust2);
		
		//to update or delete , make a new object, set the ID you want to find,
		//set the attributes you want to change. call the Method
		
		Customer custA = new Customer();
		custA.setcEmail("mick@gmail.com");
		custA.setcFname("BETTY");
		custA.setcLname("WASHINGTON");
		custA.setcAddressLine1("10 main St.");
		custA.setcAddressLine2(null);
		updateCustomer(custA);
		
	}
	
	private static void updateCustomer(Customer cust) {
		CustomerServices custServices = new CustomerServices();
		boolean result = false;
	    Customer foundCustomer = custServices.findCustomer(cust);

	    //	only the fields that were set in the dummy customer, will be set in the foundCustomer else
	    // leave then as is
	    if (foundCustomer !=null) {
	    	if(cust.getcFname() != null)
	    		foundCustomer.setcFname(cust.getcFname());
	     	if(cust.getcLname() != null)
	    		foundCustomer.setcLname(cust.getcLname());
	    	if (cust.getcAddressLine1() != null) 
	    		foundCustomer.setcAddressLine1(cust.getcAddressLine1());
	    	foundCustomer.setcAddressLine2(cust.getcAddressLine2());
	    	if (cust.getcCity() != null)
	    		foundCustomer.setcCity(cust.getcCity());
	    	if (cust.getcState() != null)
	    		foundCustomer.setcState(cust.getcState());
	    	
	    	if (cust.getcZipCode() != null)
	    		foundCustomer.setcZipCode(cust.getcZipCode());
	    	
	    	result = custServices.updateCustomer(foundCustomer);
	    	}

	    if (result) {
	    		System.out.println("Customer updated , cust email  : " + foundCustomer.getcEmail() + "," + foundCustomer.getcLname());
	    } else {
	    		System.out.println("cust NOT updated, cust email : "  +   foundCustomer.getcEmail() + "," + foundCustomer.getcLname());
	    } 	 
		
	}

	private static void createNewCustomer(Customer customer) {
		CustomerServices custServ = new CustomerServices();
		
		boolean result = custServ.insertCustomer(customer);
		
		if(result) {
			System.out.println("Custumer inserted, Email ID:" + customer.getcEmail());
		} else {
			System.out.println("Customer NOT inserted, Email ID: " + customer.getcEmail());
		}
	}
	
   
//	private static void removeCustomer(Customer cust) {
//		CustomerServices custservices = new CustomerServices();
//		boolean result = false;
//		Customer foundCustomer= CustomerServices.findCustomer(cust); 
//	    if (foundCustomer !=null) {
//	    	System.out.println(foundCustomer.toString());
//	    	result = custservices.removeCustomer(foundCustomer);
//	    }
//	    if (result) {
//	    	System.out.println("Dept deleted, Dept id :" + foundDepartment.getDid());
//	    } else {
//	    	System.out.println("Dept NOT deleted, Dept id :" + foundDepartment.getDid());
//	    }
	
	
	
	
	
	
}

