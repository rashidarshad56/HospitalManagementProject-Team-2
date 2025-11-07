package com.cg.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	List<Appointment> findByPhysician_EmployeeId(int employeeId);
}
