package com.example.demo1.database.repository;

import com.example.demo1.entity.entities.OtherInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherInformationRepository extends JpaRepository<OtherInformation,Long> {
}