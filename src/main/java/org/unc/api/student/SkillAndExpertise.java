package org.unc.api.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class SkillAndExpertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "programming_languages")
    private String programmingLanguages;

    @Column(name = "development_tools")
    private String developmentTools;

    @Column(name = "frameworks")
    private String frameworks;

    @Column(name = "_databases")
    private String databases;

    @Column(name = "soft_skills")
    private String softSkills;
}
