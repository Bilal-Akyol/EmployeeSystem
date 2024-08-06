package com.example.demo1.sevice;

import com.example.demo1.entity.entities.PersonalInformation;
import com.example.demo1.mapstruct.dto.PersonalInformationDto;
import com.example.demo1.mapstruct.mappers.MapStructMapper;
import com.example.demo1.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonalInformationService {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    @Autowired
    private MapStructMapper mapStructMapper;

    public List<PersonalInformationDto> getAllPersonalInformations() {
        List<PersonalInformation> personalInformations = personalInformationRepository.findAll();
        return personalInformations.stream()
                .map(mapStructMapper::personalInformationToDto)
                .collect(Collectors.toList());
    }

    public PersonalInformationDto getPersonalInformationById(Long id) {
        Optional<PersonalInformation> personalInformation = personalInformationRepository.findById(id);
        return personalInformation.map(mapStructMapper::personalInformationToDto).orElse(null);
    }

    public PersonalInformationDto createPersonalInformation(PersonalInformationDto personalInformationDto) {
        PersonalInformation personalInformation = mapStructMapper.dtoToPersonalInformation(personalInformationDto);
        personalInformation = personalInformationRepository.save(personalInformation);
        return mapStructMapper.personalInformationToDto(personalInformation);
    }

    public PersonalInformationDto updatePersonalInformation(PersonalInformationDto personalInformationDto) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationDto.getId());
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            personalInformation.setBirthDate(personalInformationDto.getBirthDate());
            personalInformation.setNationalId(personalInformationDto.getNationalId());
            personalInformation.setMilitary(personalInformationDto.getMilitary());
            personalInformation.setGender(personalInformationDto.getGender());
            personalInformation.setMaritalStatus(personalInformationDto.getMaritalStatus());
            personalInformation = personalInformationRepository.save(personalInformation);
            return mapStructMapper.personalInformationToDto(personalInformation);
        } else {
            return null;
        }
    }


    public void deletePersonalInformation(Long id) {
        personalInformationRepository.deleteById(id);
    }
}
