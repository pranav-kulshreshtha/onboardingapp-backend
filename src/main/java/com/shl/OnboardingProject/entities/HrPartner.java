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
@Table(name="hr_partner_table")
public class HrPartner{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "hr_partner_name", nullable = false, length = 50)
    private String name;
    
	@Column(name = "hr_partner_phone", nullable = false, length = 15)
	private String phone;
	
	public HrPartner(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
}
