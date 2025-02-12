package poly.edu.controller.Lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.Entity.Lab2.Product;

@Controller
public class ProductControllerBai3 {
	@GetMapping("/product/form")
	public String form() {
	return "Lab2/ProductSaveForm";
	}
	@PostMapping("/product/save")
	public String save(@ModelAttribute Product product, Model model) {
		model.addAttribute("name", product.getName());
        model.addAttribute("price", product.getPrice());
    	return "Lab2/ProductSaveForm";
	}


}
