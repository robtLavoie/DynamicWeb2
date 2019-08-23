package com.grandviewII.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.grandviewII.DAOI.CustomerDAOI;
import com.grandviewII.entities.Customer;
//import com.sc.entities.Student;





public class CustomerServices implements CustomerDAOI  {
	
	
	
	@Override
	public boolean insertCustomer(Customer customer) {
			boolean result = true;
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			try {
				entitymanager.getTransaction().begin();
				entitymanager.persist(customer);
				entitymanager.getTransaction().commit();
			} catch(PersistenceException e) {
				e.getMessage();
				result = false;
			}
			finally {
				entitymanager.close();
				entitymanagerfactory.close();
			}
			return result;
		}


	// update through find
	@Override
	public boolean updateCustomer(Customer cust){
		boolean result = true;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
	
		try {
			Customer foundCustomer = entitymanager.find(Customer.class, cust.getcEmail());
			entitymanager.getTransaction().begin();
			// set attributes for update
			foundCustomer.setcFname(cust.getcFname());
			foundCustomer.setcLname(cust.getcLname());
			foundCustomer.setcAddressLine1(cust.getcAddressLine1());
			foundCustomer.setcAddressLine2(cust.getcAddressLine2());
			foundCustomer.setcCity(cust.getcCity());
			foundCustomer.setcState(cust.getcState());
			foundCustomer.setcZipCode(cust.getcZipCode());
			entitymanager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.getMessage();
			result = false;
		}
		finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
	
		return result;
	}
	@Override
	public boolean deleteCustomer(Customer cust) {
		boolean result = true;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {
			Customer foundCustomer = entitymanager.find(Customer.class, cust.getcEmail());
			entitymanager.getTransaction().begin();
			entitymanager.remove(foundCustomer);
			entitymanager.getTransaction().commit();
		} catch(PersistenceException e) {
			e.getMessage();
			result = false;
		}
		finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
		return result;
	}
//

	
//	
	public Customer findCustomer(Customer cust) {
		Customer foundCustomer = null; 

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		
		try {
			foundCustomer = entitymanager.find(Customer.class, cust.getcEmail());
		}
		 catch (PersistenceException e) {
			 e.getMessage();
		 }
		finally {	 
			entitymanager.close();
			entitymanagerfactory.close();
		}

		return foundCustomer;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("getAllCustomers");
			customerList = query.getResultList();

		} catch (PersistenceException e) {
			e.printStackTrace();

		}
		return customerList;
	}

//	public boolean validateCustomer(Customer customer) {
		
		public boolean validateCustomer(String email, String password){
			boolean result = false;
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dynamicweb2");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
				Customer customerFound = entityManager.find(Customer.class, email);
				if (customerFound != null) {
					if (customerFound.getcPassword().equals(password) == true) {
     					result = true;
					}
				}	 
				entityManager.close();
				entityManagerFactory.close();

			return result;
	}


@Override
public boolean validateCustomer(Customer customer) {
	// TODO Auto-generated method stub
	return false;
}
	
	
}
