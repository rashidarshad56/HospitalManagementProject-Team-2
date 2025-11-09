package com.cg.hospital.serviceImpl;

import com.cg.hospital.entity.Department;
import com.cg.hospital.exception.DepartmentNotFoundException;
import com.cg.hospital.repository.DepartmentRepository;
import com.cg.hospital.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepo;

    public DepartmentServiceImpl(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = departmentRepo.findAll();

        // ✅ Check if the department list is empty
        if (departments.isEmpty()) {
            throw new DepartmentNotFoundException("No departments found in the database");
        }

        return departments;
    }
}
