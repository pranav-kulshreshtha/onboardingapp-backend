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
@Table(name="super_admin_table")
public class SuperAdmin{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "super_admin_name", nullable = false, length = 50)
    private String name;
    
	@Column(name = "super_admin_phone", nullable = false, length = 15)
	private String phone;
	
	public SuperAdmin(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
}
