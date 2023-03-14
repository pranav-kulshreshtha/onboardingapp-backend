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
@Table(name="acl_object_identity")
public class AclObjectIdentity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="object_id_class", referencedColumnName = "id")
	private AclClass objectIdClass;
	
	@Column(name="object_id_identity")
	private int objectIdIdentity;
	
	@Column(name="parent_object")
	private int parentObject;
	
	@OneToOne
	@JoinColumn(name="owner_sid", referencedColumnName = "id")
	private AclSid ownerSid;
	
	@Column(name="entries_inheriting")
	private boolean entriesInheriting;
}
