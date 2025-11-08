package com.cg.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hospital.dto.AppointmentPatientDTO;
import com.cg.hospital.entity.Appointment;
import com.cg.hospital.exception.AppointmentNotFoundException;
import com.cg.hospital.repositories.AppointmentRepository;
import com.cg.hospital.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	 @Autowired
	    private AppointmentRepository appointmentRepository;

    @Override
    public List<AppointmentPatientDTO> getPatientsByPhysicianEmployeeId(int employeeId) {
    	List<Appointment> appointments = appointmentRepository.findByPhysician_EmployeeId(employeeId);
    	if (appointments.isEmpty()) {
            throw new AppointmentNotFoundException("No appointments found for physician");
        }

    	return appointmentRepository.findByPhysician_EmployeeId(employeeId)
	             .stream()
	             .map(a -> new AppointmentPatientDTO(
	            		 a.getPhysician().getName(),
	                     a.getAppointmentId(),
	                     a.getPatient().getName(),
	                     a.getPatient().getAddress(),
	                     a.getPatient().getPhone(),
	                     a.getStarto(),
	                     a.getEndo(),
	                     a.getExaminationRoom()
	             ))
	             .toList();
    	}
}


