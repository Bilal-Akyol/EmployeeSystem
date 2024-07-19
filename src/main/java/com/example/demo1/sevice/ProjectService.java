package com.example.demo1.sevice;

import com.example.demo1.entity.Project;
import com.example.demo1.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public List<Project> getAllProject()
    {
        return projectRepository.findAll();
    }

    public Project addProject(Project newProject)
    {
        return projectRepository.save(newProject);
    }
}
