package com.cg.hospital.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "On_Call")
public class OnCall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nurse")
    private Integer nurseId;

    @Column(name = "OnCallStart")
    private LocalDateTime onCallStart;

    @Column(name = "OnCallEnd")
    private LocalDateTime onCallEnd;

    @ManyToOne
    @JoinColumn(name = "Nurse", referencedColumnName = "EmployeeID", insertable = false, updatable = false)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Nurse nurse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNurseId() {
		return nurseId;
	}

	public void setNurseId(Integer nurseId) {
		this.nurseId = nurseId;
	}

	public LocalDateTime getOnCallStart() {
		return onCallStart;
	}

	public void setOnCallStart(LocalDateTime onCallStart) {
		this.onCallStart = onCallStart;
	}

	public LocalDateTime getOnCallEnd() {
		return onCallEnd;
	}

	public void setOnCallEnd(LocalDateTime onCallEnd) {
		this.onCallEnd = onCallEnd;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

    
}