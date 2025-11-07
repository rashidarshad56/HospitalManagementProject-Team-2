package com.cg.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hospital.entity.Stay;
import com.cg.hospital.service.StayService;

@RestController
@RequestMapping("/api/stay")
public class StayController {

    @Autowired
    private StayService stayService;

    @GetMapping("/")
    public List<Stay> getAllStays() {
        return stayService.getAllStays();
    }

    @GetMapping("/patient/{ssn}")
    public List<Stay> getStaysByPatientSsn(@PathVariable int ssn) {
        return stayService.getStaysByPatientSsn(ssn);
    }
}
