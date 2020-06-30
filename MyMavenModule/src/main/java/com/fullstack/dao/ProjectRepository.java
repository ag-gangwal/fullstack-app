package com.fullstack.dao;

import com.fullstack.data.Customer;
import com.fullstack.data.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	List<Project> findByProject(String projectName);

	Project findById(long id);
}
