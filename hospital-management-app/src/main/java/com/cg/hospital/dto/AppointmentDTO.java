package com.cg.hospital.dto;

import java.time.LocalDateTime;

import com.cg.hospital.entity.Patient;
import com.cg.hospital.entity.Physician;

public class AppointmentDTO {
	private int appointmentId;
	private Patient patient;
	private Physician physician;
	private LocalDateTime starto;
	private LocalDateTime endo;
	private String examinaionroom;
	
	public AppointmentDTO(int appointmentId, Patient patient, Physician physician, LocalDateTime starto,
			LocalDateTime endo, String examinaionroom) {
		super();
		this.appointmentId = appointmentId;
		this.patient = patient;
		this.physician = physician;
		this.starto = starto;
		this.endo = endo;
		this.examinaionroom = examinaionroom;
	}
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
	public String getExaminaionroom() {
		return examinaionroom;
	}
	public void setExaminaionroom(String examinaionroom) {
		this.examinaionroom = examinaionroom;
	}
}
