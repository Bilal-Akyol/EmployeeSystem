package com.example.demo1.controller;

import com.example.demo1.database.dto.requets.OtherInformationRequets;
import com.example.demo1.database.dto.response.OtherInformationResponse;
import com.example.demo1.entity.entities.OtherInformation;
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
    public List<OtherInformationResponse> getAllOtherInformation()
    {
        return otherInformationService.getAllOtherInformation();
    }

    @PostMapping("/add")
    public OtherInformation addOtherInformation(@RequestBody OtherInformationRequets newOtherInformation)
    {
        return otherInformationService.addOtherInformation(newOtherInformation);
    }
    @PutMapping("/update/{id}")
    public OtherInformation updateOtherInformation(@PathVariable Long id,@RequestBody OtherInformationRequets otherInformationRequets)
    {

        return otherInformationService.updateOtherInformation(id,otherInformationRequets);
    }

}
