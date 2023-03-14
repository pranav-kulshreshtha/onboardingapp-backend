package com.shl.OnboardingProject.acl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor

@Data
@Entity
@Table(name="acl_entry")
public class AclEntry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="acl_object_identity", referencedColumnName = "id")
	private AclObjectIdentity aclObjectIdentity;
	
	@Column(name="ace_order",nullable = false)
	private int aceOrder;
	
	@OneToOne
	@JoinColumn(name="sid", referencedColumnName = "id")
	private AclSid sid;
	
	@Column(name="mask", nullable = false)
	private int mask;
	
	@Column(name="granting", nullable = false)
	private boolean granting;
	
	@Column(name="audit_success", nullable = false)
	private boolean auditSuccess;
	
	@Column(name="audit_failure", nullable = false)
	private boolean auditFailure;
}
