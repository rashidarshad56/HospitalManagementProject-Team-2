package com.cg.hospital.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	List<Appointment> findByPhysician_EmployeeId(int employeeId);
}
