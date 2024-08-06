package com.example.demo1.controller;

import com.example.demo1.mapstruct.dto.OtherInformationDto;
import com.example.demo1.sevice.OtherInformationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DigerBilgiler")
public class OtherInformationController {
    @Autowired
    private OtherInformationService otherInformationService;

    public OtherInformationController(OtherInformationService otherInformationService) {
        this.otherInformationService = otherInformationService;
    }

    @GetMapping
    public List<OtherInformationDto> getAllOtherInformation()
    {
        return otherInformationService.getAllOtherInformations();
    }
    @GetMapping("/{id}")
    public OtherInformationDto getIdEOtherInformation(@PathVariable Long id)
    {
        return otherInformationService.getOtherInformationById(id);
    }

    @PostMapping("/add")
    public OtherInformationDto addOtherInformation(@Valid @RequestBody OtherInformationDto newOtherInformation)
    {
        return otherInformationService.createOtherInformation(newOtherInformation);
    }
    @PutMapping("/update")
    public OtherInformationDto updateOtherInformation(@Valid @RequestBody OtherInformationDto updateOtherInformationDto)
    {

        return otherInformationService.updateOtherInformation(updateOtherInformationDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOtherInformation(@PathVariable Long id)
    {
        otherInformationService.deleteOtherInformation(id);
    }

}
