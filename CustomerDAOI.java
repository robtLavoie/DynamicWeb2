package com.grandviewII.DAOI;



import java.util.List;

import com.grandviewII.entities.Customer;

public interface CustomerDAOI {
	boolean insertCustomer(Customer customer);


	boolean updateCustomer(Customer foundCustomer);
	boolean deleteCustomer(Customer foundCustomer);
	Customer findCustomer(Customer customer);

	boolean validateCustomer(Customer customer);


	List<Customer> getAllCustomers();

}
