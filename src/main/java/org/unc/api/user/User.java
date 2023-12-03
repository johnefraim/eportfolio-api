package org.unc.api.user;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username must not be empty")
    private String username;

    @NotEmpty(message = "Password must not be empty")
    private String password;

    @Email(message = "Email should be valid")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

	public String getPassword() {
		
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
		
	}

	public Set<Role> getRoles() {
		
		return this.roles;
	}

	public String getUsername() {
		
		return this.username;
	}

    // Standard getters and setters
}
