package com.cg.hospital.dto;

import java.util.List;

public class DepartmentPhysicianResponseDTO {

    private String departmentName;
    private List<PhysicianDTO> physicians;

    public DepartmentPhysicianResponseDTO(String departmentName, List<PhysicianDTO> physicians) {
        this.departmentName = departmentName;
        this.physicians = physicians;
    }

    public DepartmentPhysicianResponseDTO() {}

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<PhysicianDTO> getPhysicians() {
        return physicians;
    }

    public void setPhysicians(List<PhysicianDTO> physicians) {
        this.physicians = physicians;
    }
}
