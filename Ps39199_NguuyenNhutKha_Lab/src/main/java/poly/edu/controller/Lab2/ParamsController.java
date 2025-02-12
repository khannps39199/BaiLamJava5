package poly.edu.controller.Lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ParamsController {
	 @Autowired
	    HttpServletRequest req;
	 @RequestMapping("/param/form")
		 public String form() {
		 return "Lab2/ParamsForm";
	 }

	 @PostMapping(value="/param/save/{param}")
	 public String requestMethodName( @PathVariable("param") String param,
	 @RequestParam("y" )String y) {
			req.setAttribute("x", param);
			req.setAttribute("y", y);
			 return "Lab2/ParamsForm";
	 }
	
}
