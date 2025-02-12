package poly.edu.controller.Lab3;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import poly.edu.Entity.Lab2.Staff;
import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StaffDetailController {
	List<Staff> listStaff = Arrays.asList(
	        new Staff("user1@gmail.com", "Nguyễn Văn User1", "photo.jpg", true, LocalDate.of(2005, 9, 26), 123, 2),
	        new Staff("user2@gmail.com", "Nguyễn Văn User2", "photo.jpg", true, LocalDate.of(2005, 9, 26), 124, 2),
	        new Staff("user3@gmail.com", "Nguyễn Văn User3", "photo.jpg", true, LocalDate.of(2005, 9, 26), 125, 2),
	        new Staff("user4@gmail.com", "Nguyễn Văn User4", "photo.jpg", true, LocalDate.of(2005, 9, 26), 126, 2),
	        new Staff("user5@gmail.com", "Nguyễn Văn User5", "photo.jpg", true, LocalDate.of(2005, 9, 26), 127, 2)
	    );
	
	@GetMapping("/StaffDetail")
	public String getSD(Model model) {
	    Staff staff = new Staff(
	        "user@gmail.com", "Nguyễn Văn User",
	        "photo.jpg",
	        true,
	        LocalDate.of(2005, 9, 26),
	        123,
	        2	
	    );
	    model.addAttribute("staff", staff);
	    return "/Lab3/StaffDetail.html";
	}
	@GetMapping("/showdetail/{detail}")
	public String getSD(@PathVariable("detail") String id,Model model) {
		
//		 System.out.println(listStaff.indexOf(id));
		 Staff staff = listStaff.stream()
	                .filter(stafftemp -> stafftemp.getId().equals(id))
	                .findFirst()
	                .orElse(null);	   
			   
//				model.addAttribute("staff",listStaff.stream().filter(stafftemp->stafftemp.getId()==id).findFirst().orElse(null));
//		System.out.println(staff.getId());
//		model.addAttribute("staff",listStaff.stream().filter(staff->staff.getId()==id).findFirst().get());
	   
	    return "/Lab3/StaffDetail.html";
	}
	@GetMapping("/listStaff")
	public String getMethodName(Model model) {
		
		model.addAttribute("listStaff",listStaff);
		return "/Lab3/ListStaffDetail.html";
	}
	
	

	}


