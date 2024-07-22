package com.example.demo1.controller;

import com.example.demo1.database.dto.requets.PersonalInfermationRequets;
import com.example.demo1.database.dto.response.PersonalInformationResponse;
import com.example.demo1.entity.entities.PersonalInformation;
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
    public List<PersonalInformationResponse> getAllPersonalInformation(){
        return personalInformationService.getAllPersonalInformation();
    }
    @PostMapping("/add")
    public PersonalInformation addPersonalInformation(@RequestBody PersonalInfermationRequets newPersonalInformation)
    {
        return personalInformationService.addPersonalInformation(newPersonalInformation);
    }
    @PutMapping("/update/{id}")
    public PersonalInformation updatePersonalInformation(@PathVariable Long id, @RequestBody PersonalInfermationRequets personalInformation)
    {
        return personalInformationService.updatePersonalInformation(id,personalInformation);
    }

}
