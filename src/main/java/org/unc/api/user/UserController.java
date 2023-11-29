package org.unc.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	private  UserService userService;
	
	@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	//showing the view of login page
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("userRoles", Role.values());
		return "login";
	}
	// show user registration
	@GetMapping("/register")
	public String showRegistration(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("userRoles", Role.values());
		return "userRegistration";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user, Model model) {
		// Debugging statement
		System.out.println("Received user for registration: " + user);
		userService.registerUser(user);
		// Debugging statement
		System.out.println("Received user for registration: " + user);
		return "Redirect::/login";
	}
	
	
	//login implementation 
	@PostMapping("/login")
	public String login(@RequestParam Role role, @RequestParam String idNumber,
	                    @RequestParam String plainPassword, Model model) {

	    User user = userService.findByRoleAndIdNumber(role, idNumber);
	    String passwordHash = user.getPassword();
	    
	    if (user != null && new BCryptPasswordEncoder().matches(plainPassword, passwordHash)) {
	        switch (role) {
	            case DEAN:
	                return "admin/dashboard";
	            case STUDENT:
	                return "student/home";
	            case PROGRAMHEAD:
	                return "programhead/dashboard";
	            default:
	                return "/login";
	        }
	    }

	    model.addAttribute("error", "Invalid credentials");
	    return "login";
	}


}
