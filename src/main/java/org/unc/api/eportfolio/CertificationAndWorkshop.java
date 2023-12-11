package org.unc.api.eportfolio;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "additional_qualifications")
public class CertificationAndWorkshop {

    @Id
    private Long id;

    @Column(length = 2000) 
    private String certifications;

    @Column(length = 2000) 
    private String workshops;

    @OneToOne(mappedBy = "certificationAndWorkshop")
    private EportfolioEntity ePortfolio;

}