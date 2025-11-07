package com.cg.hospital.dto;

public class PhysicianDTO {
	
	private int employeeId;
	private String name;
	private String position;
	private int ssn;
	
	public PhysicianDTO() {
		
	}
	public PhysicianDTO(int employeeId, String name, String position, int ssn) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.position = position;
		this.ssn = ssn;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
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
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
}
