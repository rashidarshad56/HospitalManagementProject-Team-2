package com.cg.hospital.dto;

import java.time.LocalDateTime;

public class PrescriptionDTO {

    private Long patientId;
    private String patientName;

    private String physicianName;
    private String physicianPosition;
    private String medicationName;
    private String dose;
    private LocalDateTime date;

    public PrescriptionDTO() {
    }

    

    public PrescriptionDTO(Long patientId, String patientName, String medicationName, String dose, LocalDateTime date,
                           String physicianName, String physicianPosition) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.medicationName = medicationName;
        this.dose = dose;
        this.date = date;
        this.physicianName = physicianName;
        this.physicianPosition = physicianPosition;
    }

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	public String getPhysicianPosition() {
		return physicianPosition;
	}

	public void setPhysicianPosition(String physicianPosition) {
		this.physicianPosition = physicianPosition;
	}
    
    
}