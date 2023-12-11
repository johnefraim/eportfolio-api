package org.unc.api.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.unc.api.user.User;




@Controller("/login")
public class LoginController {

    /**
        * Handles the GET request for the "/login" endpoint.
        * 
        * @param model          the model object used to pass data to the view
        * @param logoutSuccess  a boolean indicating if the user has successfully logged out
        * @return               the name of the view to be rendered
        */
    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "logoutSuccess", required = false) Boolean logoutSuccess) {
        final User user = new User();
        model.addAttribute("user", user);
        if (Boolean.TRUE.equals(logoutSuccess)) {
            model.addAttribute("logoutSuccess", true);
        }
        return "login";
    }
}