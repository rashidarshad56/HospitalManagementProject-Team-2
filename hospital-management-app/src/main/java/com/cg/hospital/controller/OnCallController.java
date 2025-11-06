package com.cg.hospital.controller;


import com.cg.hospital.service.OnCallService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/oncalls")
public class OnCallController {
    public OnCallController(OnCallService onCallService) {
    }

}