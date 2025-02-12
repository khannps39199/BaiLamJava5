package poly.edu.controller.Lab5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ItemController {
	@GetMapping("/item/index")
	public String list(Model model) {
		 model.addAttribute("items", DB.getAll());
		 return "Lab5/item/view";
	}
	
}
