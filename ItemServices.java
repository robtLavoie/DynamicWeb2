package com.grandviewII.services;


import com.grandviewII.DAOI.ItemDAOI;
import com.grandviewII.entities.Customer;
import com.grandviewII.entities.Item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class ItemServices implements ItemDAOI {

	@Override
	public boolean insertItem(Item item) {
		// TODO Auto-generated method stub
		
		boolean result = true;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {
			entitymanager.getTransaction().begin();
			entitymanager.persist(item);
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

	@Override
	public boolean updateItem(Item item) {
		boolean result = true;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
	
		try {
			Item foundItem = entitymanager.find(Item.class, item.getId());
			entitymanager.getTransaction().begin();
			// set attributes for update
			foundItem.setiName(item.getiName());
			foundItem.setiDescription(item.getiDescription());
			foundItem.setiPicture(item.getiPicture());
			foundItem.setiPrice(item.getiPrice());
			foundItem.setiSalePrice(item.getiSalePrice());
			
			
			entitymanager.getTransaction().commit()
			;
			
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
	public boolean deleteItem(Item item) {
		boolean result = true;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {
			Item foundItem = entitymanager.find(Item.class, item.getId());
			entitymanager.getTransaction().begin();
			entitymanager.remove(foundItem);
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

	@Override
	public Item findItem(Item item) {

			Item foundItem = null; 

			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			
			try {
				foundItem = entitymanager.find(Item.class, item.getId());
			}
			 catch (PersistenceException e) {
				 e.getMessage();
			 }
			finally {	 
				entitymanager.close();
				entitymanagerfactory.close();
			}

			return foundItem;
		
		}
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItems() {
		List<Item> itemList = new ArrayList<>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("getAllItems");
			itemList = query.getResultList();

		} catch (PersistenceException e) {
			e.printStackTrace();

		}
		return itemList;
	}	
	
	
	
	}


