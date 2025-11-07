package com.cg.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hospital.dto.AppointmentSummaryDTO;
import com.cg.hospital.entity.Patient;
import com.cg.hospital.repositories.PatientRepository;
import com.cg.hospital.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
    private PatientRepository patientRepository;

	@Override
	public List<Patient> getAllPatients() {
		 return patientRepository.findAll();
	}

	@Override
	public List<AppointmentSummaryDTO> getAppointmentsByPatientId(Integer ssn) {
		        Patient p = patientRepository.findById(ssn).orElseThrow();
		        // map to the required fields only
		        return p.getAppointments().stream()
		                .map(a -> new AppointmentSummaryDTO(
		                        a.getAppointmentId(),
		                        p.getSsn(),
		                        a.getStarto(),
		                        a.getEndo(),
		                        a.getExaminationRoom()
		                ))
		                .toList();
		}
	}
