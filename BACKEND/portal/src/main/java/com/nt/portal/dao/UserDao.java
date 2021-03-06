package com.nt.portal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.portal.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	User findByuserName(String userName);
}
