
package com.cg.hospital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @Column(name = "AppointmentID")
    private Integer appointmentId;

    @Column(name = "Patient")          // keep if column still exists in DB; if not, remove
    private Integer patientDeprecated; // optional placeholder; delete if you dropped it

    @Column(name = "Physician")
    private Integer physician;

    @Column(name = "PrepNurse")
    private Integer prepNurse;

    @Column(name = "Start")
    private LocalDateTime start;

    @Column(name = "End")
    private LocalDateTime end;

    @Column(name = "ExaminationRoom")
    private String examinationRoom;

    @ManyToMany(mappedBy = "appointments")
    @JsonIgnoreProperties("appointments")
    private Set<Patient> patients;
    //my appointment entity

    // getters/setters
    public Integer getAppointmentId() { return appointmentId; }
    public void setAppointmentId(Integer appointmentId) { this.appointmentId = appointmentId; }
    public Integer getPhysician() { return physician; }
    public void setPhysician(Integer physician) { this.physician = physician; }
    public Integer getPrepNurse() { return prepNurse; }
    public void setPrepNurse(Integer prepNurse) { this.prepNurse = prepNurse; }
    public LocalDateTime getStart() { return start; }
    public void setStart(LocalDateTime start) { this.start = start; }
    public LocalDateTime getEnd() { return end; }
    public void setEnd(LocalDateTime end) { this.end = end; }
    public String getExaminationRoom() { return examinationRoom; }
    public void setExaminationRoom(String examinationRoom) { this.examinationRoom = examinationRoom; }
    public Set<Patient> getPatients() { return patients; }
    public void setPatients(Set<Patient> patients) { this.patients = patients; }
}

