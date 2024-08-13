package com.example.demo1.validation;

import com.example.demo1.entity.entities.Employee;
import com.example.demo1.mapstruct.dto.EmployeeDto;
import com.example.demo1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeValidator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;


        if (employeeDto.getFirstName() == null || employeeDto.getFirstName().trim().isEmpty()) {
            errors.rejectValue("firstName", "NotBlank.employeeDto.firstName", "İsim boş olamaz");
        }
        if (employeeDto.getLastName() == null || employeeDto.getLastName().trim().isEmpty()) {
            errors.rejectValue("lastName", "NotBlank.employeeDto.lastName", "Soy isim boş olamaz");
        }


        if (employeeDto.getPhoneNumber() == null || !employeeDto.getPhoneNumber().matches("\\d{11}")) {
            errors.rejectValue("phoneNumber", "Size.employeeDto.phoneNumber", "Telefon numarasını başına 0 yazınız");
        } else {
            if (employeeDto.getId() != null) {

                Employee existingEmployee = employeeRepository.findById(employeeDto.getId()).orElse(null);
                if (existingEmployee != null && !existingEmployee.getPhoneNumber().equals(employeeDto.getPhoneNumber())
                        && employeeRepository.existsByPhoneNumber(employeeDto.getPhoneNumber())) {
                    errors.rejectValue("phoneNumber", "Unique.employeeDto.phoneNumber", "Bu telefon numarası zaten kayıtlı.");
                }
            }
        }



        if (employeeDto.getEmail() == null || !employeeDto.getEmail().contains("@")) {
            errors.rejectValue("email", "Email.employeeDto.email", "Lütfen size ait bir mail giriniz");
        } else {

            if (employeeDto.getId() != null) {
                Employee existingEmployee = employeeRepository.findById(employeeDto.getId()).orElse(null);
                if (existingEmployee != null && !existingEmployee.getEmail().equals(employeeDto.getEmail())
                        && employeeRepository.existsByEmail(employeeDto.getEmail())) {
                    errors.rejectValue("email", "Unique.employeeDto.email", "Bu e-posta adresi zaten kayıtlı.");
                }
            }
        }


        if (employeeDto.getWorkType() == null) {
            errors.rejectValue("workType", "NotNull.employeeDto.workType", "Lütfen work type (Uzaktan, Ofisten, Hibrit) seçeneklerinden birini yazınız");
        }

        if (employeeDto.getContractType() == null) {
            errors.rejectValue("contractType", "NotNull.employeeDto.contractType", "Lütfen bu alanı kontrat tipini yazınız");
        }

        if (employeeDto.getTeam() == null) {
            errors.rejectValue("team", "NotNull.employeeDto.team", "Lütfen ait olduğunuz takımı yazınız");
        }

        if (employeeDto.getStartDate() != null && employeeDto.getEndDate() != null &&
                employeeDto.getEndDate().isBefore(employeeDto.getStartDate())) {
            errors.rejectValue("endDate", "FutureOrPresent.employeeDto.endDate", "Sözleşme bitiş tarihi başlangıç tarihinden önce olamaz");
        }
    }
}
