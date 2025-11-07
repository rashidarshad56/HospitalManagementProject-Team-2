package com.cg.hospital.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hospital.dto.AppointmentPatientDTO;
import com.cg.hospital.entity.Appointment;
import com.cg.hospital.entity.Patient;
import com.cg.hospital.repository.AppointmentRepository;
import com.cg.hospital.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	 @Autowired
	    private AppointmentRepository appointmentRepository;


//    @Override
//    public List<Patient> getPatientsByPhysicianEmployeeId(int employeeId) {
//        return appointmentRepository.findByPhysician_EmployeeId(employeeId)
//                                    .stream()
//                                    .map(Appointment::getPatient)
//                                    .distinct()
//                                    .toList();
//    }
	 @Override
	 public List<AppointmentPatientDTO> getPatientsByPhysicianEmployeeId(int employeeId) {
	     return appointmentRepository.findByPhysician_EmployeeId(employeeId)
	             .stream()
	             .map(a -> new AppointmentPatientDTO(
	                     a.getAppointmentId(),
	                     a.getPatient().getName(),
	                     a.getPatient().getAddress(),
	                     a.getPatient().getPhone(),
	                     a.getStarto(),
	                     a.getEndo()
	             ))
	             .toList();
	 }
}



