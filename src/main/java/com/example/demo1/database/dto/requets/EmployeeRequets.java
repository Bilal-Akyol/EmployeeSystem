package com.example.demo1.database.dto.requets;

import com.example.demo1.entity.entities.Employee;
import com.example.demo1.entity.entities.OtherInformation;
import com.example.demo1.entity.entities.PersonalInformation;
import com.example.demo1.entity.entities.Project;
import com.example.demo1.entity.enums.ContractType;
import com.example.demo1.entity.enums.Level;
import com.example.demo1.entity.enums.Team;
import com.example.demo1.entity.enums.WorkType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequets {

    private String firstName;

    private String lastName;


    private Employee director;


    private Level level;


    private String phoneNumber;


    private String eMail;


    private WorkType workType;


    private ContractType contractType;


    private Team team;


    private LocalDate startDate;


    private LocalDate endDate;


    private PersonalInformation personalInformation;


    private OtherInformation otherInformation;


    private List<Project> project;
}
