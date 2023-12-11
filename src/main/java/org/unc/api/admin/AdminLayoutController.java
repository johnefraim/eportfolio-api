package org.unc.api.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLayoutController {
    
    @GetMapping("/student-overview")
    public String studentOverview() {
        return "admin/student-overview";
    }

    @GetMapping("/reporting-tools")
    public String reportingTools() {
        return "admin/reporting-tools";
    }
}
