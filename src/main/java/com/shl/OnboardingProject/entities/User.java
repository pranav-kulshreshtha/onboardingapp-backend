package com.shl.OnboardingProject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="user_name", nullable=false)
	private String userName;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="user_role", nullable=false)
	private String role;
	
	@Column(name="is_active", nullable=false)
	private boolean active;
	
	public boolean isActive() {
		return active;
	}
	
	public User(String userName, String password, String role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.active = true;
	}
	
	public User(int id,String userName, String password, String role) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.active = true;
	}
}
