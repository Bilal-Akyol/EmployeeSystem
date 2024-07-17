package com.example.demo1.sevice;

import com.example.demo1.entity.PersonalInformation;
import com.example.demo1.repository.PersonalInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalInformationService {

    private final PersonalInformationRepository personalInformationRepository;

    public PersonalInformationService(PersonalInformationRepository personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }

    public List<PersonalInformation> getAllPersonalInformation()
    {
        return personalInformationRepository.findAll();
    }
}
