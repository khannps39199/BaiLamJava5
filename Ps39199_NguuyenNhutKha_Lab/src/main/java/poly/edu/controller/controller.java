package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class controller {
	@RequestMapping("/poly/hello")
	public String sayHello(Model model) {
		model.addAttribute("title", "FPT");
		model.addAttribute("subject", "NGUYEN NHUT KHA");
		return "hello.html";
	}
	
}
