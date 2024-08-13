package com.example.demo1.sevice;


import com.example.demo1.entity.entities.Employee;
import com.example.demo1.entity.entities.Project;
import com.example.demo1.entity.enums.ProjectType;
import com.example.demo1.mapstruct.dto.ProjectDto;
import com.example.demo1.mapstruct.mappers.MapStructMapper;
import com.example.demo1.repository.EmployeeRepository;
import com.example.demo1.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MapStructMapper mapStructMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(mapStructMapper::projectToDto)
                .collect(Collectors.toList());
    }

    public ProjectDto getProjectById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.map(mapStructMapper::projectToDto).orElse(null);
    }

    public ProjectDto createProject(ProjectDto projectDto) {
        Project project = mapStructMapper.dtoToProject(projectDto);
        project = projectRepository.save(project);
        return mapStructMapper.projectToDto(project);
    }

    public ProjectDto updateProject(Long projectId, ProjectDto projectDTO) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));




        project.setProjectName(projectDTO.getProjectName());
        project.setProjectType(ProjectType.valueOf(String.valueOf(projectDTO.getProjectType())));
        project.setDepartment(projectDTO.getDepartment());
        project.setVPNUsername(projectDTO.getVPNUsername());
        project.setVPNpassword(projectDTO.getVPNpassword());
        project.setEnvironmentInformation(projectDTO.getEnvironmentInformation());

        if (projectDTO.getEmployeeIds() != null) {
            List<Employee> employees = projectDTO.getEmployeeIds().stream()
                    .map(id -> employeeRepository.findById(id)
                            .orElseThrow(() -> new IllegalArgumentException("Employee not found")))
                    .collect(Collectors.toList());
            project.setEmployees(employees);
        }



        Project savedProject = projectRepository.save(project);
        return mapStructMapper.projectToDto(savedProject);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}


