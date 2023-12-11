package org.unc.api.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class DefaultController {

    /**
     * This method returns a String representing the redirect URL based on the user's role after login.
     * If the user is authenticated and has the role "DEAN", the method returns "/admin/admin".
     * If the user is authenticated and has the role "STUDENT", the method returns "/student/home".
     * If the user is authenticated and has the role "PROGRAM_HEAD", the method returns "/programhead/home".
     * If the user is not authenticated or does not have any of the specified roles, the method returns "/login".
     *
     * @return a String representing the redirect URL based on the user's role after login
     */
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
            
        }
        return "redirect:/login";
    }
}