package com.example.demo1.controller;

import com.example.demo1.entity.Project;
import com.example.demo1.sevice.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Project")
public class Projectcontroller {
    @Autowired
    private ProjectService projectService;

    public Projectcontroller(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProject()
    {
        return projectService.getAllProject();
    }

    @PostMapping("/add")
    public Project addProject(@RequestBody Project newProject)
    {
        return projectService.addProject(newProject);
    }

}
