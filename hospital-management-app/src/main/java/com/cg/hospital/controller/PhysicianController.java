package com.cg.hospital.controller;

import com.cg.hospital.entity.Physician;
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

    @GetMapping("/department/{deptId}")
    public ResponseEntity<List<Physician>> getPhysiciansByDepartment(@PathVariable Integer deptId) {
        return ResponseEntity.ok(physicianService.getPhysiciansByDepartment(deptId));
    }
}