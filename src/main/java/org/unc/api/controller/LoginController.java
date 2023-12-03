package org.unc.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller("/login")
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "logoutSuccess", required = false) Boolean logoutSuccess) {
        if (Boolean.TRUE.equals(logoutSuccess)) {
            model.addAttribute("logoutSuccess", true);
        }
        return "login";
    }
}