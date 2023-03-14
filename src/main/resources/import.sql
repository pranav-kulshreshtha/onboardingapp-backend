INSERT INTO acl_sid(id, principal, sid) VALUES(1, 1, 'pranav@xyz.com');
INSERT INTO acl_sid(id, principal, sid) VALUES(2, 0, 'ROLE_EMPLOYEE');
INSERT INTO acl_sid(id, principal, sid) VALUES(3, 0, 'ROLE_HR_ADMIN');
INSERT INTO acl_sid(id, principal, sid) VALUES(4, 0, 'ROLE_HR_PARTNER');
INSERT INTO acl_sid(id, principal, sid) VALUES(5, 0, 'ROLE_SUPERADMIN');

INSERT INTO acl_class (id, class) VALUES(1, 'com.shl.OnboardingProject.entities.Employee');
INSERT INTO acl_class (id, class) VALUES(2, 'com.shl.OnboardingProject.entities.HrAdmin');
INSERT INTO acl_class (id, class) VALUES(3, 'com.shl.OnboardingProject.entities.HrPartner');
INSERT INTO acl_class (id, class) VALUES(4, 'com.shl.OnboardingProject.entities.SuperAdmin');

INSERT INTO emp_table(id, emp_name, emp_phone, emp_address) VALUES(1, 'Rakesh', '8585858585', 'Gurgaon');

INSERT INTO acl_object_identity(id, object_id_class, object_id_identity, parent_object, owner_sid,entries_inheriting) VALUES(1, 1, 1, NULL, 1, 0);

INSERT INTO acl_entry(id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES(1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO acl_entry(id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES(2, 1, 2, 1, 2, 1, 1, 1);
INSERT INTO acl_entry(id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES(3, 1, 3, 3, 1, 1, 1, 1);
INSERT INTO acl_entry(id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES(4, 1, 3, 3, 2, 1, 1, 1);




