package com.example.demo1.sevice;

import com.example.demo1.entity.OtherInformation;
import com.example.demo1.repository.OtherInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherInformationService {

    private final OtherInformationRepository otherInformationRepository;

    public OtherInformationService(OtherInformationRepository otherInformationRepository) {
        this.otherInformationRepository = otherInformationRepository;
    }

    public List<OtherInformation> getAllOtherInformation()
    {
        return otherInformationRepository.findAll();
    }
}
