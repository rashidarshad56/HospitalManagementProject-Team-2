package com.cg.hospital.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hospital.entity.OnCall;
import com.cg.hospital.repository.OnCallRepository;

@Service
public class OnCallServiceImpl {

    private final OnCallRepository onCallRepository;

    public OnCallServiceImpl(OnCallRepository onCallRepository) {
        this.onCallRepository = onCallRepository;
    }

    public List<OnCall> getOnCallsByNurseId(int nurseId) {
        return onCallRepository.findByNurseId(nurseId);
    }
}