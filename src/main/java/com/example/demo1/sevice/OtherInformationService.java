package com.example.demo1.sevice;

import com.example.demo1.entity.entities.OtherInformation;
import com.example.demo1.mapstruct.dto.OtherInformationDto;
import com.example.demo1.mapstruct.mappers.MapStructMapper;
import com.example.demo1.repository.OtherInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OtherInformationService {

    @Autowired
    private OtherInformationRepository otherInformationRepository;

    @Autowired
    private MapStructMapper mapStructMapper;

    public List<OtherInformationDto> getAllOtherInformations() {
        List<OtherInformation> otherInformations = otherInformationRepository.findAll();
        return otherInformations.stream()
                .map(mapStructMapper::otherInformationToDto)
                .collect(Collectors.toList());
    }

    public OtherInformationDto getOtherInformationById(Long id) {
        Optional<OtherInformation> otherInformation = otherInformationRepository.findById(id);
        return otherInformation.map(mapStructMapper::otherInformationToDto).orElse(null);
    }

    public OtherInformationDto createOtherInformation(OtherInformationDto otherInformationDto) {
        OtherInformation otherInformation = mapStructMapper.dtoToOtherInformation(otherInformationDto);
        otherInformation = otherInformationRepository.save(otherInformation);
        return mapStructMapper.otherInformationToDto(otherInformation);
    }

    public OtherInformationDto updateOtherInformation( OtherInformationDto otherInformationDto) {
        Optional<OtherInformation> otherInformationOptional = otherInformationRepository.findById(otherInformationDto.getId());
        if (otherInformationOptional.isPresent()) {
            OtherInformation otherInformation = otherInformationOptional.get();
            otherInformation.setAddress(otherInformationDto.getAddress());
            otherInformation.setBankName(otherInformationDto.getBankName());
            otherInformation.setIbanNumber(otherInformationDto.getIbanNumber());
            otherInformation.setEmergencyContactName(otherInformationDto.getEmergencyContactName());
            otherInformation.setEmergencyContactNumber(otherInformationDto.getEmergencyContactNumber());
            otherInformation = otherInformationRepository.save(otherInformation);
            return mapStructMapper.otherInformationToDto(otherInformation);
        } else {
            return null;
        }
    }

    public void deleteOtherInformation(Long id) {
        otherInformationRepository.deleteById(id);
    }
}