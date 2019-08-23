package com.dynamicweb2.controller;

import java.io.OutputStream; // create comma delimited file later
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

//import org.apache.catalina.servlets.DefaultServlet.SortManager.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.grandviewII.entities.Customer;
import com.grandviewII.entities.Item;
import com.grandviewII.entities.Orders;
import com.grandviewII.services.CustomerServices;
import com.grandviewII.services.ItemServices;
import com.grandviewII.services.OrderServices;

@Controller
@SessionAttributes(value= {"sCustomer","sCartList", "sOrder"})
public class IndexController {
 
	public static Orders SingleOrder = new Orders();
	
	@ModelAttribute("sCustomer")
	public Customer setUpsCustomer()
	{
		return new Customer();
	}
	@ModelAttribute("sCartList")
	public List<Item> setUpsCartList()
	{
		return new ArrayList<Item>();
	}
	@ModelAttribute("sOrder")
	public Orders setUpsOrder()
	{
		return null;
	}
	@RequestMapping("/")
	public ModelAndView index3() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/gologin")
	public ModelAndView showLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	@RequestMapping(value = "/login", method=RequestMethod.POST )
	public ModelAndView getLogin(@RequestParam("cEmail") String cEmail,
			@RequestParam("cPassword") String cPassword,
			@ModelAttribute("sCustomer") Customer sessionCustomer,
			@ModelAttribute("sCartList") List<Item> sessionCartList
			){		
		boolean  result = false;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		Customer  cust = new Customer();
			cust.setcEmail(cEmail);
			CustomerServices customerServices = new CustomerServices();	
			Customer foundCustomer = customerServices.findCustomer(cust);
		if (foundCustomer != null) {
			 result = customerServices.validateCustomer(cEmail, cPassword);
			 if (result) {
				Orders order = null;
				mav.addObject("sCustomer", foundCustomer); // creates session
				mav.addObject("sOrder", order);
				mav.setViewName("index");
				
				ItemServices itemServices = new ItemServices();
				List<Item> itemList = new ArrayList<>();
				itemList = itemServices.getAllItems();
				mav.addObject("itemList", itemList);
				

			}
				 
		mav.addObject("sCartList", sessionCartList);
	
		} 
		String messageResult =  result?"":"Invalid login";
		mav.addObject("messageResult", messageResult);
		
			return mav;	 
	}	

	// customers
	@RequestMapping("/customers")
	public ModelAndView showAllcustomers() {
		CustomerServices customerServices = new CustomerServices();
		List<Customer> customerList = new ArrayList<>();
		customerList = customerServices.getAllCustomers();
		ModelAndView mav = new ModelAndView("customers");
		mav.addObject("customerList", customerList);

		return mav;
	}

	@RequestMapping("/registerCustomer")
	public ModelAndView newCustomer() {
		return new ModelAndView("CustProfile01");
	}
	@RequestMapping(value="/addCustomer", method=RequestMethod.POST)
	public ModelAndView createCustomer(@ModelAttribute Customer customer) {
		// insert customer 
		CustomerServices customerServices = new CustomerServices();
		boolean result = customerServices.insertCustomer(customer);
		String messageResult =  result?"Customer saved":"Customer Not saved";
		ModelAndView mav = new ModelAndView("CustProfile01");
		mav.addObject("messageResult", messageResult);

		return mav;
	}
	// items
	@RequestMapping("/index")
	public ModelAndView showAllItmes() {
		ItemServices itemServices = new ItemServices();
		
		List<Item> itemList = new ArrayList<>();
		itemList = itemServices.getAllItems();
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("itemList", itemList);

		return mav;
	}
	@RequestMapping("/items")
	public ModelAndView showAllItmes2() {
		ItemServices itemServices = new ItemServices();
		
		List<Item> itemList = new ArrayList<>();
		itemList = itemServices.getAllItems();
		
		ModelAndView mav = new ModelAndView("items");
		mav.addObject("itemList", itemList);

		return mav;
	}
	@RequestMapping("/registerItem")
	public ModelAndView newItem() {
		return new ModelAndView("itemProfile");
	}
	@RequestMapping(value="/addItem", method=RequestMethod.POST)
	public ModelAndView createItem(@ModelAttribute Item item) {
		// insert item
		ItemServices itemServices = new ItemServices();
		boolean result = itemServices.insertItem(item);
		String messageResult =  result?"Item saved":"Item Not saved";
		ModelAndView mav = new ModelAndView("itemProfile");

		mav.addObject ("messageResult", messageResult);
		return mav;
	}
	@RequestMapping(value="/addOrder", method=RequestMethod.POST)
	public ModelAndView createOrder(@ModelAttribute Orders order) {
		// insert  
		OrderServices orderServices = new OrderServices();
		boolean result = orderServices.insertOrder(order);
		String messageResult =  result?"Order saved":"Order Not saved";
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("messageResult", messageResult);

		return mav;
	}
	
	
	// pass order id and item id to add item ********working here on it ********
	@RequestMapping("/additems1/{urlid}")
	public ModelAndView ItemToOrder(
	@PathVariable("urlid") int itemId,
	@ModelAttribute("sCustomer") Customer sCustomer, 
	@ModelAttribute("sOrder") Orders sOrder)
	{
		boolean result=true;
		OrderServices orderServices = new OrderServices();
		String custEmail = sCustomer.getcEmail();
		
		if (sOrder != null) { //order exist
			System.out.println("order exist [orderID,CustomerID]" + sOrder.getOid() +","+custEmail );
		} else {
			System.out.println("Create new order");
			result = orderServices.createOrder(custEmail);
			if (result) {  
				sOrder = new Orders();
				custEmail = sCustomer.getcEmail();
			    Orders foundOrder = orderServices.findOrderObjectByID(custEmail);
				//Orders foundOrder = new Orders();
			    //foundOrder.setOid(sOrder.getOid());
			    if (foundOrder == null)
			    	System.out.println("Order does not exist");

				sOrder.setOid(foundOrder.getOid()); // get the new orderID just recorded
				System.out.println("order created GET ORDER-ID");
			}
		}

//		addItemsToOrder
		result = orderServices.addItemsToOrder(sOrder.getOid(), itemId);
		
		String messageResult =  result?"item added to list saved":"item not added";
		System.out.println("XXXX message =" + messageResult);
		// change back to index. when working, but doesnt work with index. tried send to another page 
		// it still goes back to index with no css and link dont work 
		ModelAndView mav = new ModelAndView();

		mav.setViewName("redirect:/index");
		mav.addObject("sOrder", sOrder);
//		mav.addObject ("messageResult", messageResult);
		
		return mav;
	}

	@RequestMapping("/logout")
	public ModelAndView getAbout2() {
		return new ModelAndView("logout");
	}
	
	@RequestMapping("/about")
	public ModelAndView getAbout() {
		return new ModelAndView("about");
	}
	
	@RequestMapping("/cart")
	
	public ModelAndView getCart() {
	OrderServices orderServices = new OrderServices();
		
		List<Item> cartList = new ArrayList<>();
		cartList = orderServices.getOrderItems(25);
		
		
		ModelAndView mav = new ModelAndView("cart");
		mav.addObject("cartList", cartList);

		return mav;
	
	}

	@RequestMapping("/CustProfile01")
	public ModelAndView getCustProfile01() {
		return new ModelAndView("CustProfile01");
	}

	@RequestMapping("/itemProfile")
	public ModelAndView getItemProfile() {
		return new ModelAndView("itemProfile");
	}
	
	@RequestMapping("/credit")
	public ModelAndView getCredit() {
		return new ModelAndView("credit");
	}
	
}
	

