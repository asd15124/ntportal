package com.nt.portal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Model class for Roles
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
@Entity
@Table(name = "NT_ROLES")
public class Role {

	@Id
	@GeneratedValue(generator = "NT_USERS_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "NT_USERS_SEQ", initialValue = 1, sequenceName = "NT_USERS_SEQ", allocationSize = 5)
	@Column(name = "ROLE_ID", nullable = false)
	private Long roleId;

	@Column(name = "ROLE_NAME", nullable = false)
	private String roleName;

	@Column(name = "ROLE_DESCRITION")
	private String roleDescription;

	/*@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<User> users;*/

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	/**
	 * @param roleDescription
	 *            the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	/**
	 * @return the users
	 *//*
	public List<User> getUsers() {
		return users;
	}

	*//**
	 * @param users
	 *            the users to set
	 *//*
	public void setUsers(List<User> users) {
		this.users = users;
	}*/

}
