package com.nt.portal.services.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nt.portal.converter.RoleConverter;
import com.nt.portal.converter.UserConverter;
import com.nt.portal.dao.UserDao;
import com.nt.portal.dto.RoleDto;
import com.nt.portal.dto.UserDto;
import com.nt.portal.model.Role;
import com.nt.portal.model.User;
import com.nt.portal.services.UserService;

/**
 * Service class for User Management
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	/*
	 * @Autowired private BCryptPasswordEncoder bcryptEncoder;
	 */

	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private RoleConverter roleConverter;

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByuserName(username);
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id).get();
	}

	@Override
	public User save(UserDto user) {
		User newUser = new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setUserName(user.getUserName());
		LOGGER.debug("Unencrypted Password getting saved is ", user.getPassword());
		newUser.setPassword(user.getPassword());
		/* newUser.setPassword(bcryptEncoder.encode(user.getPassword())); */
		newUser.setEmail(user.getEmail());
		Set<Role> roles = new LinkedHashSet<Role>();
		for(RoleDto roleDto:user.getRoles()){
			roles.add(roleConverter.populate(roleDto));
		}
		newUser.setRoles(roles);
		return userDao.save(newUser);
	}

	/**
	 * Spring Security method to load user by userName
	 */
	@Override
	public UserDto loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("inside UserServiceImpl cmethod loadUserByUsername for username : {}", username);
		User user = userDao.findByuserName(username);
		if (null == user) {
			LOGGER.debug("User Not Found by UserName: {}", username);
			throw new UsernameNotFoundException("User does not exist by username " + username);
		}
		return userConverter.convert(user);
	}
}
