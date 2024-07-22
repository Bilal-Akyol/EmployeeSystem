package com.example.demo1.sevice;

import com.example.demo1.database.dto.requets.OtherInformationRequets;
import com.example.demo1.database.dto.response.OtherInformationResponse;
import com.example.demo1.entity.entities.OtherInformation;
import com.example.demo1.database.repository.OtherInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OtherInformationService {

    @Autowired
    private OtherInformationRepository otherInformationRepository;

    public OtherInformationService(OtherInformationRepository otherInformationRepository) {
        this.otherInformationRepository = otherInformationRepository;
    }

    public List<OtherInformationResponse> getAllOtherInformation() {
        List<OtherInformation> otherInformations = otherInformationRepository.findAll();
        List<OtherInformationResponse> otherInformationResponses = new ArrayList<>();
        for (OtherInformation otherInformation : otherInformations) {
            OtherInformationResponse responseItem = new OtherInformationResponse();
            responseItem.setId(otherInformation.getId());
            responseItem.setAddress(otherInformation.getAddress());
            responseItem.setBankName(otherInformation.getBankName());
            responseItem.setIbanNumber(otherInformation.getIbanNumber());
            responseItem.setEmergencyContactName(otherInformation.getEmergencyContactName());
            responseItem.setEmergencyContactNumber(otherInformation.getEmergencyContactNumber());
            //responseItem.setEmployee(otherInformation.getEmployee());
            otherInformationResponses.add(responseItem);
        }
        return otherInformationResponses;
    }

    public OtherInformation addOtherInformation(OtherInformationRequets otherInformationRequets) {
        OtherInformation otherInformation = new OtherInformation();
        otherInformation.setAddress(otherInformationRequets.getAddress());
        otherInformation.setBankName(otherInformationRequets.getBankName());
        otherInformation.setIbanNumber(otherInformationRequets.getIbanNumber());
        otherInformation.setEmergencyContactName(otherInformationRequets.getEmergencyContactName());
        otherInformation.setEmergencyContactNumber(otherInformationRequets.getEmergencyContactNumber());
       // otherInformation.setEmployee(otherInformationRequets.getEmployee());
        return otherInformationRepository.save(otherInformation);
    }

    public OtherInformation updateOtherInformation(Long id, OtherInformationRequets otherInformationRequets) {
        OtherInformation updateOtherInformation = otherInformationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("İd ait diğer bilgiler bulunamadı"));

        updateOtherInformation.setAddress(otherInformationRequets.getAddress());
        updateOtherInformation.setBankName(otherInformationRequets.getBankName());
        updateOtherInformation.setIbanNumber(otherInformationRequets.getIbanNumber());
        updateOtherInformation.setEmergencyContactName(otherInformationRequets.getEmergencyContactName());
        updateOtherInformation.setEmergencyContactNumber(otherInformationRequets.getEmergencyContactNumber());
       // updateOtherInformation.setEmployee(otherInformationRequets.getEmployee());
        return  otherInformationRepository.save(updateOtherInformation);

    }


}
