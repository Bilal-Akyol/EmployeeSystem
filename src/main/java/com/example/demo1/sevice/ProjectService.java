package com.example.demo1.sevice;

import com.example.demo1.database.dto.requets.ProjectRequest;
import com.example.demo1.database.dto.response.ProjectReponse;
import com.example.demo1.entity.entities.Project;
import com.example.demo1.database.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public List<ProjectReponse> getAllProject()
    {
        List<Project> projects=projectRepository.findAll();
        List<ProjectReponse>projectReponses=new ArrayList<>();
        for (Project project:projects)
        {
            ProjectReponse reponseItem=new ProjectReponse();
            reponseItem.setId(project.getId());
            reponseItem.setProjectName(project.getProjectName());
            reponseItem.setProjectType(project.getProjectType());
            reponseItem.setDepartment(project.getDepartment());
            reponseItem.setVPNUsername(project.getVPNUsername());
            reponseItem.setVPNpassword(project.getVPNpassword());
            reponseItem.setEnvironmentInformation(project.getEnvironmentInformation());
            //reponseItem.setEmployee(project.getEmployee());
            projectReponses.add(reponseItem);
        }
        return projectReponses;
    }

    public Project addProject(ProjectRequest projectRequest)
    {
        Project project=new Project();
        projectRequest.setProjectName(project.getProjectName());
        projectRequest.setProjectType(project.getProjectType());
        projectRequest.setDepartment(project.getDepartment());
        projectRequest.setVPNUsername(project.getVPNUsername());
        projectRequest.setVPNpassword(project.getVPNpassword());
        projectRequest.setEnvironmentInformation(project.getEnvironmentInformation());
       // projectRequest.setEmployee(project.getEmployee());
        return projectRepository.save(project);

    }
    public  Project updateProject(Long id, ProjectRequest projectRequest)
    {
        Project updateProject= projectRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("İd Tanımlı Bir Proje yok"));
        updateProject.setProjectName(projectRequest.getProjectName());
        updateProject.setProjectType(projectRequest.getProjectType());
        updateProject.setDepartment(projectRequest.getDepartment());
        updateProject.setVPNUsername(projectRequest.getVPNUsername());
        updateProject.setVPNpassword(projectRequest.getVPNpassword());
        updateProject.setEnvironmentInformation(projectRequest.getEnvironmentInformation());
        return projectRepository.save(updateProject);
    }

}
