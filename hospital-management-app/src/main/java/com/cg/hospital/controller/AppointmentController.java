package com.cg.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hospital.dto.AppointmentPatientDTO;
import com.cg.hospital.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

@Autowired
    private AppointmentService appointmentService;


@GetMapping("/patients/{employeeId}")
    public ResponseEntity<List<AppointmentPatientDTO>> getPatientsByPhysician(@PathVariable int employeeId) {
	  	List<AppointmentPatientDTO> result = appointmentService.getPatientsByPhysicianEmployeeId(employeeId);
	    return ResponseEntity.ok(result);
    }	
}
