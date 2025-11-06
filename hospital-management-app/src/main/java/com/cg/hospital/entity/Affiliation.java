package com.cg.hospital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "affiliated_with")
public class Affiliation {

    @EmbeddedId
    private AffiliationId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("physician")
    @JoinColumn(name = "Physician")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Physician physician;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("department")
    @JoinColumn(name = "Department")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Department department;

    @Column(name = "PrimaryAffiliation")
    private Boolean primaryAffiliation;

    public Affiliation() {}

    public AffiliationId getId() { return id; }
    public void setId(AffiliationId id) { this.id = id; }

    public Physician getPhysician() { return physician; }
    public void setPhysician(Physician physician) { this.physician = physician; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Boolean getPrimaryAffiliation() { return primaryAffiliation; }
    public void setPrimaryAffiliation(Boolean primaryAffiliation) { this.primaryAffiliation = primaryAffiliation; }
}