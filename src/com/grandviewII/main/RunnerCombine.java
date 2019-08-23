package com.grandviewII.main;

import java.util.ArrayList;
import java.util.List;

import com.grandviewII.entities.Customer;
import com.grandviewII.entities.Item;
import com.grandviewII.entities.Orders;
import com.grandviewII.services.CustomerServices;
import com.grandviewII.services.ItemServices;
import com.grandviewII.services.OrderServices;

public class RunnerCombine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer cust1 = new Customer
				( 1,"Nancy",  "Boyd","nancy@gmail.com", "psw"," 3 Willis ST.","Apt 5", "Saugus", "LA", "01906");
		Customer cust2 = new Customer
				( 2,"Mick",  "Jagger","mick@gmail.com", "mick"," address line 1","address line 2", "city", "State", "01906");

		createNewCustomer(cust1);
		createNewCustomer(cust2);
		// test data
		Item item1 = new Item(1, "Scooter", "Electric Scooter", 399.88, 99.00, "image Here");
		Item item2 = new Item(2, "Water Bottle", "holds liquid", 8.99, 5.99, "image Here");
		Item item3 = new Item(3, "Laser Gun", "used in Laser Tag", 10.00, 0, "image Here");	
		Item item4 = new Item(4, "Golf Clubs", "9 irons, a driver, a Wood , and a putter", 120.99, 50.00, "image Here");
		Item item5 = new Item(5, "Jet Pack", "fly you to work", 1000.99, 500.50, "image Here");

		createNewItem(item1);
		createNewItem(item2);
		createNewItem(item3);
		createNewItem(item4);
		createNewItem(item5);

		List<Item> orderItemList1 = new ArrayList<>();
		orderItemList1.add(item1);
		orderItemList1.add(item2);

		List<Item> orderItemList2 = new ArrayList<>();
		orderItemList2.add(item3);

		List<Item> orderItemList3 = new ArrayList<>();
		orderItemList3.add(item1);
		orderItemList3.add(item4);
		orderItemList3.add(item5);
		List<Item> orderItemList4 = new ArrayList<>();
		orderItemList4.add(item1);
		orderItemList4.add(item3);
		orderItemList4.add(item4);
		orderItemList4.add(item5);


		Orders orderB = new Orders(1, "mick@gmail.com", 20.00, 0, orderItemList1 );
		Orders orderC = new Orders(2, "nancy@gmail.com", 10.00, 0, orderItemList2 );
		Orders orderD = new Orders(3,	"billy@gmail.com", 15.00, 0, orderItemList3 );
		Orders orderE = new Orders(4, "ozzy@gmail.com", 10.00, 0, orderItemList4 );

		createNewOrder(orderB);
		createNewOrder(orderC);
		createNewOrder(orderD);
		createNewOrder(orderE);

		// customer 

		//to update or delete , make a new object, set the ID you want to find,
		//set the attributes you want to change. call the Method

		Customer custA = new Customer();
		custA.setcEmail("mick@gmail.com");
		custA.setcFname("BETTY");
		custA.setcLname("WASHINGTON");
		custA.setcAddressLine1("10 main St.");
		custA.setcAddressLine2(null);
		updateCustomer(custA);

		// Item
		// test update
		Item itemB = new Item();
		itemB.setId(2);
		itemB.setiName("JUICE BOTTLE");
		updateItem(itemB);

		// test update 
		Item itemC = new Item();
		itemC.setId(3);
		itemC.setiPrice(14.95);
		itemC.setiSalePrice(2.00);
		updateItem(itemC);

		// test delete
		Item itemA = new Item();
		itemA.setId(4);
		deleteItem(itemA);
	}

	// End of Main
	private static void createNewOrder(Orders order) {
		OrderServices orderServ = new OrderServices();
		//boolean result = orderServ.insertOrder(order);
		Orders newOrder = new Orders();   ////
		//newOrder.setCustID(custID);
		boolean result = orderServ.insertOrder(order);
		if(result) {
			System.out.println("Order inserted, order ID:" + order.getOid());
		} else {
			System.out.println("Order NOT inserted, order ID: " + order.getOid());
		}
	}

	private static void updateOrder(Orders order) {
		OrderServices orderServices = new OrderServices();
		boolean result = false;
		Orders foundOrder = orderServices.findOrder(order);

		//	only the fields that were set in the dummy customer, will be set in the foundCustomer else
		// leave then as is
		if (foundOrder !=null) {
			if(order.getCustID() != null)
				foundOrder.setCustID(order.getCustID());
			//	     	if(order.getOdate() != null)
			//	    		foundOrder.setOdate(order.getOdate());
			if (order.getoSandH() != 0) 
				foundOrder.setoTotal(order.getoTotal());
			if(order.getListItems() != null) // ????
				foundOrder.setListItems(order.getListItems());

			result = orderServices.updateOrder(foundOrder);
		}

		if (result) {
			System.out.println("Order updated , order id  : " + foundOrder.getOid());
		} else {
			System.out.println("Order NOT updated, order id : "  + + foundOrder.getOid());
		} 	 

	}
	private static void deleteOrder(Orders order) {
		OrderServices orderServices = new OrderServices();
		boolean result = false;
		Orders foundOrder = orderServices.findOrder(order);
		if (foundOrder !=null) {
			System.out.println(foundOrder.toString());
			result = orderServices.deleteOrder(foundOrder);
		}
		if (result) {
			System.out.println("Order deleted, order id :" + foundOrder.getOid());
		} else {
			System.out.println("Order not Found" + foundOrder.getOid());
		}
	}

	// Customer
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


	private static void deleteCustomer(Customer cust) {
		CustomerServices custservices = new CustomerServices();
		boolean result = false;
		Customer foundCustomer = custservices.findCustomer(cust);
		if (foundCustomer !=null) {
			System.out.println(foundCustomer.toString());
			result = custservices.deleteCustomer(foundCustomer);
		}
		if (result) {
			System.out.println("Customer deleted, customer id :" + foundCustomer.getCid());
		} else {

		}
	}
	private static void createNewItem(Item item) {
		ItemServices itemServices = new ItemServices();

		boolean result = itemServices.insertItem(item);

		if(result) {
			System.out.println("Item inserted, Item ID:" + item.getId() + "," + item.getiName());
		} else {
			System.out.println("Itemk NOT inserted, Item ID: " + item.getId() + "," + item.getiName());
		}
	}

	private static void updateItem(Item item) {
		ItemServices itemServices = new ItemServices();
		boolean result = false;
		Item foundItem = itemServices.findItem(item);

		//	only the fields that were set in the dummy customer, will be set in the foundCustomer else
		// leave then as is
		if (foundItem !=null) {
			if(item.getiName() != null)
				foundItem.setiName(item.getiName());
			if (item.getiDescription() != null)
				foundItem.setiDescription(item.getiDescription());
			if (item.getiPicture() != null)
				foundItem.setiPicture(item.getiPicture());
			if (item.getiPrice() != 0)
				foundItem.setiPrice(item.getiPrice());
			if (item.getiSalePrice() != 0)
				foundItem.setiSalePrice(item.getiSalePrice());

			result = itemServices.updateItem(foundItem);
		}

		if (result) {
			System.out.println("Item updated , Item ID  : " + foundItem.getId() + "," + foundItem.getiName());
		} else {
			System.out.println("Item NOT updated, Item ID : "  +    + foundItem.getId() + "," + foundItem.getiName());
		} 	
	}   

	private static void deleteItem(Item item) {
		ItemServices itemServices = new ItemServices();
		boolean result = false;
		Item foundItem = itemServices.findItem(item);
		if (foundItem !=null) {
			System.out.println(foundItem.toString());
			result = itemServices.deleteItem(foundItem); 
		}
		if (result) {
			System.out.println("Item deleted, Item id :" + foundItem.getId() + "," + foundItem.getiName());
		} else {
			System.out.println("Item NOT deleted, Item id :" + item.getId() + "," + item.getiName());
		}
	}

}
