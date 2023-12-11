package org.unc.api.eportfolio;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "project_details")
public class ProjectDetails {

    @Id
    private Long id;

    @Column(length = 1000) 
    private String projectTitle;

    @Column(length = 2000) 
    private String projectDescription;

    @Column(length = 1000) 
    private String technologiesUsed;

    @Column(length = 1000) 
    private String role;

    @Column(length = 1000) 
    private String outcome;

    @Column(length = 1000) 
    private String coursework;

    @ManyToOne
    @JoinColumn(name = "e_portfolio_id", referencedColumnName = "id")
    private EportfolioEntity ePortfolio;


}
