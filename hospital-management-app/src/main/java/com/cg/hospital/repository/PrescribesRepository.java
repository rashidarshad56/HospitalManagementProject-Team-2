package com.cg.hospital.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.entity.Prescribes;
import com.cg.hospital.entity.PrescribesId;

public interface PrescribesRepository extends JpaRepository<Prescribes, PrescribesId>{
	List<Prescribes> findByPatient(Long patient);
}
