package com.example.demo1.controller;

import com.example.demo1.entity.PersonalInformation;
import com.example.demo1.sevice.PersonalInformationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/KisiselBilgiler")
public class PersonalInformationController {
    private PersonalInformationService personalInformationService;

    public PersonalInformationController(PersonalInformationService personalInformationService) {
        this.personalInformationService = personalInformationService;
    }

    @GetMapping
    public List<PersonalInformation> getAllPersonalInformation(){
        return personalInformationService.getAllPersonalInformation();
    }

}
