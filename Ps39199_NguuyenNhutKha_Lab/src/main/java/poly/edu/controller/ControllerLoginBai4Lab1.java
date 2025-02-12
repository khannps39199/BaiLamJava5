package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class ControllerLoginBai4Lab1 {
	@Autowired
	HttpServletRequest req;
	@GetMapping("/login/form")
	public String getLogin(Model loginRequestMessage) {
		return "/Bai4Lab1/Login.html";
	}
	@PostMapping("/login/check")
	public String postMethodName(Model loginRequestMessage) {
		String username=req.getParameter("username");
		String pass=req.getParameter("password");
		if(username.equals("poly") && pass.equals("123")) {
			loginRequestMessage.addAttribute("mess", "dang nhap thanh cong");
		}else {
			loginRequestMessage.addAttribute("mess", "dang nhap khong thanh cong");			
		}
		return "/Bai4Lab1/Login.html";
	}
	
}	
