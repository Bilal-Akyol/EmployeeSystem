package com.example.demo1.controller;

import com.example.demo1.entity.Project;
import com.example.demo1.sevice.ProjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Project")
public class Projectcontroller {
    private ProjectService projectService;

    public Projectcontroller(ProjectService projectService) {
        this.projectService = projectService;
    }

    public List<Project> getAllProject()
    {
        return projectService.getAllProject();
    }
}
