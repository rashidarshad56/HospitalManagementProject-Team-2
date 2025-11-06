package com.cg.hospital.controller;

import com.cg.hospital.dto.RoomDTO;
import com.cg.hospital.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // Get all rooms for a specific block floor and code
    @GetMapping("/{floor}/{code}")
    public List<RoomDTO> getRooms(@PathVariable Integer floor,
                                  @PathVariable Integer code) {
        return roomService.getRoomsByBlock(floor, code);
    }
}