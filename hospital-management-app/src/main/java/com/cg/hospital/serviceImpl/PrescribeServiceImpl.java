package com.cg.hospital.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hospital.dto.PrescriptionDTO;
import com.cg.hospital.entity.Prescribes;
import com.cg.hospital.repositories.PrescribesRepository;
import com.cg.hospital.service.PrescribesService;

@Service
public class PrescribeServiceImpl implements PrescribesService{
    @Autowired
    private PrescribesRepository prescribesRepo;

	@Override
	public List<PrescriptionDTO> getPrescriptionsByPatientId(Long patientId) {
		List<Prescribes> prescribes = prescribesRepo.findByPatient(patientId);
        return prescribes.stream()
            .map(p -> new PrescriptionDTO(
                p.getPatient(),
                p.getPatientDetails() != null ? p.getPatientDetails().getName() : "Unknown",
                p.getMedicationDetails() != null ? p.getMedicationDetails().getName() : "Unknown",
                p.getDose(),
                p.getDate(),
                p.getPhysicianDetails() != null ? p.getPhysicianDetails().getName() : "Unknown",
                p.getPhysicianDetails() != null ? p.getPhysicianDetails().getPosition() : "Unknown"
            ))
            .collect(Collectors.toList());
	}       
}
