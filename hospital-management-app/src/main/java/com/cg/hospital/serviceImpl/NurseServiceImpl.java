package com.cg.hospital.serviceImpl;

import com.cg.hospital.entity.Nurse;
import com.cg.hospital.exception.NurseNotFoundException;
import com.cg.hospital.repository.NurseRepository;
import org.springframework.stereotype.Service;

@Service
public class NurseServiceImpl {

    private final NurseRepository nurseRepository;

    public NurseServiceImpl(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public Nurse getNurseById(int nurseId) {
        return nurseRepository.findById(nurseId)
                .orElseThrow(() -> new NurseNotFoundException("Nurse with ID " + nurseId + " not found"));
    }
}