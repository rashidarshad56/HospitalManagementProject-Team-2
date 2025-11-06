package com.cg.hospital.controller;

import com.cg.hospital.dto.DepartmentPhysicianResponseDTO;
import com.cg.hospital.service.PhysicianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/physicians")
public class PhysicianController {

    private final PhysicianService physicianService;

    public PhysicianController(PhysicianService physicianService) {
        this.physicianService = physicianService;
    }

    // ✅ Get physicians (name + position) for a department, along with department name
    @GetMapping("/department/{deptId}")
    public ResponseEntity<DepartmentPhysicianResponseDTO> getPhysiciansByDepartment(@PathVariable Integer deptId) {
        DepartmentPhysicianResponseDTO response = physicianService.getPhysiciansByDepartment(deptId);
        return ResponseEntity.ok(response);
    }
}
