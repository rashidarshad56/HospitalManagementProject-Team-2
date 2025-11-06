package com.cg.hospital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "SSN")
    private Integer ssn;

    @Column(name = "Name", length = 40)
    private String name;

    @Column(name = "Address", length = 40)
    private String address;

    @Column(name = "Phone", length = 30)
    private String phone;

    @Column(name = "InsuranceID")
    private Integer insuranceId;

    @Column(name = "PCP") // primary care physician (physician id)
    private Integer pcp;

    @ManyToMany
    @JoinTable(
        name = "patient_has_appointment",
        joinColumns = @JoinColumn(name = "patient_SSN", referencedColumnName = "SSN"),
        inverseJoinColumns = @JoinColumn(name = "appointment_AppointmentID", referencedColumnName = "AppointmentID")
    )
    @JsonIgnoreProperties("patients") // prevent infinite recursion in JSON
    private Set<Appointment> appointments;

    // getters/setters/constructors
    public Integer getSsn() { return ssn; }
    public void setSsn(Integer ssn) { this.ssn = ssn; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Integer getInsuranceId() { return insuranceId; }
    public void setInsuranceId(Integer insuranceId) { this.insuranceId = insuranceId; }
    public Integer getPcp() { return pcp; }
    public void setPcp(Integer pcp) { this.pcp = pcp; }
    public Set<Appointment> getAppointments() { return appointments; }
    public void setAppointments(Set<Appointment> appointments) { this.appointments = appointments; }
}
