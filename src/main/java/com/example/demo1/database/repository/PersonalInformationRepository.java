package com.example.demo1.database.repository;

import com.example.demo1.entity.entities.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation,Long> {
}
