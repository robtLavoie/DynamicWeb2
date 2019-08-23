package com.grandviewII.services;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.dynamicweb2.controller.IndexController;
import com.grandviewII.DAOI.OrderDAOI;
import com.grandviewII.entities.Item;
import com.grandviewII.entities.Orders;


public class OrderServices implements OrderDAOI{

	
//**************************************************************************
//**************************************************************************

	//**************************************************************************
	public Orders findOrderObjectByID(String custID) {
		boolean result = false;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dynamicweb2");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

			String text = "SELECT e FROM Orders e WHERE e.custID = :custID";
			//+custID+"'"
			Query query = entityManager.createQuery(text);
			query.setParameter("custID", custID);

			List<Orders> OrdersFound = new ArrayList<Orders>();
			OrdersFound = query.getResultList();

			System.out.println(OrdersFound.size());
		

			entityManager.close();
			entityManagerFactory.close();

			
		return OrdersFound.get(OrdersFound.size()-1);
		
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
		if (li==null) {
			System.out.println("LI IS NULL");
		} else {
			System.out.println("LI NOT NULL");
		}
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
	//**************************************************************************
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
				System.out.println("HEREEEEEE");
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dynamicweb2");
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				
				///// HERE HERE
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
 
//							 
//					 

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

	

