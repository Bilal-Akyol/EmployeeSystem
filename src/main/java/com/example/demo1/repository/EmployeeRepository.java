package com.example.demo1.repository;

import com.example.demo1.entity.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);



}
