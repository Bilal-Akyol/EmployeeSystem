package com.example.demo1.controller;

import com.example.demo1.database.dto.requets.ProjectRequest;
import com.example.demo1.database.dto.response.ProjectReponse;
import com.example.demo1.entity.entities.Project;
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
    public List<ProjectReponse> getAllProject()
    {
        return projectService.getAllProject();
    }

    @PostMapping("/add")
    public Project addProject(@RequestBody ProjectRequest newProject)
    {
        return projectService.addProject(newProject);
    }
    @PutMapping("/update/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody ProjectRequest project)
    {
      return projectService.updateProject(id, project);
    }

}
