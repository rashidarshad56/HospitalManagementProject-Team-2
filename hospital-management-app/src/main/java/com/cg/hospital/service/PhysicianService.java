package com.cg.hospital.service;

import com.cg.hospital.entity.Physician;
import java.util.List;

public interface PhysicianService {
    List<Physician> getPhysiciansByDepartment(Integer departmentId);
}