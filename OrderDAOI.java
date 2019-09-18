package com.grandviewII.DAOI;

import java.util.List;


import com.grandviewII.entities.Item;
import com.grandviewII.entities.Orders;


public interface OrderDAOI {
	boolean insertOrder(Orders customer);
	boolean updateOrder(Orders foundOrder);
	boolean deleteOrder(Orders foundOrder);
	Orders findOrder(Orders order);
	boolean validateOrder(Orders order);
	boolean addItemsToOrder(int oId, int iId);

	List<Item> getOrderItems(int oId);
	List<Orders> getAllOrders();
	Orders getOrderById(Orders order);
}
