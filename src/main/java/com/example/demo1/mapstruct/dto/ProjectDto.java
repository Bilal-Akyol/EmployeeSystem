package com.example.demo1.mapstruct.dto;

import com.example.demo1.entity.enums.ProjectType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String projectName;

    @Enumerated(EnumType.STRING)

    private ProjectType projectType;

    private String department;


    private String vPNUsername;


    private String vPNpassword;


    private String EnvironmentInformation;



    private List<Long> employeeIds;
}
