package com.cg.hospital.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Prescribes")
@IdClass(PrescribesId.class)
public class Prescribes {

    @Id
    @Column(name = "Patient")
    private Long patient;

    @Id
    @Column(name = "Medication")
    private Integer medication;

    @Id
    @Column(name = "Date")
    private LocalDateTime date;

    @Column(name = "Appointment")
    private Integer appointment;

    @Column(name = "Dose")
    private String dose;

    @ManyToOne
    @JoinColumn(name = "Medication", referencedColumnName = "Code", insertable = false, updatable = false)
    private Medication medicationDetails;

	public Long getPatient() {
		return patient;
	}

	public void setPatient(Long patient) {
		this.patient = patient;
	}

	public Integer getMedication() {
		return medication;
	}

	public void setMedication(Integer medication) {
		this.medication = medication;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getAppointment() {
		return appointment;
	}

	public void setAppointment(Integer appointment) {
		this.appointment = appointment;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public Medication getMedicationDetails() {
		return medicationDetails;
	}

	public void setMedicationDetails(Medication medicationDetails) {
		this.medicationDetails = medicationDetails;
	}
    
    

    // Getters and setters

}
