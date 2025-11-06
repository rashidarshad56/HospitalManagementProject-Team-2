package com.cg.hospital.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "DepartmentID")
    private Integer departmentId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Head")
    private Integer head;
    
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Affiliation> affiliations = new ArrayList<>();

    public Department() {}

    public Integer getDepartmentId() { return departmentId; }
    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getHead() { return head; }
    public void setHead(Integer head) { this.head = head; }

    public List<Affiliation> getAffiliations() { return affiliations; }
    public void setAffiliations(List<Affiliation> affiliations) { this.affiliations = affiliations; }
}
