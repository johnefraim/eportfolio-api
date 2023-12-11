package org.unc.api.eportfolio;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "student_overvie")
public class StudentOverview {

    @Id
    private Long id;

    @Column(length = 200)
    @Size(min = 100, max = 200)
    private String personalIntroduction;

    @Email
    private String email;

    @URL
    private String linkedIn;

    @Column(length = 100)
    @Size(min = 50, max = 100)
    private String objectiveStatement;

 
}