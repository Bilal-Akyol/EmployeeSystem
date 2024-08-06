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

    @NotBlank(message = "Proje ismi giriniz lütfen")
    private String projectName;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Lütfen bir proje tipi giriniz")
    private ProjectType projectType;

    private String department;

    @NotNull(message = "Bu alan zorunludur")
    private String vPNUsername;

    @Size(min = 8, message ="Lütfen en az 8 haneli bir şifre belirleyin")
    @NotNull(message = "Bu alan zorunludur")
    private String vPNpassword;

    @Size(min = 2)
    @NotNull(message = "Ortam bilgilerini girmek zorundasınız")
    private String EnvironmentInformation;



    private List<Long> employeeIds;
}
