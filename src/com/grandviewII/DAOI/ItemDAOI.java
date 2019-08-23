package com.grandviewII.DAOI;

import java.util.List;

import com.grandviewII.entities.Item;

public interface ItemDAOI {
	boolean insertItem(Item item);
	boolean updateItem(Item item);
	boolean deleteItem(Item item);
	Item findItem(Item item);
	List<Item> getAllItems();
}
