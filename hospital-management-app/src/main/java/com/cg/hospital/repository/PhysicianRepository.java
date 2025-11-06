package com.cg.hospital.repository;

import com.cg.hospital.entity.Physician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhysicianRepository extends JpaRepository<Physician, Integer> {

    List<Physician> findByAffiliationsDepartmentDepartmentId(Integer deptId);
}