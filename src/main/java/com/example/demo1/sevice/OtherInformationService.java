package com.example.demo1.sevice;

import com.example.demo1.mapstruct.dto.OtherInformationDto;
import com.example.demo1.mapstruct.mappers.MapStructMapper;
import com.example.demo1.repository.OtherInformationRepository;
import com.example.demo1.entity.entities.OtherInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OtherInformationService {

    @Autowired
    private OtherInformationRepository otherInformationRepository;
    private MapStructMapper mapStructMapper;

    public OtherInformationService(OtherInformationRepository otherInformationRepository,MapStructMapper mapStructMapper) {
        this.otherInformationRepository = otherInformationRepository;
        this.mapStructMapper=mapStructMapper;
    }

    public List<OtherInformationDto> getAllOtherInformation() {
        List<OtherInformation> otherInformations = otherInformationRepository.findAll();
        List<OtherInformationDto> otherInformationResponses = new ArrayList<>();
        for (OtherInformation otherInformation : otherInformations) {
            OtherInformationDto responseItem = new OtherInformationDto();
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

    public OtherInformationDto addOtherInformation(OtherInformationDto otherInformationDto) {
        OtherInformation otherInformation = mapStructMapper.otherInformationToDto(otherInformationDto);
        otherInformation.setAddress(otherInformationDto.getAddress());
        otherInformation.setBankName(otherInformationDto.getBankName());
        otherInformation.setIbanNumber(otherInformationDto.getIbanNumber());
        otherInformation.setEmergencyContactName(otherInformationDto.getEmergencyContactName());
        otherInformation.setEmergencyContactNumber(otherInformationDto.getEmergencyContactNumber());
       // otherInformation.setEmployee(otherInformationRequets.getEmployee());
        otherInformation=otherInformationRepository.save(otherInformation);
        return mapStructMapper.otherInformationDto(otherInformation);
    }

    public OtherInformationDto updateOtherInformation(Long id, OtherInformationDto otherInformationDto) {
        OtherInformation updateOtherInformation = otherInformationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("İd ait diğer bilgiler bulunamadı"));

        updateOtherInformation.setAddress(otherInformationDto.getAddress());
        updateOtherInformation.setBankName(otherInformationDto.getBankName());
        updateOtherInformation.setIbanNumber(otherInformationDto.getIbanNumber());
        updateOtherInformation.setEmergencyContactName(otherInformationDto.getEmergencyContactName());
        updateOtherInformation.setEmergencyContactNumber(otherInformationDto.getEmergencyContactNumber());
       // updateOtherInformation.setEmployee(otherInformationRequets.getEmployee());
        updateOtherInformation=otherInformationRepository.save(updateOtherInformation);
        return mapStructMapper.otherInformationDto(updateOtherInformation);

    }
    public void deleteOtherInformation(Long id)
    {

        otherInformationRepository.deleteById(id);
    }


}
