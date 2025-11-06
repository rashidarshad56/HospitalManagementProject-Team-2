package com.cg.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hospital.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> { }