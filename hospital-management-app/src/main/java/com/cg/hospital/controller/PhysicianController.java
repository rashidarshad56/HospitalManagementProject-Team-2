package com.cg.hospital.controller;

import com.cg.hospital.dto.DepartmentPhysicianResponseDTO;
import com.cg.hospital.dto.PhysicianDTO;
import com.cg.hospital.service.PhysicianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/physicians")
public class PhysicianController {

    private final PhysicianService physicianService;

    public PhysicianController(PhysicianService physicianService) {
        this.physicianService = physicianService;
    }

    // --- 1️⃣ Get all physicians ---
    @GetMapping
    public ResponseEntity<List<PhysicianDTO>> getAllPhysicians() {
        List<PhysicianDTO> physicians = physicianService.getAllPhysicians();
        return ResponseEntity.ok(physicians);
    }

    // --- 2️⃣ Get physicians by department ---
    @GetMapping("/department/{deptId}")
    public ResponseEntity<DepartmentPhysicianResponseDTO> getPhysiciansByDepartment(@PathVariable Integer deptId) {
        DepartmentPhysicianResponseDTO response = physicianService.getPhysiciansByDepartment(deptId);
        return ResponseEntity.ok(response);
    }
}
