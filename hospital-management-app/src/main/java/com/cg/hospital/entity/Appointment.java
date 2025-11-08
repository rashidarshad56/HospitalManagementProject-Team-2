package com.cg.hospital.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @Column(name = "AppointmentID")
    private int appointmentId;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Patient", nullable = false)
//    @JsonIgnore                          // avoid recursion in JSON
//    private Patient patient1;

    @ManyToOne
    @JoinColumn(name = "Patient", referencedColumnName = "SSN") 
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "Physician", referencedColumnName = "EmployeeID") 
    private Physician physician;

    @Column(name = "PrepNurse") 
    private Integer prepNurse;

    @Column(name = "Starto")
    private LocalDateTime starto;

    @Column(name = "Endo")
    private LocalDateTime endo;

    @Column(name = "ExaminationRoom")
    private String examinationRoom;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public int getPrepNurse() {
		return prepNurse;
	}

	public void setPrepNurse(int prepNurse) {
		this.prepNurse = prepNurse;
	}

	public LocalDateTime getStarto() {
		return starto;
	}

	public void setStarto(LocalDateTime starto) {
		this.starto = starto;
	}

	public LocalDateTime getEndo() {
		return endo;
	}

	public void setEndo(LocalDateTime endo) {
		this.endo = endo;
	}

	public String getExaminationRoom() {
		return examinationRoom;
	}

	public void setExaminationRoom(String examinationRoom) {
		this.examinationRoom = examinationRoom;
	}
    
}



