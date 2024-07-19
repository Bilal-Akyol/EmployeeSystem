package com.example.demo1.sevice;

import com.example.demo1.entity.PersonalInformation;
import com.example.demo1.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalInformationService {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public PersonalInformationService(PersonalInformationRepository personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }

    public List<PersonalInformation> getAllPersonalInformation()
    {
        return personalInformationRepository.findAll();
    }

    public PersonalInformation addPersonalInformation(PersonalInformation newPersonalInformation)
    {
        return personalInformationRepository.save(newPersonalInformation);
    }
}
