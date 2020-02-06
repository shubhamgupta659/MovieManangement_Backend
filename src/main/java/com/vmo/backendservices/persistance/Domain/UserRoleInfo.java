package com.vmo.backendservices.persistance.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register_user_role")
public class UserRoleInfo {
	
	 	@Id
	    @GeneratedValue
	    @Column(name = "role_id")
	    private Integer roleId;
	 
	 	@Column(name = "role_name")
	    private String roleName;

		public Integer getRoleId() {
			return roleId;
		}

		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}

		public String getRoleName() {
			return roleName;
		}

		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
	 	
	 	

}
