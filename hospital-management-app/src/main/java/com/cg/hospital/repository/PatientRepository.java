package com.cg.hospital.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> { }