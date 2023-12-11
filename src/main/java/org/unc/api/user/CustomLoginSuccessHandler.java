package org.unc.api.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                         Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        logger.info("Authentication success for user: {}", authentication.getName());

        if (roles.contains("DEAN")) {
            setDefaultTargetUrl("/admin/dashboard");
        } else if (roles.contains("STUDENT")) {
            setDefaultTargetUrl("/student/home");
        } else if (roles.contains("PROGRAM_HEAD")) {
            setDefaultTargetUrl("/programhead/home");
        } 
        else 
        {
            setDefaultTargetUrl("/access-denied");
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
