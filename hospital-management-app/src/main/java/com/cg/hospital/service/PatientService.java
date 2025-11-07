package com.cg.hospital.service;

import java.util.List;

import com.cg.hospital.dto.AppointmentSummaryDTO;
import com.cg.hospital.entity.Patient;

public interface PatientService {
	List<Patient> getAllPatients();

	List<AppointmentSummaryDTO> getAppointmentsByPatientId(Integer ssn);

}
