package com.example.demo1.sevice;

import com.example.demo1.mapstruct.dto.ProjectDto;
import com.example.demo1.mapstruct.mappers.MapStructMapper;
import com.example.demo1.repository.ProjectRepository;
import com.example.demo1.entity.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    private MapStructMapper mapStructMapper;

    public ProjectService(ProjectRepository projectRepository,MapStructMapper mapStructMapper) {
        this.projectRepository = projectRepository;
        this.mapStructMapper=mapStructMapper;
    }
    public List<ProjectDto> getAllProject()
    {
        List<Project> projects=projectRepository.findAll();
        List<ProjectDto>projectReponses=new ArrayList<>();
        for (Project project:projects)
        {
            ProjectDto reponseItem=new ProjectDto();
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

    public ProjectDto addProject(ProjectDto projectDto)
    {
        Project project=mapStructMapper.projectToDto(projectDto);
        projectDto.setProjectName(project.getProjectName());
        projectDto.setProjectType(project.getProjectType());
        projectDto.setDepartment(project.getDepartment());
        projectDto.setVPNUsername(project.getVPNUsername());
        projectDto.setVPNpassword(project.getVPNpassword());
        projectDto.setEnvironmentInformation(project.getEnvironmentInformation());
       // projectRequest.setEmployee(project.getEmployee());
        project=projectRepository.save(project);
        return mapStructMapper.projectDto(project);

    }
    public  ProjectDto updateProject(Long id, ProjectDto projectDto)
    {
        Project updateProject= projectRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("İd Tanımlı Bir Proje yok"));
        updateProject.setProjectName(projectDto.getProjectName());
        updateProject.setProjectType(projectDto.getProjectType());
        updateProject.setDepartment(projectDto.getDepartment());
        updateProject.setVPNUsername(projectDto.getVPNUsername());
        updateProject.setVPNpassword(projectDto.getVPNpassword());
        updateProject.setEnvironmentInformation(projectDto.getEnvironmentInformation());
        updateProject=projectRepository.save(updateProject);
        return mapStructMapper.projectDto(updateProject);
    }
    public void deleteProject(Long id)
    {

        projectRepository.deleteById(id);
    }

}
