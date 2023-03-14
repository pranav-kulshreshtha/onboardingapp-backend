package com.shl.OnboardingProject.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Data
@Entity
@JsonIgnoreProperties(value = {"employee"})
@Table(name="salary_table")
public class Salary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(mappedBy="salary")
	private Employee employee;
	
	@Column(name="basic", nullable=false)
	private BigDecimal basic;
	
	@Column(name="ta", nullable=false)
	private BigDecimal ta;
	
	@Column(name="da", nullable=false)
	private BigDecimal da;
	
	@Column(name="hra", nullable=false)
	private BigDecimal hra;
	
	public Salary(int basic, int ta, int da, int hra) {
		this.basic = new BigDecimal(basic);
		this.ta = new BigDecimal(ta);
		this.da = new BigDecimal(da);
		this.hra = new BigDecimal(hra);
	}
}
