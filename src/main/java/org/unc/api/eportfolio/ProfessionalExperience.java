package org.unc.api.eportfolio;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "professional_experience")
public class ProfessionalExperience {

    @Id
    private Long id;

    @Column(length = 1000) 
    private String company;

    @Column(length = 1000)
    private String role;

    @Column(length = 500) 
    private String duration;

    @Column(length = 2000) 
    private String responsibilities;

    @Column(length = 2000) 
    private String achievements;

    @ManyToOne
    @JoinColumn(name = "e_portfolio_id", referencedColumnName = "id")
    private EportfolioEntity ePortfolio;

}