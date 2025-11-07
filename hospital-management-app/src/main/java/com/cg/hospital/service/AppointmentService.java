package com.cg.hospital.service;

import java.util.List;

import com.cg.hospital.dto.AppointmentPatientDTO;

public interface AppointmentService {
	List<AppointmentPatientDTO> getPatientsByPhysicianEmployeeId(int employeeId);	
}
