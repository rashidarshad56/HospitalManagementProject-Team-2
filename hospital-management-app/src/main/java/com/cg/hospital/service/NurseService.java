package com.cg.hospital.service;

import com.cg.hospital.entity.Nurse;
import com.cg.hospital.entity.OnCall;
import com.cg.hospital.repository.NurseRepository;
import com.cg.hospital.repository.OnCallRepository;

import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class NurseService {
    private final NurseRepository nurseRepository;
    private final OnCallRepository onCallRepository;

    public NurseService(NurseRepository nurseRepository, OnCallRepository onCallRepository) {
        this.nurseRepository = nurseRepository;
        this.onCallRepository = onCallRepository;
    }

    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    public Nurse getNurseById(Integer employeeId) {
        return nurseRepository.findById(employeeId).orElse(null);
    }

    public List<OnCall> getOnCallsForNurse(Integer employeeId) {
        return onCallRepository.findByNurseId(employeeId);
    }
}