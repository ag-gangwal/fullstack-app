package com.fullstack.controller;

import com.fullstack.dao.ProjectRepository;
import com.fullstack.data.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fullstack")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepo;

    @PostMapping (path = "/project")
    public void project(@RequestBody Project project){
        projectRepo.save(project);

    }

    @GetMapping  (path = "/project")
    public List<Project> project(){
        return (List<Project>) projectRepo.findAll();

    }



}
