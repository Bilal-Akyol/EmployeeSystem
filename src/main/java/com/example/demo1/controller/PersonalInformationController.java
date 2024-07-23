package com.example.demo1.controller;

import com.example.demo1.mapstruct.dto.PersonalInformationDto;
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
    public List<PersonalInformationDto> getAllPersonalInformation(){
        return personalInformationService.getAllPersonalInformation();
    }
    @PostMapping("/add")
    public PersonalInformationDto addPersonalInformation(@RequestBody PersonalInformationDto newPersonalInformation)
    {
        return personalInformationService.addPersonalInformation(newPersonalInformation);
    }
    @PutMapping("/update/{id}")
    public PersonalInformationDto updatePersonalInformation(@PathVariable Long id, @RequestBody PersonalInformationDto updatePersonalInformationDto)
    {
        return personalInformationService.updatePersonalInformation(id,updatePersonalInformationDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePersonalInformation(@PathVariable Long id)
    {
        personalInformationService.deletePersonalInformation(id);
    }

}
