package com.example.demo1.mapstruct.dto;

import com.example.demo1.entity.entities.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OtherInformationDto {

    private Long id;

    @Size(min = 3)
    @NotBlank(message = "Adres girilmesi zorunludur")
    private String address;

    private String bankName;
    @Size(min = 1)
    @NotBlank(message = "İban numarası zorunludur, size ait bir iban numarası giriniz")
    private String ibanNumber;

    private String emergencyContactName;


    private String emergencyContactNumber;

    private Employee employee;
}
