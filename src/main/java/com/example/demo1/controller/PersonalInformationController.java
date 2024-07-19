package com.example.demo1.controller;

import com.example.demo1.entity.PersonalInformation;
import com.example.demo1.sevice.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/KisiselBilgiler")
public class PersonalInformationController {
    @Autowired
    private PersonalInformationService personalInformationService;

    public PersonalInformationController(PersonalInformationService personalInformationService) {
        this.personalInformationService = personalInformationService;
    }

    @GetMapping
    public List<PersonalInformation> getAllPersonalInformation(){
        return personalInformationService.getAllPersonalInformation();
    }
    @PostMapping("/add")
    public PersonalInformation addPersonalInformation(@RequestBody PersonalInformation newPersonalInformation)
    {
        return personalInformationService.addPersonalInformation(newPersonalInformation);
    }

}
