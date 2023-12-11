package org.unc.api.eportfolio;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "student_details")
public class StudentDetails {

    @Id
    private Long id;

    @Column(length = 1000) 
    private String courses;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
   
    @TableGenerator(name = "gpa_gen", initialValue = 0, allocationSize = 1)
    private Double gpa;

    @Column(length = 1000) 
    private String skillsOverview;
    
    @Column(name = "contact")
    private String contact;

    @Column(length = 1000)
    private String personalInterests;

    @Column(name = "graduation_year")
    private int graduationYear;

}