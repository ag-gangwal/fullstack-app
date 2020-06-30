package com.fullstack.dao;

import com.fullstack.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<User, Long> {

	List<User> findByLastName(String lastName);
	User findByEmployeeId(String employeeId);
	User findByUserId(long userId);
}
