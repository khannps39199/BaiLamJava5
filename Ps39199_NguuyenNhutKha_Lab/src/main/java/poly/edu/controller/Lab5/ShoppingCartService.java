package poly.edu.controller.Lab5;

import java.util.Collection;

import poly.edu.Entity.Lab5.Item;

public interface ShoppingCartService {
	
	Item add(int id);
	void remove(int id);
	Item update(int id, int qty);
	void clear();
	Collection<Item> getItems();
	int getCount();
	double getAmount();
}
