package com.nt.portal.services;

import java.util.List;

import com.nt.portal.dto.UserDto;
import com.nt.portal.model.User;

public interface UserService {

	User save(UserDto user);

	List<User> findAll();

	void delete(long id);

	User findOne(String username);

	User findById(Long id);
}
