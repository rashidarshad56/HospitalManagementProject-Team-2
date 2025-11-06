package com.cg.hospital.service;

import com.cg.hospital.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    List<RoomDTO> getRoomsByBlock(Integer blockFloor, Integer blockCode);
}