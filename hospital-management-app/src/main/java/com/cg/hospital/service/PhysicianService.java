package com.cg.hospital.service;

import com.cg.hospital.dto.DepartmentPhysicianResponseDTO;
import com.cg.hospital.dto.PhysicianDTO;

import java.util.List;

public interface PhysicianService {
    List<PhysicianDTO> getAllPhysicians();
    DepartmentPhysicianResponseDTO getPhysiciansByDepartment(Integer departmentId);
}
