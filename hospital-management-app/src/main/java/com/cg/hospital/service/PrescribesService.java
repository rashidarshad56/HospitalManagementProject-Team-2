package com.cg.hospital.service;

import java.util.List;

import com.cg.hospital.dto.PrescriptionDTO;

public interface PrescribesService {
	List<PrescriptionDTO> getPrescriptionsByPatientId(int patientId);
}
