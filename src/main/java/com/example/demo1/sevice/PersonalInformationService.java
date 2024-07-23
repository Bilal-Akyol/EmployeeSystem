package com.example.demo1.sevice;

import com.example.demo1.mapstruct.dto.PersonalInformationDto;
import com.example.demo1.mapstruct.mappers.MapStructMapper;
import com.example.demo1.repository.PersonalInformationRepository;
import com.example.demo1.entity.entities.PersonalInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalInformationService {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;
    private MapStructMapper mapStructMapper;

    public PersonalInformationService(PersonalInformationRepository personalInformationRepository, MapStructMapper mapStructMapper) {
        this.personalInformationRepository = personalInformationRepository;
        this.mapStructMapper=mapStructMapper;
    }

    public List<PersonalInformationDto> getAllPersonalInformation()
    {
        List<PersonalInformation> personalInformations= personalInformationRepository.findAll();
        List<PersonalInformationDto> personalInformationResponses=new ArrayList<>();
        for (PersonalInformation personalInformation:personalInformations)
        {
            PersonalInformationDto reponseItem=new PersonalInformationDto();
            reponseItem.setId(personalInformation.getId());
            reponseItem.setBirthDate(personalInformation.getBirthDate());
            reponseItem.setNationalId(personalInformation.getNationalId());
            reponseItem.setMilitary(personalInformation.getMilitary());
            reponseItem.setGender(personalInformation.getGender());
            reponseItem.setMaritalStatus(personalInformation.getMaritalStatus());
           // reponseItem.setEmployee(personalInformation.getEmployee());
            personalInformationResponses.add(reponseItem);
        }
        return personalInformationResponses;
    }

    public PersonalInformationDto addPersonalInformation(PersonalInformationDto personalInformationDto)
    {
        PersonalInformation personalInformation=mapStructMapper.personalInformationToDto(personalInformationDto);
        personalInformation.setBirthDate(personalInformationDto.getBirthDate());
        personalInformation.setNationalId(personalInformationDto.getNationalId());
        personalInformation.setMilitary(personalInformationDto.getMilitary());
        personalInformation.setGender(personalInformationDto.getGender());
        personalInformation.setMaritalStatus(personalInformationDto.getMaritalStatus());
        personalInformation=personalInformationRepository.save(personalInformation);
        return mapStructMapper.personalInformationDto(personalInformation);
    }
    public PersonalInformationDto updatePersonalInformation(Long id, PersonalInformationDto personalInformationDto)
    {
        PersonalInformation updatePersonalInformation= personalInformationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("İd bağlı kişisel veriler bulunmamaktadır"));
        updatePersonalInformation.setBirthDate(personalInformationDto.getBirthDate());
        updatePersonalInformation.setNationalId(personalInformationDto.getNationalId());
        updatePersonalInformation.setMilitary(personalInformationDto.getMilitary());
        updatePersonalInformation.setGender(personalInformationDto.getGender());
        updatePersonalInformation.setMaritalStatus(personalInformationDto.getMaritalStatus());
        updatePersonalInformation=personalInformationRepository.save(updatePersonalInformation);
        return mapStructMapper.personalInformationDto(updatePersonalInformation);

    }
    public void deletePersonalInformation(Long id)
    {

        personalInformationRepository.deleteById(id);
    }
}
