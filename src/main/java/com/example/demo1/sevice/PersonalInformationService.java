package com.example.demo1.sevice;

import com.example.demo1.database.dto.requets.PersonalInfermationRequets;
import com.example.demo1.database.dto.response.PersonalInformationResponse;
import com.example.demo1.entity.entities.PersonalInformation;
import com.example.demo1.database.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalInformationService {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public PersonalInformationService(PersonalInformationRepository personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }

    public List<PersonalInformationResponse> getAllPersonalInformation()
    {
        List<PersonalInformation> personalInformations= personalInformationRepository.findAll();
        List<PersonalInformationResponse> personalInformationResponses=new ArrayList<>();
        for (PersonalInformation personalInformation:personalInformations)
        {
            PersonalInformationResponse reponseItem=new PersonalInformationResponse();
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

    public PersonalInformation addPersonalInformation(PersonalInfermationRequets personalInfermationRequets)
    {
        PersonalInformation personalInformation=new PersonalInformation();
        personalInformation.setBirthDate(personalInfermationRequets.getBirthDate());
        personalInformation.setNationalId(personalInfermationRequets.getNationalId());
        personalInformation.setMilitary(personalInfermationRequets.getMilitary());
        personalInformation.setGender(personalInfermationRequets.getGender());
        personalInformation.setMaritalStatus(personalInfermationRequets.getMaritalStatus());
        return personalInformationRepository.save(personalInformation);
    }
    public PersonalInformation updatePersonalInformation(Long id, PersonalInfermationRequets personalInformation)
    {
        PersonalInformation updatePersonalInformation= personalInformationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("İd bağlı kişisel veriler bulunmamaktadır"));
        updatePersonalInformation.setBirthDate(personalInformation.getBirthDate());
        updatePersonalInformation.setNationalId(personalInformation.getNationalId());
        updatePersonalInformation.setMilitary(personalInformation.getMilitary());
        updatePersonalInformation.setGender(personalInformation.getGender());
        updatePersonalInformation.setMaritalStatus(personalInformation.getMaritalStatus());
        return personalInformationRepository.save(updatePersonalInformation);

    }
}
