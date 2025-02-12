package demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class demoControll {
	 @RequestMapping(value = "/hello")
	    public String sayHello(Model model) {
	        model.addAttribute("title", "FPT");
	        model.addAttribute("subject", "Spring Boot MVC");
	        return "demo/hello"; // Correct Thymeleaf template location
	    }
	
}
