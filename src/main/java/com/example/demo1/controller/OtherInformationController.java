package com.example.demo1.controller;

import com.example.demo1.mapstruct.dto.OtherInformationDto;
import com.example.demo1.sevice.OtherInformationService;
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
        return otherInformationService.getAllOtherInformation();
    }

    @PostMapping("/add")
    public OtherInformationDto addOtherInformation(@RequestBody OtherInformationDto newOtherInformation)
    {
        return otherInformationService.addOtherInformation(newOtherInformation);
    }
    @PutMapping("/update/{id}")
    public OtherInformationDto updateOtherInformation(@PathVariable Long id,@RequestBody OtherInformationDto updateOtherInformationDto)
    {

        return otherInformationService.updateOtherInformation(id,updateOtherInformationDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOtherInformation(@PathVariable Long id)
    {
        otherInformationService.deleteOtherInformation(id);
    }

}
