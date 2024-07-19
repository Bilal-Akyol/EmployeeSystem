package com.example.demo1.controller;

import com.example.demo1.entity.OtherInformation;
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
    public List<OtherInformation> getAllOtherInformation()
    {
        return otherInformationService.getAllOtherInformation();
    }

    @PostMapping("/add")
    public OtherInformation addOtherInformation(@RequestBody OtherInformation newOtherInformation)
    {
        return otherInformationService.addOtherInformation(newOtherInformation);
    }

}
