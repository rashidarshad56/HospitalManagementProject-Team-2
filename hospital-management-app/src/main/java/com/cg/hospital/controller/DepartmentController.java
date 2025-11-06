package com.cg.hospital.controller;


//import com.cg.hospital.dto.DepartmentPhysicianResponseDTO;
import com.cg.hospital.entity.Department;
import com.cg.hospital.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin("*")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // 1️⃣ To show list of departments on first page
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    // 2️⃣ To show department name + physician name + position on second page
//    @GetMapping("/{deptId}/physicians")
//    public ResponseEntity<DepartmentPhysicianResponseDTO> getPhysiciansByDepartment(@PathVariable Integer deptId) {
//        return ResponseEntity.ok(departmentService.getPhysiciansByDepartment(deptId));
//    }
}
