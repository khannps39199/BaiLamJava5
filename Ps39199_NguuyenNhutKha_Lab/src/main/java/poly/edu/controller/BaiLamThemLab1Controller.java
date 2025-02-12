package poly.edu.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class BaiLamThemLab1Controller {
	@Autowired
	HttpServletRequest req;
	@GetMapping("/nhanvieninfo/forminfo")
	public String getLogin(Model loginRequestMessage) {
		return "/Bai4Lab1/BaiLamThemLab1.html";
	}
	@PostMapping("nhanvieninfo/info")
	public String postMethodName(Model infoRequestMessage) {

		String maNV=req.getParameter("manhanvien");
		String tenNV=req.getParameter("tennhanvien");
		String gioiTinh=req.getParameter("gioitinh");
		String namSinh=req.getParameter("namsinh");
		System.out.println(maNV+tenNV+gioiTinh+namSinh);
		LocalDate nam = LocalDate.now();
		infoRequestMessage.addAttribute("mess", maNV+"\n"+tenNV+"\n"+gioiTinh+"\n"+namSinh+ "\n"+(nam.getYear()-Integer.parseInt(namSinh)));	
		return "/Bai4Lab1/BaiLamThemLab1.html";
	}
}
