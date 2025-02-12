package poly.edu.controller.Lab2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@GetMapping("/a")
    public String a(Model model) {
        return "Lab2/a"; 
    }

   
    @GetMapping("/b")
    public String b(Model model) {
        model.addAttribute("message", "Message from /b using Model");
        return "forward:/a"; 
    }

    
    @GetMapping("/c")
    public String c(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Message from /c using RedirectAttributes");
        return "redirect:/a"; // Chuyển hướng đến /a
    }

    @ResponseBody
    @GetMapping("/d")
    public String d(Model model) {
        String result = m4();
        model.addAttribute("message", result); 
        return "Lab2/a"; 
    }

    
    public String m4() {
        return "Result from m4()";
    }
}
