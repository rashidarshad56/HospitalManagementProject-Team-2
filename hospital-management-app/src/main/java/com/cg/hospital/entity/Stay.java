package com.cg.hospital.entity;
 
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
@Entity
@Table(name = "stay")
public class Stay {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stayId;
 
    // Reference patient using SSN instead of patientId
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patient", referencedColumnName = "ssn")
    private Patient patient;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room", referencedColumnName = "room_number")
    private Room room;
    @Column(name = "staystart_datetime")
    private LocalDateTime stayStartDatetime;
    @Column(name = "stayend_datetime")
    private LocalDate stayEndDatetime;
	public Long getStayId() {
		return stayId;
	}
	public void setStayId(Long stayId) {
		this.stayId = stayId;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public LocalDateTime getStayStartDatetime() {
		return stayStartDatetime;
	}
	public void setStayStartDatetime(LocalDateTime stayStartDatetime) {
		this.stayStartDatetime = stayStartDatetime;
	}
	public LocalDate getStayEndDatetime() {
		return stayEndDatetime;
	}
	public void setStayEndDatetime(LocalDate stayEndDatetime) {
		this.stayEndDatetime = stayEndDatetime;
	}
	
 
    // Getters and Setters
   
}
 