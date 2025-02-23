package poly.edu.Entity.Lab2;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Product {
	String name;
	Double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
//	public Product(String name, Double price) {
//		super();
//		this.name = name;
//		this.price = price;
//	}
	
}
