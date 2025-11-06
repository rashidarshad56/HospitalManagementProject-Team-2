package com.cg.hospital.service;

import com.cg.hospital.entity.OnCall;
import com.cg.hospital.repository.OnCallRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OnCallService {
    private final OnCallRepository onCallRepository;

    public OnCallService(OnCallRepository onCallRepository) {
        this.onCallRepository = onCallRepository;
    }

    public OnCall saveOnCall(OnCall onCall) {
        return onCallRepository.save(onCall);
    }

    public List<OnCall> getAllOnCalls() {
        return onCallRepository.findAll();
    }
}