package com.nt.portal.converter;

import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.portal.dto.RoleDto;
import com.nt.portal.dto.UserDto;
import com.nt.portal.model.Role;
import com.nt.portal.model.User;

/**
 * Converter Class from User Model to UserDTO
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
@Component
public class UserConverter {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserConverter.class);

	@Autowired
	private RoleConverter roleConverter;

	public UserDto convert(User userModel) {
		LOGGER.info("inside UserConverter to convert UserModel to UserDto");
		UserDto userDto = null;

		if (null != userModel) {

			userDto = new UserDto();
			userDto.setUserName(userModel.getUserName());
			userDto.setPassword(userModel.getUserName());
			userDto.setEmail(userModel.getEmail());
			userDto.setFirstName(userModel.getFirstName());
			userDto.setLastName((null != userModel.getLastName() ? userModel.getLastName() : ""));
			Set<RoleDto> roles;
			if (null != userModel.getRoles() && userModel.getRoles().size() > 0) {
				roles = new LinkedHashSet<RoleDto>();
				for (Role roleModel : userModel.getRoles()) {
					roles.add(roleConverter.convert(roleModel));

				}
				userDto.setRoles(roles);
			}
		}

		return userDto;
	}
}
