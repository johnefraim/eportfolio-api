package org.unc.api.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImplentation implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImplentation(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.unc.api.user.User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with Username: " + username);
        }

        return user;
    }
}
