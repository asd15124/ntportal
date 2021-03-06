package com.nt.portal.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * DTO class for holding User Data
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
public class UserDto extends UsernamePasswordAuthenticationToken implements Serializable, UserDetails {

	public UserDto() {
		super(null, null);
	}

	public UserDto(String token) {
		super(null, null);
		this.token = token;
	}

	public UserDto(String userName, long id, String token, String password, List<GrantedAuthority> grantedAuthorities) {
		super(userName, password, grantedAuthorities);
		this.userName = userName;
		this.id = id;
		this.token = token;
		this.password = password;
		this.authorities = grantedAuthorities;
	}

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = -6641715622459960902L;

	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private Date createdOn;
	private String formattedCreatedOn;
	private Date updatedOn;
	private String formattedUpdatedOn;
	private Set<RoleDto> roles;
	private Long id;
	private String token;
	private List<GrantedAuthority> authorities;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the formattedCreatedOn
	 */
	public String getFormattedCreatedOn() {
		return formattedCreatedOn;
	}

	/**
	 * @param formattedCreatedOn
	 *            the formattedCreatedOn to set
	 */
	public void setFormattedCreatedOn(String formattedCreatedOn) {
		this.formattedCreatedOn = formattedCreatedOn;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn
	 *            the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the formattedUpdatedOn
	 */
	public String getFormattedUpdatedOn() {
		return formattedUpdatedOn;
	}

	/**
	 * @param formattedUpdatedOn
	 *            the formattedUpdatedOn to set
	 */
	public void setFormattedUpdatedOn(String formattedUpdatedOn) {
		this.formattedUpdatedOn = formattedUpdatedOn;
	}

	/**
	 * @return the roles
	 */
	public Set<RoleDto> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(Set<RoleDto> roles) {
		this.roles = roles;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		if (null != roles) {
			for (RoleDto roleDTo : roles) {
				grantedAuthorities.add(new SimpleGrantedAuthority(roleDTo.getRoleName()));
				grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roleDTo.getRoleName()));
			}
		}
		this.authorities = grantedAuthorities;
		return this.authorities;

		/* return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")); */
	}

	public Collection<GrantedAuthority> setAuthorities(List<RoleDto> roles) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for (RoleDto roleDTo : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(roleDTo.getRoleName()));
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roleDTo.getRoleName()));
		}
		this.authorities = grantedAuthorities;
		return this.authorities;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
