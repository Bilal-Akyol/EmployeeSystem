package com.example.demo1.validation;

import com.example.demo1.entity.entities.Employee;
import com.example.demo1.entity.entities.OtherInformation;
import com.example.demo1.mapstruct.dto.OtherInformationDto;
import com.example.demo1.repository.OtherInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OtherInformationValidator implements Validator {
    @Autowired
    OtherInformationRepository otherInformationRepository;

    public OtherInformationValidator(OtherInformationRepository otherInformationRepository) {
        this.otherInformationRepository = otherInformationRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return OtherInformationDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        OtherInformationDto otherInformationDto = (OtherInformationDto) target;

        if (otherInformationDto.getAddress() == null || otherInformationDto.getAddress().trim().isEmpty()) {
            errors.rejectValue("address", "NotBlank.otherInformationDto.address",
                    "Adres boş bırakılamaz lütfen adres yerini doldurun");
        } else if (otherInformationDto.getAddress().length() < 10) {
            errors.rejectValue("address", "Size.otherInformationDto.address",
                    "Adres 10 karakterden az olamaz");

        }
        if (otherInformationDto.getIbanNumber() == null || otherInformationDto.getIbanNumber().trim().isEmpty()) {
            errors.rejectValue("ibanNumber", "NotBlank.otherInformationDto.ibanNumber", "IBAN numarası zorunludur, size ait bir IBAN numarası giriniz");
        } else {
            // Güncellenen kaydın ID'sini kontrol et
            if (otherInformationDto.getId() != null) {
                // Mevcut kayıt varsa ve IBAN numarası mevcut kayıtla eşleşmiyorsa
                OtherInformation existingOtherInformation = otherInformationRepository.findById(otherInformationDto.getId()).orElse(null);
                if (existingOtherInformation != null && !existingOtherInformation.getIbanNumber().equals(otherInformationDto.getIbanNumber())) {
                    // Eğer IBAN numarası başka bir kayıtla çakışıyorsa
                    boolean ibanExists = otherInformationRepository.existsByIbanNumber(otherInformationDto.getIbanNumber());
                    if (ibanExists) {
                        errors.rejectValue("ibanNumber", "Unique.otherInformationDto.ibanNumber", "Bu IBAN numarası zaten kayıtlı");
                    }
                }
            }
            else {
                // ID yoksa yani yeni kayıt ise, benzersizliği kontrol et
                boolean ibanExists = otherInformationRepository.existsByIbanNumber(otherInformationDto.getIbanNumber());
                if (ibanExists) {
                    errors.rejectValue("ibanNumber", "Unique.otherInformationDto.ibanNumber", "Bu IBAN numarası zaten kayıtlı");
                }
            }
        }
    }
    }

