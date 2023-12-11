package org.unc.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.unc.api.student.StudentEntity;
import org.unc.api.user.UserService;
import org.unc.api.student.StudentService;

@Controller
public class StudentController {

    private final UserService userService;
    private final StudentService studentService;
   

    public StudentController(UserService userService, StudentService studentService) {
        this.userService = userService;
        this.studentService = studentService;
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/student/home")
    public String studentHome(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("username", username);

        return "student/home";
    }
    
    @GetMapping("/profile")
    private StudentEntity getLoggedInStudent(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String currentUsername = auth.getName();

        return null;
    }
}