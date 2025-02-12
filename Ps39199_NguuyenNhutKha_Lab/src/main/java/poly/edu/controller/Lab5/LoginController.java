package poly.edu.controller.Lab5;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class LoginController {
	@Autowired
	CookieService cookieService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;
	static class user {
        private String usName;
        private String password;
        private String photo;

        public user(String usName, String password, String photo) {
            this.usName = usName;
            this.password = password;
            this.photo = photo;
        }

        public String getUsName() {
            return usName;
        }

        public void setUsName(String usName) {
            this.usName = usName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }
	static List<user> register = new ArrayList<>(List.of(new user("poly", "123", "photo.jpg")));

	
    @GetMapping("/account/login")
	public String login1() {
	return "Lab5/account/login";
	}
    @GetMapping("/account/logout")
	public String logout() {
    	cookieService.remove("User");
    	sessionService.remove("username");
	return "Lab5/account/login";
	}
	@PostMapping("/account/login")
		public String login2() {
			System.out.println(register.get(1).password);
			  String un = paramService.getString("username", "");
			    String pw = paramService.getString("password", "");
		    boolean rm = paramService.getBoolean("remember", false);
			    register.forEach(login->{
			    	if(login.usName.equals(un)&&login.password.equals(pw)) {
			    		System.out.println(un+pw+rm);
			    		sessionService.set("username", login);
				    	 if(rm==true) {
						    	cookieService.add("User", un, 10);
						    }
			    	}
			    });
			    		
			sessionService.get("usename");
		    cookieService.get("User");
	return "Lab5/account/Welcome";
	}
	@GetMapping("/viewdangky")
	public String viewregister() {
		  	
	return "Lab5/account/register";
	}
	@PostMapping("/register")
	public String register(@RequestPart("photo_file") MultipartFile photoFile) {
		  	String un = paramService.getString("username", "");
		    String pw = paramService.getString("password", "");
		    String fileName = System.currentTimeMillis() + "_" + photoFile.getOriginalFilename();
		    System.out.println(un+pw+fileName);
		    paramService.save(photoFile, null);
		    user userRegister=new user(un,pw,fileName);
		    register.add(userRegister);
	return "Lab5/account/login";
	}

}
