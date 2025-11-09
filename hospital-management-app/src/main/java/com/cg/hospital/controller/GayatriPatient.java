package com.cg.hospital.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hospital.entity.Patient;
import com.cg.hospital.service.PatientService;

@RestController
@RequestMapping("/patientsnew")
public class GayatriPatient {
	@Autowired
	private PatientService patientService;
 
	@GetMapping("/")
	public List<Patient> getAllPatients() {
	    return patientService.getAllPatients();
	}
 
}