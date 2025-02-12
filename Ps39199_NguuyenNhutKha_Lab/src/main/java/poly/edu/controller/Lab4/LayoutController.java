package poly.edu.controller.Lab4;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {
	@GetMapping("/homeLab4/index1")
    public String index(Model model) {
        return "Lab4/home";
    }

    @GetMapping("/home/about")
    public String about(Model model) {
        return "/Lab4/about.html";
    }
}
