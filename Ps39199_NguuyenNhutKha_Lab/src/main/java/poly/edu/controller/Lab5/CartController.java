package poly.edu.controller.Lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.Entity.Lab5.Item;

@Controller
public class CartController {
	@Autowired
	ShoppingCartServiceImpl shopServiceImpl;
	@Autowired
	ParamService paramService;
	@GetMapping("/cart/add{id}")
	public String list(Model model) {
		
			shopServiceImpl.add(paramService.getInt("id",0));
			List<Item> cart= new ArrayList<>(shopServiceImpl.getItems()) ;
			model.addAttribute("cart",cart);
			return "redirect:/cart/view";

	}
	@GetMapping("/cart/view")
	public String view(Model model) {
		List<Item> cart= new ArrayList<>(shopServiceImpl.getItems()) ;
//		System.out.println(cart.get(0).getId());
		model.addAttribute("cart",cart);
		return "Lab5/item/Cart";
	}
	@PostMapping("/cart/update{id}")
	public String update(Model model) {
		shopServiceImpl.update(paramService.getInt("id",0),paramService.getInt("qty",0));
		List<Item> cart= new ArrayList<>(shopServiceImpl.getItems()) ;
		model.addAttribute("cart",cart);
		return "redirect:/cart/view";
	}
	@GetMapping("/cart/remove{id}")
	public String delete(Model model) {
		shopServiceImpl.remove(paramService.getInt("id",0));
		System.out.println(paramService.getInt("id",0));
		List<Item> cart= new ArrayList<>(shopServiceImpl.getItems()) ;
		model.addAttribute("cart",cart);
		return "Lab5/item/Cart";
	}
	@GetMapping("/cart/clear")
	public String clear(Model model) {
		shopServiceImpl.clear();
		List<Item> cart= new ArrayList<>(shopServiceImpl.getItems()) ;
		model.addAttribute("cart",cart);
		return "redirect:/cart/view";
	}
}
