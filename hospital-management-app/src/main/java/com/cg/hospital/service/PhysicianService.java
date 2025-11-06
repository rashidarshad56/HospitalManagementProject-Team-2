package com.cg.hospital.service;

import com.cg.hospital.dto.DepartmentPhysicianResponseDTO;

public interface PhysicianService {
    DepartmentPhysicianResponseDTO getPhysiciansByDepartment(Integer departmentId);
}
