package org.unc.api.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.unc.api.student.Program;
import org.unc.api.student.StudentEntity;
import org.unc.api.student.StudentService;

@Controller
@PreAuthorize("hasRole('DEAN')")
public class AdminController {

    private final StudentService studentService;

    public AdminController(StudentService studentService) {
        this.studentService = studentService;
    }

    // getting the view of admin dashboard
    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        List<StudentEntity> students = studentService.getAllStudents();
        int totalstudents = students.size();
        List<Object[]> totalPrograms = studentService.countStudentsByProgramAndMajor();
        model.addAttribute("students", students);
        model.addAttribute("totalstudents", totalstudents);
        model.addAttribute("totalprogramMajor", totalPrograms);
        return "admin/admin";
    }

    // getting the view of adding student
    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("programs", Program.values());
        model.addAttribute("student", new StudentEntity());
        model.addAttribute("programAndMajor", "");
        return "newstudent";
    }

    // save new student to the database
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") StudentEntity student) {

        studentService.saveStudent(student);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/getModalContent")
    public String getModalContent() {
        return "modal :: modalContent";
    }

}
