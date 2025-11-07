package com.cg.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hospital.dto.PrescriptionDTO;
import com.cg.hospital.service.PrescribesService;

@RestController
@RequestMapping("/prescribes")
public class PrescribesController {
	@Autowired
    private PrescribesService prescribeService;

    @GetMapping("/{id}/prescriptions")
    public List<PrescriptionDTO> getPrescriptions(@PathVariable Long id) {
        return prescribeService.getPrescriptionsByPatientId(id);
    }
}
