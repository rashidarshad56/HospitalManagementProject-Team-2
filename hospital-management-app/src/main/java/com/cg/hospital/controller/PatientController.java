package com.cg.hospital.controller;




import org.springframework.web.bind.annotation.*;

import com.cg.hospital.entity.Patient;
import com.cg.hospital.repository.PatientRepository;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientRepository repo;

    public PatientController(PatientRepository repo) {
        this.repo = repo;
    }

    // GET all patients (master table)
    @GetMapping
    public List<Patient> getAllPatients() {
        return repo.findAll(); // no custom query
    }

    // GET single patient by SSN
    @GetMapping("/{ssn}")
    public Patient getPatient(@PathVariable Integer ssn) {
        return repo.findById(ssn).orElseThrow();
    }

    // Optional: GET the appointments for a patient (still no custom query)
    @GetMapping("/{ssn}/appointments")
    public Object getAppointmentsForPatient(@PathVariable Integer ssn) {
        Patient p = repo.findById(ssn).orElseThrow();
        return p.getAppointments();
    }
}
