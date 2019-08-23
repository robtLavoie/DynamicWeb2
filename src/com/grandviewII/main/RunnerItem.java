package com.grandviewII.main;

import com.grandviewII.entities.Item;
import com.grandviewII.services.ItemServices;
// be sure to run as a java application
public class RunnerItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// test data
		Item item1 = new Item(1, "Scooter", "Electric Scooter", 399.88, 99.00, "image Here");
		Item item2 = new Item(2, "Water Bottle", "holds liquid", 8.99, 5.99, "image Here");
		Item item3 = new Item(3, "Laser Gun", "used in Laser Tag", 0, 0, "image Here");	
		Item item4 = new Item(4, "Golf Clubs", "9 irons, a driver, a Wood , and a putter", 120.99, 50.00, "image Here");
		Item item5 = new Item(5, "Jet Pack", "fly you to work", 1000.99, 500.50, "image Here");
		
		createNewItem(item1);
		createNewItem(item2);
		createNewItem(item3);
		createNewItem(item4);
		createNewItem(item5);
		
		// test update
		Item itemB = new Item();
		itemB.setId(2);
		itemB.setiName("JUICE BOTTLE");
		updateItem(itemB);
		
		// test delete
		Item itemA = new Item();
		itemA.setId(4);
		deleteItem(itemA);

		
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


