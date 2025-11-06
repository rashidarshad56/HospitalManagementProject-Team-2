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
@Table(name = "physician")
public class Physician {

    @Id
    @Column(name = "EmployeeID")
    private Integer employeeId;
    
    @Column(name = "Name")
    private String name;

    @Column(name = "Position")
    private String position;

    @Column(name = "SSN")
    private Long ssn;

    @OneToMany(mappedBy = "physician", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Affiliation> affiliations = new ArrayList<>();

    public Physician() {}

    public Integer getEmployeeId() { return employeeId; }
    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Long getSsn() { return ssn; }
    public void setSsn(Long ssn) { this.ssn = ssn; }

    public List<Affiliation> getAffiliations() { return affiliations; }
    public void setAffiliations(List<Affiliation> affiliations) { this.affiliations = affiliations; }
}