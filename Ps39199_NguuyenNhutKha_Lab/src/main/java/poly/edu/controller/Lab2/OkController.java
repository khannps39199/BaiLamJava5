package poly.edu.controller.Lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ctrl/ok")
public class OkController {

    @Autowired
    HttpServletRequest req;
    @GetMapping("/form")
    public String m() {      
        return "Lab2/ok";
    }
    @PostMapping
    public String m1() {
        req.setAttribute("ok", "1"); // OK 1: POST request to /ctrl/ok
        return "Lab2/ok";
    }

    @GetMapping
    public String m2() {
        req.setAttribute("ok", "2"); // OK 2: GET request to /ctrl/ok
        return "Lab2/ok";
    }

    @PostMapping(params = "x")
    public String m3(@RequestParam(value = "x", required = false) String x) {
        req.setAttribute("ok", x); // OK 3: POST request to /ctrl/ok with parameter x
        return "Lab2/ok";
    }
}
