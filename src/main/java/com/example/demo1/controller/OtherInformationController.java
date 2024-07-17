package com.example.demo1.controller;

import com.example.demo1.entity.OtherInformation;
import com.example.demo1.sevice.OtherInformationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/DigerBilgiler")
public class OtherInformationController {
    private OtherInformationService otherInformationService;

    public OtherInformationController(OtherInformationService otherInformationService) {
        this.otherInformationService = otherInformationService;
    }

    @GetMapping
    public List<OtherInformation> getAllOtherInformation()
    {
        return otherInformationService.getAllOtherInformation();
    }
}
