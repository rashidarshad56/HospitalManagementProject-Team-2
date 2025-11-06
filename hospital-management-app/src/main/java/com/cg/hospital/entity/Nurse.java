package com.cg.hospital.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Entity
@Table(name = "Nurse")
@JsonIgnoreProperties({"onCalls"})
public class Nurse {

    @Id
    @Column(name = "EmployeeID")
    private Integer employeeId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Position")
    private String position;

    @Column(name = "Registered")
    private Boolean registered;

    @Column(name = "SSN")
    private Integer ssn;

    @OneToMany(mappedBy = "nurse", cascade = CascadeType.ALL)
    private List<OnCall> onCalls;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Boolean getRegistered() {
		return registered;
	}

	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public List<OnCall> getOnCalls() {
		return onCalls;
	}

	public void setOnCalls(List<OnCall> onCalls) {
		this.onCalls = onCalls;
	}

    
}