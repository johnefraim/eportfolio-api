package org.unc.api.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String defaultAfterLogin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated() && !(auth.getPrincipal() instanceof String)) {
            Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());

            if (roles.contains("DEAN")) {
                return "redirect:/admin/admin";
            } else if (roles.contains("STUDENT")) {
                return "redirect:/student/home";
            } else if (roles.contains("PROGRAM_HEAD")) {
                return "redirect:/programhead/home";
            }
            // Add more roles if needed
        }
        return "redirect:/login";
    }
}