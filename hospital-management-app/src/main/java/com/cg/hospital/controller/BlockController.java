package com.cg.hospital.controller;

import com.cg.hospital.dto.BlockDTO;
import com.cg.hospital.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blocks")
public class BlockController {

    @Autowired
    private BlockService blockService;

    // Get all unique block floors
    @GetMapping
    public List<Integer> getAllBlockFloors() {
        return blockService.getAllBlockFloors();
    }

    // Get all block codes for a specific floor
    @GetMapping("/{floor}")
    public List<BlockDTO> getBlockCodesByFloor(@PathVariable Integer floor) {
        return blockService.getBlockCodesByFloor(floor);
    }
}