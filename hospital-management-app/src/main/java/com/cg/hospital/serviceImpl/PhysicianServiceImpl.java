package com.cg.hospital.serviceImpl;

import com.cg.hospital.dto.DepartmentPhysicianResponseDTO;
import com.cg.hospital.dto.PhysicianDTO;
import com.cg.hospital.entity.Department;
import com.cg.hospital.entity.Physician;
import com.cg.hospital.repository.DepartmentRepository;
import com.cg.hospital.repository.PhysicianRepository;
import com.cg.hospital.service.PhysicianService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhysicianServiceImpl implements PhysicianService {

    private final PhysicianRepository physicianRepo;
    private final DepartmentRepository departmentRepo;

    public PhysicianServiceImpl(PhysicianRepository physicianRepo, DepartmentRepository departmentRepo) {
        this.physicianRepo = physicianRepo;
        this.departmentRepo = departmentRepo;
    }

@Override
public List<PhysicianDTO> getAllPhysicians() {
    return physicianRepo.findAllPhysicians();
}


    @Override
    public DepartmentPhysicianResponseDTO getPhysiciansByDepartment(Integer departmentId) {
        // Fetch the department
        Department dept = departmentRepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        // Fetch physicians linked to this department
        List<Physician> physicians = physicianRepo.findByAffiliationsDepartmentDepartmentId(departmentId);

        // Convert to DTO (only name & position)
        List<PhysicianDTO> physicianDTOs = physicians.stream()
                .map(p -> new PhysicianDTO(p.getEmployeeId(),p.getName(), p.getPosition()))
                .collect(Collectors.toList());

        // Return response with department name
        return new DepartmentPhysicianResponseDTO(dept.getName(), physicianDTOs);
    }
}
