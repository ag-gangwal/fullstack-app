package com.fullstack.dao;

import com.fullstack.data.Project;
import com.fullstack.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByLastName(String lastName);
	User findByEmployeeId(String employeeId);
	User findByUserId(long userId);
}
