package com.example.demo1.database.dto.requets;

import com.example.demo1.entity.entities.Employee;
import com.example.demo1.entity.enums.ProjectType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {
    private String projectName;
    private ProjectType projectType;
    private String department;
    private String vPNUsername;
    private String vPNpassword;
    private String EnvironmentInformation;
    private Employee employee;
}
