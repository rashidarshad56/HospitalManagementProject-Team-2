package com.cg.hospital.serviceImpl;

import com.cg.hospital.entity.Physician;
import com.cg.hospital.repository.PhysicianRepository;
import com.cg.hospital.service.PhysicianService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicianServiceImpl implements PhysicianService {

    private final PhysicianRepository physicianRepo;

    public PhysicianServiceImpl(PhysicianRepository physicianRepo) {
        this.physicianRepo = physicianRepo;
    }

    @Override
    public List<Physician> getPhysiciansByDepartment(Integer departmentId) {
        return physicianRepo.findByAffiliationsDepartmentDepartmentId(departmentId);
    }
}