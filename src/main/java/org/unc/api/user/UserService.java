package org.unc.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByRoleAndIdNumber(Role role, String idNumber) {
        return userRepository.findByRoleAndIdNumber(role, idNumber);
    }

    public User findByUsername(String username){
        return userRepository.findByIdNumber(username);
    }
    
    @Transactional
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
