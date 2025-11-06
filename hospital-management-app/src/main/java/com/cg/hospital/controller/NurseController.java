package com.cg.hospital.controller;

import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.hospital.entity.Nurse;
import com.cg.hospital.entity.OnCall;
import com.cg.hospital.service.NurseService;

@RestController
@RequestMapping("/nurses")
public class NurseController {
    private final NurseService nurseService;

    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @GetMapping
    public List<Nurse> getAllNurses() {
        return nurseService.getAllNurses();
    }

    @GetMapping("/{employeeId}")
    public Map<String, Object> getNurseWithOnCalls(@PathVariable Integer employeeId) {
        Nurse nurse = nurseService.getNurseById(employeeId);
        if (nurse == null) return Map.of("message", "Nurse not found");

        List<OnCall> onCalls = nurseService.getOnCallsForNurse(employeeId);

        return Map.of(
            "EmployeeID", nurse.getEmployeeId(),
            "Name", nurse.getName(),
            "Position", nurse.getPosition(),
            "Registered", nurse.getRegistered(),
            "SSN", nurse.getSsn(),
            "OnCalls", onCalls
        );
    }
}