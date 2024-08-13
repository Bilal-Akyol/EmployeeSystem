package com.example.demo1.validation;

import com.example.demo1.mapstruct.dto.PersonalInformationDto;
import com.example.demo1.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class PersonalInformationValidator implements Validator {

    @Autowired
    PersonalInformationRepository personalInformationRepository;

    public PersonalInformationValidator(PersonalInformationRepository personalInformationRepository) {
        this.personalInformationRepository = personalInformationRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PersonalInformationDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        PersonalInformationDto personalInformationDto= (PersonalInformationDto) target;

        if (personalInformationDto.getNationalId() == null || personalInformationDto.getNationalId().trim().isEmpty()) {
            errors.rejectValue("nationalId", "NotBlank.personalInformationDto.nationalId", "Kimlik numarası zorunludur, Lütfen kimlik numaranızı yazınız");
        } else if (personalInformationDto.getNationalId().length() != 11) {
            errors.rejectValue("nationalId", "Size.personalInformationDto.nationalId", "Lütfen 11 haneli tc kimlik numaranızı giriniz");
        }

        if (personalInformationDto.getMilitary() == null) {
            errors.rejectValue("military", "NotNull.personalInformationDto.military", "Askerlik alanı boş bırakılamaz, Lütfen doldurunuz");
        }

        if (personalInformationDto.getGender() == null) {
            errors.rejectValue("gender", "NotNull.personalInformationDto.gender", "Cinsiyet alanı boş bırakılamaz, Lütfen doldurunuz");
        }

        if (personalInformationDto.getMaritalStatus() == null) {
            errors.rejectValue("maritalStatus", "NotNull.personalInformationDto.maritalStatus", "Medeni durum alanı boş bırakılamaz, Lütfen doldurunuz");
        }

        if (personalInformationDto.getBirthDate() == null) {
            errors.rejectValue("birthDate", "NotNull.personalInformationDto.birthDate", "Doğum tarihi alanı boş bırakılamaz, Lütfen doldurunuz");
        }
    }



}
