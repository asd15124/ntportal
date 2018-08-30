package com.nt.portal.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nt.portal.dto.RoleDto;
import com.nt.portal.model.Role;

/**
 * Converter class from RoleModel to RoleDto
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
@Component
public class RoleConverter {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleConverter.class);

	public RoleDto convert(Role roleModel) {
		LOGGER.info("inside UserConverter to convert UserModel to UserDto");
		RoleDto roleDto = null;

		if (null != roleModel) {

			roleDto = new RoleDto();
			roleDto.setRoleName(roleModel.getRoleName());
			roleDto.setRoleDescription((null != roleModel.getRoleDescription() ? roleModel.getRoleDescription() : ""));
			roleDto.setRoleId(roleModel.getRoleId());
		}

		return roleDto;
	}

	public Role populate(RoleDto roleDto) {
		LOGGER.info("inside UserConverter to convert UserModel to UserDto");
		Role role = null;

		if (null != roleDto) {

			role = new Role();
			role.setRoleName(roleDto.getRoleName());
			role.setRoleDescription((null != roleDto.getRoleDescription() ? roleDto.getRoleDescription() : ""));
			/*role.setRoleId(roleDto.getRoleId());*/
		}

		return role;
	}
}
