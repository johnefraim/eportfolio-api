package org.unc.api.user;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    // Getters and setters

	public String getName() {
		
		return this.name;
	}
}
