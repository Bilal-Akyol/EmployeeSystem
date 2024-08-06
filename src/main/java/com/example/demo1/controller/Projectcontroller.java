package com.example.demo1.controller;

import com.example.demo1.mapstruct.dto.ProjectDto;
import com.example.demo1.sevice.ProjectService;
import jakarta.validation.Valid;
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
    public List<ProjectDto> getAllProject()
    {
        return projectService.getAllProjects();
    }
    @GetMapping("/{id}")
    public ProjectDto getIdProject(@PathVariable Long id)
    {
        return projectService.getProjectById(id);
    }

    @PostMapping("/add")
    public ProjectDto addProject(@Valid @RequestBody ProjectDto newProject)
    {
        return projectService.createProject(newProject);
    }
    @PutMapping("/update/{id}")
    public ProjectDto updateProject(@PathVariable Long id, @Valid @RequestBody ProjectDto projectDTO)
    {
      return projectService.updateProject(id,projectDTO);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Long id)
    {
        projectService.deleteProject(id);
    }

}
