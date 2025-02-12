package poly.edu.controller.Lab5;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import poly.edu.Entity.Lab5.Item;
@SessionScope
@Service

public class ShoppingCartServiceImpl implements ShoppingCartService {
	static Map<Integer,Item> list=DB.getAll();
	public static Map<Integer, Item> map= new HashMap<>();
	double amount=0;
	@Override
	public Item add(int id) {
		 if (!list.containsKey(id)) {
		        return null; 
		    }
		    Item item = list.get(id);
		    if (map.containsKey(id)) {
		        map.get(id).setQty(map.get(id).getQty()+1);; 
		    } else {
		        item.setQty(1); 
		        map.put(id, item);
		    }

		    return map.get(id);
	}

	@Override
	public void remove(int id) {
			 map.remove(id);
	}

	@Override
	public Item update(int id, int qty) {
	    if (map.containsKey(id)) {
	        map.get(id).setQty(qty);
	    }
	    return map.get(id);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Collection<Item> getItems() {
		return map.values();
	}

	@Override
	public int getCount() {
		return map.size();
	}

	@Override
	public double getAmount() {
		map.forEach((id,item)->amount=amount+item.getQty()*item.getPrice());
		return amount;
	}

}
