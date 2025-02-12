package poly.edu.Entity.Lab5;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	int id;
	String name;
	double price;
	int qty = 1;
}
