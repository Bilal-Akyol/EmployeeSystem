package com.example.demo1.sevice;

import com.example.demo1.entity.OtherInformation;
import com.example.demo1.repository.OtherInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherInformationService {

    @Autowired
    private OtherInformationRepository otherInformationRepository;

    public OtherInformationService(OtherInformationRepository otherInformationRepository) {
        this.otherInformationRepository = otherInformationRepository;
    }

    public List<OtherInformation> getAllOtherInformation()
    {
        return otherInformationRepository.findAll();
    }

    public OtherInformation addOtherInformation(OtherInformation newOtherInformation)
    {
        return otherInformationRepository.save(newOtherInformation);
    }


}
