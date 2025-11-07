package com.cg.hospital.dto;

import java.time.LocalDateTime;

public class AppointmentSummaryDTO {
	    private Integer appointmentId;
	    private Integer patientId;
	    private LocalDateTime starto;
	    private LocalDateTime endo;
	    private String examinationRoom;

	    public AppointmentSummaryDTO(Integer appointmentId, Integer patientId, LocalDateTime starto, LocalDateTime endo, String examinationRoom) {
	        this.appointmentId = appointmentId;
	        this.patientId = patientId;
	        this.starto = starto;
	        this.endo = endo;
	        this.examinationRoom = examinationRoom;
	    }

	    // getters only (no setters needed for DTO)
	    public Integer getAppointmentId() { return appointmentId; }
	    public Integer getPatientId() { return patientId; }
	    public LocalDateTime getStarto() { return starto; }
	    public LocalDateTime getEndo() { return endo; }
	    public String getExaminationRoom() { return examinationRoom; }
	}
