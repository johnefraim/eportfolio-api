package org.unc.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/student/home")
    public String studentHome() {
        return "student/home";
    }
}