package org.unc.api.user;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                         Authentication authentication) throws IOException, ServletException {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String redirectURL = request.getContextPath();

        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STUDENT"))) {
            redirectURL += "/student/home";
        } else if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_DEAN"))) {
            redirectURL += "/admin/admin";
        } else if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_PROGRAM_HEAD"))) {
            redirectURL += "/program_head/dashboard";
        }

        response.sendRedirect(redirectURL);
    }
}
