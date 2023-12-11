package org.unc.api.eportfolio;

import org.unc.api.student.StudentEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.*;
@Entity
@Data
@Table(name = "e_portfolios")
public class EportfolioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private StudentEntity student;

    @OneToOne
    @JoinColumn(name = "student_details_id", referencedColumnName = "id")
    private StudentDetails studentDetails;

    
    @OneToMany(mappedBy = "ePortfolio")
    private List<ProjectDetails> projectDetails;

    
    @OneToMany(mappedBy = "ePortfolio")
    private List<ProfessionalExperience> professionalExperiences;

    
    @OneToOne
    @JoinColumn(name = "certification_and_workshop_id", referencedColumnName = "id")
    private CertificationAndWorkshop certificationAndWorkshop;

}
