package com.shl.OnboardingProject.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name="emp_table")
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "emp_name", nullable = false, length = 50)
    private String name;
	
	@Column(name = "emp_phone", nullable = false, length = 15)
	private String phone;
	
	@Column(name = "emp_address", nullable = false, length = 50)
    private String address;
	
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="salary", referencedColumnName = "id")
    private Salary salary;
	
	public Employee(String name, String phone, String address, Salary salary) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.salary = salary;
	}
}
