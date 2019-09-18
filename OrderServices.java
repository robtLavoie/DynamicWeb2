package com.grandviewII.services;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.grandviewII.DAOI.OrderDAOI;
import com.grandviewII.controller.IndexController;
import com.grandviewII.entities.Item;
import com.grandviewII.entities.Orders;


public class OrderServices implements OrderDAOI{


	public boolean findOrderObjectByID(String custID) {
		boolean result = false;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("SELECT e FROM Orders e WHERE e.custID.cEmail='"+custID+"'");
		List<Orders> orderFoundList = new ArrayList();
		orderFoundList =  query.getResultList();
		
		if(orderFoundList.isEmpty()){ // means ,no order found with custID in  order
			result = false;
		}else {	
			//  Get from list orders  with customer id, the last order and moves it to a global variable
			IndexController.SingleOrder = orderFoundList.get(0); //get last customer order
			result=true;
		}	
			
		return result;
	}
	
	
	@SuppressWarnings("unused")
	public boolean createOrder(String custID) {
		boolean result = false;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		Orders order = new Orders();
		order.setCustID(custID);
		order.setoTotal(0);
//		order.setOid(1); // generate the orderNumber or ID
		List<Item> li = new ArrayList<>();

		order.setListItems(li);

		IndexController.SingleOrder = order;

		try {
			entitymanager.getTransaction().begin();		
			entitymanager.persist(order);
			entitymanager.getTransaction().commit();
			result = true;
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
			
	public boolean sendItemToOrder (int itemID, Orders order) {
		
		boolean result = false;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();	
		try {
			Orders orderFound = order;
			orderFound.getListItems().add(entitymanager.find(Item.class, itemID));
			entitymanager.getTransaction().begin();
			entitymanager.persist(orderFound);
			entitymanager.getTransaction().commit();
			result = true;
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

	//**************************************************************************
			@Override
			public boolean insertOrder(Orders orders) {
				boolean result = true;
				EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
				EntityManager entitymanager = entitymanagerfactory.createEntityManager();
				System.out.println(entitymanager.toString()); //test
				System.out.println(entitymanager.getTransaction().toString()); //test
				System.out.println(orders.toString()); //test
				try {
					entitymanager.getTransaction().begin();
					entitymanager.persist(orders);
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
			public Orders findOrder(Orders orders) {
				// Find th Order
				Orders orderFound = null;
				
				EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
				EntityManager entitymanager = entitymanagerfactory.createEntityManager();
				try {
					orderFound = entitymanager.find(Orders.class, orders.getOid());
				} catch(PersistenceException e) {
					e.getMessage();
				}
				finally {
					entitymanager.close();
					entitymanagerfactory.close();
				}
				return orderFound;
			}

			@Override
			public boolean updateOrder(Orders orders) {
				boolean result = true;
				EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
				EntityManager entitymanager = entitymanagerfactory.createEntityManager();
				try {
				//update the orders Table with any change to the order object
					entitymanager.getTransaction().begin();
					Orders orderFound = entitymanager.find(Orders.class, orders.getOid());
					orderFound.setoSandH(orders.getoSandH());
					orderFound.setoTotal(orders.getoTotal());
					orderFound.setCustID(orders.getCustID());
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
			public boolean deleteOrder(Orders orders) {
				//find the order and delete it
				boolean result = true;
				EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
				EntityManager entitymanager = entitymanagerfactory.createEntityManager();
				try {
					entitymanager.getTransaction().begin();
					Orders orderFound = entitymanager.find(Orders.class, orders.getOid());
					entitymanager.remove(orderFound);
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
			@SuppressWarnings("unchecked")
			@Override
			public List<Orders> getAllOrders() {
				// show all orders in Table
				List<Orders> orderList = new ArrayList<>();
				EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("dynamicweb2");
				EntityManager entitymanager = entitymanagerfactory.createEntityManager();
				Query query = entitymanager.createQuery("SELECT e FROM Orders e");
				orderList = query.getResultList();
				entitymanager.close();
				entitymanagerfactory.close();
				
				return orderList ;
			}

			@Override
			public Orders getOrderById(Orders orders) {
			//	List<Orders> orderList = new ArrayList<>();
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dynamicweb2");
				EntityManager entityManager = entityManagerFactory.createEntityManager();

				Orders orderFound = entityManager.find(Orders.class, orders.getOid());
				
				entityManager.close();
				entityManagerFactory.close();
				
				return orderFound;
			}

			public boolean addItemsToOrder(int oId, int iId){
				boolean result = true;
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dynamicweb2");
				EntityManager entityManager = entityManagerFactory.createEntityManager();

				try {
					 Orders orderFound = entityManager.find(Orders.class, oId);
					 if (orderFound != null) {
						 	System.out.println("order not null GO");
							System.out.println("ADDING ITEM TO THE ORDER LIST ");
	 						entityManager.getTransaction().begin();
	 						Item item = entityManager.find(Item.class, iId);
	 						List<Item> listItems = orderFound.getListItems();
	 						listItems.add(item);
	 						orderFound.setListItems(listItems);
	 						entityManager.getTransaction().commit();	
					 }
				} catch(PersistenceException e) {
					e.getMessage();
					result = false;
				}
				finally {
					entityManager.close();
					entityManagerFactory.close();
				}
				return result;	
			}
			
			public List<Item> getOrderItems(String custid){
				// find the order and get the list of items ordered.
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dynamicweb2");
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				Orders orderFound = entityManager.find(Orders.class, custid);
				entityManager.close();
				entityManagerFactory.close();
				return orderFound.getListItems();
				
			}

			@Override
			public boolean validateOrder(Orders order) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Item> getOrderItems(int oId) {
				// TODO Auto-generated method stub
				return null;
			}
	}
