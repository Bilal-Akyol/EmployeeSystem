package com.example.demo1.validation;

import com.example.demo1.mapstruct.dto.ProjectDto;
import com.example.demo1.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProjectValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return ProjectDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ProjectDto projectDto=(ProjectDto) target;

        if (projectDto.getProjectName() == null || projectDto.getProjectName().trim().isEmpty()) {
            errors.rejectValue("projectName", "NotNull.projectDto.projectName",
                    "Projenin ismini boş bırakamazsınız");
        }
        if (projectDto.getProjectType() == null) {
            errors.rejectValue("projectType", "NotNull.projectDto.projectType",
                    "Lütfen proje tipini giriniz");
        }
        if (projectDto.getVPNUsername() == null || projectDto.getVPNUsername().trim().isEmpty()) {
            errors.rejectValue("vPNUsername", "NotNull.projectDto.vPNUsername",
                    "Lütfen VPN ismini giriniz");
        }
        if (projectDto.getVPNpassword() == null) {
            errors.rejectValue("vPNpassword", "NotBlank.projectDto.vPNpassword",
                    "Adres boş bırakılamaz lütfen adres yerini doldurun");
        } else if (projectDto.getVPNpassword().length() < 8) {
            errors.rejectValue("vPNpassword", "Size.projectDto.vPNpassword",
                    "Şifre 8  karakterden az olamaz");

        }



    }
}
