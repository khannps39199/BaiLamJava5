package poly.edu.controller.Lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import poly.edu.Entity.Lab2.Staff1;
import poly.edu.Entity.Lab2.StaffToValidation;
import poly.edu.controller.Lab5.ParamService;
@Controller
public class Lab4ControllerBai1 {
	@Autowired
	ParamService paramService;
	  @GetMapping("/staff/create/form")
	    public String createForm(Model model, @ModelAttribute("staff") Staff1 staff) {
	        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
	        return "Lab4/staff-create.html";
	    }

	    @PostMapping("/staff/create/save")
	    public String createSave(Model model, @ModelAttribute("staff") Staff1 staff,
	                             @RequestPart("photo_file") MultipartFile photoFile) {
	        if (!photoFile.isEmpty()) {
	            staff.setPhoto(photoFile.getName());
	        }String uploadDir = "E:/SOF302_JAVA5/LABS/Ps39199_NguuyenNhutKha_Lab/src/main/resources/static/photos";
	        paramService.save(photoFile, null);
	        model.addAttribute("message", "Xin chào " + staff.getFullName());
	        return "Lab4/staff-create";
	    }

	    @GetMapping("/staff/create/form2")
	    public String createForm2(Model model, @ModelAttribute("staff2") StaffToValidation staff2) {
	        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
	        return "Lab4/staff-validate";
	    }

	    @PostMapping("/staff/create/save2")
	    public String createSave2(Model model,
	                              @RequestPart("photo_file") MultipartFile photoFile,
	                              @Valid @ModelAttribute("staff2") StaffToValidation staff2, Errors errors) {
	        if (!photoFile.isEmpty()) {
	            staff2.setPhoto(photoFile.getName());
	        }
	        if (errors.hasErrors()) {
	            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
	        } else {
	            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
	        }
	        return "Lab4/staff-validate";
	    }

}
