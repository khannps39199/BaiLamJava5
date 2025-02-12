package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class ControllerLoginBai5Lab1 {
	@Autowired
	HttpServletRequest req;
	@GetMapping("/chuvi/form")
	public String getLogin(Model loginRequestMessage) {
		return "/Bai4Lab1/TinhChuViChuNhat.html";
	}
	@PostMapping("/chuvi/tinh")
	public String postMethodName(Model calRequestMessage) {
		Double chieurong=Double.parseDouble(req.getParameter("chieurong")) ;
		Double chieudai=Double.parseDouble(req.getParameter("chieudai")) ;
		calRequestMessage.addAttribute("mess", 2*(chieudai+chieurong));		
		return "/Bai4Lab1/TinhChuViChuNhat.html";
	}
}
