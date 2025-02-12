package poly.edu.controller.Lab2;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.Entity.Lab2.Product;

@Controller
public class ProductControllerBai4 {
	@GetMapping("/product4/form")
	public String form() {
	return "Lab2/ProductSaveForm";
	}
	final List<Product> listPro=new ArrayList<>();
	@PostMapping("/product4/save")
	public String save(@ModelAttribute Product product, Model model) {
		listPro.add(product);
		Arrays.asList((new Product("a",1.22)),new Product("b",1.1));
//		;
;		model.addAttribute("listProduct", listPro);
    	return "Lab2/ProductSaveForm";
	}


}
