package com.example.demo1.controller;

import com.example.demo1.mapstruct.dto.PersonalInformationDto;
import com.example.demo1.sevice.PersonalInformationService;
import jakarta.validation.Valid;
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
        return personalInformationService.getAllPersonalInformations();
    }
    @GetMapping("/{id}")
    public PersonalInformationDto getIdPersonalInformation(@PathVariable Long id)
    {
        return personalInformationService.getPersonalInformationById(id);
    }

    @PostMapping("/add")
    public PersonalInformationDto addPersonalInformation(@Valid  @RequestBody PersonalInformationDto newPersonalInformation)
    {
        return personalInformationService.createPersonalInformation(newPersonalInformation);
    }
    @PutMapping("/update")
    public PersonalInformationDto updatePersonalInformation(@Valid  @RequestBody PersonalInformationDto updatePersonalInformationDto)
    {
        return personalInformationService.updatePersonalInformation(updatePersonalInformationDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePersonalInformation(@PathVariable Long id)
    {
        personalInformationService.deletePersonalInformation(id);
    }

}
